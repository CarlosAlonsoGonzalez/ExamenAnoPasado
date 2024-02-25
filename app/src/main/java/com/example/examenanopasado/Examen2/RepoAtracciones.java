package com.example.examenanopasado.Examen2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoAtracciones {
    @GET("/api/atracciones/")
    Call<List<Atracciones>> getAtracciones();

    /*@GET("/api/atracciones/{id}")
    Call<Atraccion> getComentario(@Path("id") int id);

    @GET("/api/atracciones/")
    Call<Atraccion> getEstrellas(@Query("estrellas__gte")int estrellas);*/
}
