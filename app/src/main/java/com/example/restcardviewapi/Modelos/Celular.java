package com.example.restcardviewapi.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Celular {
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    private String titulo;
    private String descripcion;
    private String precio;
    private String urlimagen;

    public ArrayList<String> getFotos() {
        return imagenes;
    }

    public void setFotos(ArrayList<String> fotos) {
        this.imagenes = fotos;
    }

    private ArrayList<String> imagenes;


    public Celular(JSONObject a) throws JSONException {
        titulo = a.getString("title").toString();
        descripcion = a.getString("description").toString();
        precio = a.getString("price").toString() ;
        urlimagen = a.getString("thumbnail").toString() ;
        JSONArray fotos = a.getJSONArray("images");
        imagenes = new ArrayList<>();
        for (int i=0;i<fotos.length();i++){
            imagenes.add(fotos.getString(i));
        }

    }

    public static ArrayList<Celular> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Celular> cell = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            cell.add(new Celular(datos.getJSONObject(i)));

        }
        return cell;
    }
}

