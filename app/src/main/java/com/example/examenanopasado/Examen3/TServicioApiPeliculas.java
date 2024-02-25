package com.example.examenanopasado.Examen3;

import com.example.examenanopasado.Examen3.TRepoPelicula;
import com.example.examenanopasado.Examen3.TServicioApiPeliculas;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TServicioApiPeliculas {
    private static TServicioApiPeliculas instancia;
    private static TRepoPelicula repo;

    private TServicioApiPeliculas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(TRepoPelicula.class);
    }
    public static TRepoPelicula getRepo(){
        return repo;
    }

    public static TServicioApiPeliculas getInstancia() {
        if(instancia == null){
            instancia =  new TServicioApiPeliculas();
        }
        return instancia;
    }
}
