package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.enlistarpaises.R;
import com.bumptech.glide.Glide;

import java.util.List;

import Model.Pais;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {
    private Context Ctx;
    private List<Pais> lista_pais;

    public PaisAdapter(Context mCtx, List<Pais> pais) {
        this.lista_pais = pais;
        Ctx = mCtx;
    }

    @Override
    public PaisAdapter.PaisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_paises, null);
        return new PaisAdapter.PaisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PaisAdapter.PaisViewHolder holder, int position) {
        Pais pais = lista_pais.get(position);
        holder.textViewNrevista.setText(pais.getNombrePais());

        Glide.with(Ctx)
                .load(pais.getUrlImagen())
                .into(holder.imageportada);

        /*holder.imageportada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pais item = lista_revistas.get(holder.getAdapterPosition());
                Intent intent = new Intent(Ctx, actvidadVolumenes.class);
                Bundle b = new Bundle();
                b.putString("id",item.getJournal_id());
                intent.putExtras(b);
                Ctx.startActivity(intent);
                //Toast.makeText(Ctx, "You clicked " + item.getTitulo(), Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return lista_pais.size();
    }

    class PaisViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNrevista;
        ImageView imageportada;
        public PaisViewHolder(View itemView) {
            super(itemView);
            /*textViewNrevista = itemView.findViewById(R.id.txtnombrerevista);
            imageportada = itemView.findViewById(R.id.imgportada);*/
        }

    }

}