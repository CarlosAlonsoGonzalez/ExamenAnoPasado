package com.example.examenanopasado.Examen2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioApiAtracciones {
    private static ServicioApiAtracciones instancia;
    private static RepoAtracciones repo;

    private ServicioApiAtracciones() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoAtracciones.class);
    }
    public static RepoAtracciones getRepo(){
        return repo;
    }

    public static ServicioApiAtracciones getInstancia() {
        if(instancia == null){
            instancia =  new ServicioApiAtracciones();
        }
        return instancia;
    }
}
