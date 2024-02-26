package com.example.examenanopasado.Examen4;

import com.example.examenanopasado.Examen4.RepoBares;
import com.example.examenanopasado.Examen4.ServicioApiBares;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioApiBares {
    private static ServicioApiBares instancia;
    private static RepoBares repo;

    private ServicioApiBares() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoBares.class);
    }
    public static RepoBares getRepo(){
        return repo;
    }

    public static ServicioApiBares getInstancia() {
        if(instancia == null){
            instancia =  new ServicioApiBares();
        }
        return instancia;
    }
}
