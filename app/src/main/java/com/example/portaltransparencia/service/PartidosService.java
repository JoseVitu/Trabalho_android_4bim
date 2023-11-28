package com.example.portaltransparencia.service;

import com.example.portaltransparencia.dto.PartidoDTO;
import com.example.portaltransparencia.response.PartidoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PartidosService {
    @GET("partidos")
    Call<PartidoResponse> listarPartidos(@Query("pagina") int pagina, @Query("itens") int itens);

    @GET("partidos/{id}")
    Call<PartidoDTO> obterDetalhesPartido(@Path("id") int id);
}

