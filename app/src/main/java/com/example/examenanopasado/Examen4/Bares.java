package com.example.examenanopasado.Examen4;

import com.example.examenanopasado.Examen4.Bares;

import java.io.Serializable;
import java.util.ArrayList;

public class Bares implements Serializable {
    public String url;
    public String nombre;
    public String descripcion;
    public int estrellas;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public static ArrayList<Bares> generador(ArrayList<Bares> listadoBares){

        ArrayList<Bares> listadoApiBares= new ArrayList<Bares>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoBares != null && !listadoBares.isEmpty()) {
            listadoApiBares.addAll(listadoBares);
        }

        return listadoApiBares;
    }
}
