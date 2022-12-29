package Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {
    private String codImagen;
    private String urlImagen;
    private String nombrePais;
    private String capitalPais;
    private String prefijoPais;
    private String urlInfo;

    public String getCodImagen() {
        return codImagen;
    }

    public void setCodImagen(String codImagen) {
        this.codImagen = codImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public String getPrefijoPais() {
        return prefijoPais;
    }

    public void setPrefijoPais(String prefijoPais) {
        this.prefijoPais = prefijoPais;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public Pais(JSONObject a) throws JSONException {
        codImagen =  a.getString("BD").toString();
        urlImagen =  "http://www.geognos.com/api/en/countries/flag/"+codImagen+".png";
        nombrePais =  a.getString("Name").toString();
        capitalPais =  a.getString("Capital").toString();
        prefijoPais =  a.getString("TelPref").toString();
        urlInfo =  a.getString("CountryInfo").toString();
    }

    public static ArrayList<Pais> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Pais> pais = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            pais.add(new Pais(datos.getJSONObject(i)));
        }
        return pais;
    }

}
