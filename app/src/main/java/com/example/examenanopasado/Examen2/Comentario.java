package com.example.examenanopasado.Examen2;

import java.io.Serializable;
import java.util.ArrayList;

public class Comentario implements Serializable {
    public String texto;

    public String getTexto() {
        return texto;
    }

    public static ArrayList<Comentario> generador(ArrayList<Comentario> listadoComentarios){

        ArrayList<Comentario> listadoApiComentarios = new ArrayList<Comentario>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoComentarios != null && !listadoComentarios.isEmpty()) {
            listadoApiComentarios.addAll(listadoComentarios);
        }

        return listadoApiComentarios;
    }
}
