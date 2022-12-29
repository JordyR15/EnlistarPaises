package com.example.enlistarpaises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.PaisAdapter;
import Model.Pais;
import Utiles.ErrorLog;

public class MainActivity extends AppCompatActivity {

    private TextView responseTV;
    RecyclerView paisrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            /*revistarecicle = (RecyclerView) findViewById(R.id.revista_recicle);
            revistarecicle.setHasFixedSize(true);
            revistarecicle.setLayoutManager(new LinearLayoutManager(this));
            revistarecicle.setItemAnimator(new DefaultItemAnimator());*/

            // ...

            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url ="http://www.geognos.com/api/en/countries/info/all.json";

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ArrayList<Pais> pais = new ArrayList<Pais> ();
                            try {
                                JSONArray JSONlistaRevista=  new JSONArray(response);
                                pais = Pais.JsonObjectsBuild(JSONlistaRevista);

                                /*int resId = R.anim.layout_animation_down_to_up;
                                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                        resId);
                                revistarecicle.setLayoutAnimation(animation);*/

                                ErrorLog.info(response);
                                /*PaisAdapter paisadaptador = new PaisAdapter(getApplicationContext(), pais);
                                paisrecycler.setAdapter(paisadaptador);*/

                            } catch (JSONException e) {
                                ErrorLog.info(e.getMessage());
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    ErrorLog.error(error.getMessage());
                    Toast.makeText(getApplicationContext(),  error.getMessage(), Toast.LENGTH_LONG).show();
                    //TextView txtvolley = findViewById(R.id.txtlista);
                }
            });

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
    }

}