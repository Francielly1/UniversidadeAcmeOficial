package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Boletim;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BoletimService {
    @GET("api/acompanhamento/selecionar.php")
    Call<List<Boletim>> getBoletim();
}
