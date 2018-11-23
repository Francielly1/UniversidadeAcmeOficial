package com.example.a17170086.universidadeacme;

import com.example.a17170086.universidadeacme.model.Boletim;
import com.example.a17170086.universidadeacme.view.BoletimView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoletimPresenter {

    BoletimView boletimView;
    BoletimService service;

    public BoletimPresenter(BoletimView boletimView, BoletimService service){
        this.boletimView = boletimView;
        this.service = service;
    }

    public void carregarBoletim(){

        //chamada ao endpoint que retorna o boletim
        Call<List<Boletim>> call = service.getBoletim();

        call.enqueue(new Callback<List<Boletim>>() {
            @Override
            public void onResponse(Call<List<Boletim>> call, Response<List<Boletim>> response) {
                //chamada deu certo

                //Pegando o retorno do servidor
                List<Boletim> retornoApi = response.body();

                //Log.d("teste", retornoApi+"");
                boletimView.exibirBoletim(retornoApi);

            }

            @Override
            public void onFailure(Call<List<Boletim>> call, Throwable t) {
                //deu algum erro
                //mensalidadeView.ex("Erro de rede");
            }
        });

    }

}
