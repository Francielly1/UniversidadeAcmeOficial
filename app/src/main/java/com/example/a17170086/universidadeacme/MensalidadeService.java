package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Mensalidade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MensalidadeService {

    @GET("api/mensalidade/selecionar.php")
    Call<List<Mensalidade>> getMensalidades();

}
