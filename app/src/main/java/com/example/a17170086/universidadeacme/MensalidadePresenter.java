package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Mensalidade;
import com.example.a17170086.universidadeacme.view.MensalidadeView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MensalidadePresenter {

    MensalidadeView mensalidadeView;
    MensalidadeService service;

    public MensalidadePresenter(MensalidadeView mensalidadeView, MensalidadeService service){
        this.mensalidadeView = mensalidadeView;
        this.service = service;
    }

    public void carregarMensalidade(){

        //chamada ao endpoint que retorna todas as mensalidades
        Call<List<Mensalidade>> call = service.getMensalidades();

        call.enqueue(new Callback<List<Mensalidade>>() {
            @Override
            public void onResponse(Call<List<Mensalidade>> call, Response<List<Mensalidade>> response) {
                //chamada deu certo

                //Pegando o retorno do servidor
                List<Mensalidade> retornoApi = response.body();

                //Log.d("teste", retornoApi+"");
                mensalidadeView.exibirMensalidades(retornoApi);

            }

            @Override
            public void onFailure(Call<List<Mensalidade>> call, Throwable t) {
                //deu algum erro
                //mensalidadeView.ex("Erro de rede");
            }
        });
    }
}
