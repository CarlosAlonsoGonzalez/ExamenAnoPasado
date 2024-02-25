package com.example.examenanopasado.Examen1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioApiPeliculas {
    private static ServicioApiPeliculas instancia;
    private static RepoPelicula repo;

    private ServicioApiPeliculas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoPelicula.class);
    }
    public static RepoPelicula getRepo(){
        return repo;
    }

    public static ServicioApiPeliculas getInstancia() {
        if(instancia == null){
            instancia =  new ServicioApiPeliculas();
        }
        return instancia;
    }
}
