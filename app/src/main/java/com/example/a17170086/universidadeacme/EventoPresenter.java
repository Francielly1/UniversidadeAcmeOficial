package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Evento;
import com.example.a17170086.universidadeacme.view.EventoView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventoPresenter {

    EventoView eventoView;
    EventoService service;

    public EventoPresenter(EventoView eventoView, EventoService service){
        this.eventoView = eventoView;
        this.service = service;
    }

    public void carregarEvento(){

        //chamada ao endpoint que retorna todos os eventos
        Call<List<Evento>> call = service.getEvento();

        call.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                //chamada deu certo

                //Pegando o retorno do servidor
                List<Evento> retornoApi = response.body();

                //Log.d("teste", retornoApi+"");
                eventoView.exibirEvento(retornoApi);

            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                //deu algum erro
                //mensalidadeView.ex("Erro de rede");
            }
        });

    }
}
