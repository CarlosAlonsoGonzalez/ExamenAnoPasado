package com.example.examenanopasado.Examen2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioApiAtraccion {
    private static ServicioApiAtraccion instancia;
    private static RepoAtraccion repo;

    private ServicioApiAtraccion() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoAtraccion.class);
    }
    public static RepoAtraccion getRepo(){
        return repo;
    }

    public static ServicioApiAtraccion getInstancia() {
        if(instancia == null){
            instancia =  new ServicioApiAtraccion();
        }
        return instancia;
    }
}
