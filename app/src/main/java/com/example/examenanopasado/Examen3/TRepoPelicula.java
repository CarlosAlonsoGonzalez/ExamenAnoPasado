package com.example.examenanopasado.Examen3;

import com.example.examenanopasado.Examen1.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TRepoPelicula {
    @GET("/api/peliculas_related/")
    Call<List<TPelicula>> getPeliculas();


    @GET("/api/peliculas_related/?format=json")
    Call<List<TPelicula>> getPeliculas(@Query("estrellas") int num);

}
