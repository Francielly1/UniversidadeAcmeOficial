package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Noticia;
import com.example.a17170086.universidadeacme.view.NoticiaView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticiaPresenter {

    NoticiaView noticiaView;
    NoticiaService service;

    public NoticiaPresenter(NoticiaView noticiaView, NoticiaService service){
        this.noticiaView = noticiaView;
        this.service = service;
    }

    public void carregarNoticia(){

        //chamada ao endpoint que retorna todos as noticias
        Call<List<Noticia>> call = service.getNoticia();

        call.enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                //chamada deu certo

                //Pegando o retorno do servidor
                List<Noticia> retornoApi = response.body();

                //Log.d("teste", retornoApi+"");
                noticiaView.exibirNoticia(retornoApi);

            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                //deu algum erro
                //mensalidadeView.ex("Erro de rede");
            }
        });

    }
}
