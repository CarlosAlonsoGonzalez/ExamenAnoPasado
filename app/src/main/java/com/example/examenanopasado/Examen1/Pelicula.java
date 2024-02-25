package com.example.examenanopasado.Examen1;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
    public String nombre;
    public String descripcion;
    public int estrellas;
    public Actor[] actores;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public Actor[] getActores() {
        return actores;
    }

    public static ArrayList<Pelicula> generador(ArrayList<Pelicula> listadoPeliculas){

        ArrayList<Pelicula> listadoApiPeliculas= new ArrayList<Pelicula>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoPeliculas != null && !listadoPeliculas.isEmpty()) {
            listadoApiPeliculas.addAll(listadoPeliculas);
        }

        return listadoApiPeliculas;
    }
}
