package com.example.examenanopasado.Examen1;

import java.io.Serializable;
import java.util.ArrayList;

public class Actor implements Serializable {
    public String url;
    public String nombre;
    public String pelicula;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public static ArrayList<Actor> generador(ArrayList<Actor> listadoActores){

        ArrayList<Actor> listadoApiActores= new ArrayList<Actor>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoActores != null && !listadoActores.isEmpty()) {
            listadoApiActores.addAll(listadoActores);
        }

        return listadoApiActores;
    }
}
