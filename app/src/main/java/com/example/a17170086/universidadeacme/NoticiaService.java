package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Noticia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NoticiaService {

    @GET("api/noticia/listar_noticia.php")
    Call<List<Noticia>> getNoticia();
}
