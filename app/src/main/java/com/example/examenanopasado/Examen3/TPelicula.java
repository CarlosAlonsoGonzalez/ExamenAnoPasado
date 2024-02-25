package com.example.examenanopasado.Examen3;

import java.io.Serializable;
import java.util.ArrayList;

public class TPelicula implements Serializable {
    public String nombre;
    public String descripcion;
    public int estrellas;
    public TActor[] actores;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public TActor[] getActores() {
        return actores;
    }

    public static ArrayList<TPelicula> generador(ArrayList<TPelicula> listadoPeliculas){

        ArrayList<TPelicula> listadoApiPeliculas= new ArrayList<TPelicula>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoPeliculas != null && !listadoPeliculas.isEmpty()) {
            listadoApiPeliculas.addAll(listadoPeliculas);
        }

        return listadoApiPeliculas;
    }
}
