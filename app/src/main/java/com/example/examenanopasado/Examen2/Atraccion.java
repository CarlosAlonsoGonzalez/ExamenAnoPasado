package com.example.examenanopasado.Examen2;

import java.io.Serializable;
import java.util.ArrayList;

public class Atraccion implements Serializable {
    public String nombre;
    public String descripcion;
    public int ocupantes;
    public Comentario[] comentarios;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public Comentario[] getComentarios() {
        return comentarios;
    }

    public static Atraccion generador(Atraccion atraccion){

        Atraccion apiAtraccion = new Atraccion();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (atraccion != null) {
            apiAtraccion = atraccion;
        }

        return apiAtraccion;
    }
}
