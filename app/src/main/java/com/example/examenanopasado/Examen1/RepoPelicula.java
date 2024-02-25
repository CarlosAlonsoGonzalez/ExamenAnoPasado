package com.example.examenanopasado.Examen1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoPelicula {
    @GET("/api/peliculas_related/")
    Call<List<Pelicula>> getPeliculas();
}
