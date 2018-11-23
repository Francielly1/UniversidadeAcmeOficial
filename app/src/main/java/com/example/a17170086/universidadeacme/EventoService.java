package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Evento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventoService {
    @GET("api/evento/listar_evento.php")
    Call<List<Evento>> getEvento();
}
