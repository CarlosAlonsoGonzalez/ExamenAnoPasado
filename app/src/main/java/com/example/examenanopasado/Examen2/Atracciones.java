package com.example.examenanopasado.Examen2;

import java.io.Serializable;
import java.util.ArrayList;

public class Atracciones implements Serializable {
    public String nombre;
    public String descripcion;
    public int ocupantes;
    public String url;

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }


    public static ArrayList<Atracciones> generador(ArrayList<Atracciones> listadoAtracciones){

        ArrayList<Atracciones> listadoApiAtracciones = new ArrayList<Atracciones>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoAtracciones != null && !listadoAtracciones.isEmpty()) {
            listadoApiAtracciones.addAll(listadoAtracciones);
        }

        return listadoApiAtracciones;
    }

}
