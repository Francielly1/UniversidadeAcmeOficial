package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a17170086.universidadeacme.MensalidadePresenter;
import com.example.a17170086.universidadeacme.MensalidadeService;
import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.adapter.MensalidadeAdapter;
import com.example.a17170086.universidadeacme.model.Mensalidade;
import com.example.a17170086.universidadeacme.view.MensalidadeView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinanceiroFragment extends Fragment implements AdapterView.OnItemClickListener, MensalidadeView{

    ListView list_view_mensalidade;

    MensalidadeAdapter mensalidadeAdapter;
    MensalidadeService service;
    MensalidadeView mensalidadeView = this;
    MensalidadePresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_financeiro, container, false);

        //Find view by id
        list_view_mensalidade = v.findViewById(R.id.list_view_mensalidade);

        //configurando o adapter
        mensalidadeAdapter = new MensalidadeAdapter(getContext());
        list_view_mensalidade.setAdapter(mensalidadeAdapter);

        //configurando o click da lista
        list_view_mensalidade.setOnItemClickListener(this);

        //Configurar o Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_BASE))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instanciando o serviço
        service = retrofit.create(MensalidadeService.class);

        //instanciando o presenter
        presenter = new MensalidadePresenter(mensalidadeView, service);

        //carregar mensalidades
        presenter.carregarMensalidade();

        list_view_mensalidade = v.findViewById(R.id.list_view_mensalidade);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void exibirMensalidades(List<Mensalidade> mensalidades) {
        //limpando o listview
        mensalidadeAdapter.clear();

        //adicionando as mesalidades na tela
        mensalidadeAdapter.addAll(mensalidades);
    }
}
