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

import com.example.a17170086.universidadeacme.EventoPresenter;
import com.example.a17170086.universidadeacme.EventoService;
import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.adapter.EventoAdapter;
import com.example.a17170086.universidadeacme.model.Evento;
import com.example.a17170086.universidadeacme.view.EventoView;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventoFragment extends Fragment implements AdapterView.OnItemClickListener, EventoView {

    ListView list_view_eventos;
    EventoService service;
    EventoAdapter eventoAdapter;
    EventoPresenter presenter;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = getLayoutInflater().from(getContext()).inflate(R.layout.fragment_evento, container, false);

        //Find view by id
        list_view_eventos = v.findViewById(R.id.list_view_eventos);

        //configurando o adapter
        eventoAdapter = new EventoAdapter(getContext());
        list_view_eventos.setAdapter(eventoAdapter);

        //configurando o click da lista
        list_view_eventos.setOnItemClickListener(this);

        //Configurar o Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_BASE))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instanciando o serviço
        service = retrofit.create(EventoService.class);

        //instanciando o presenter
        presenter = new EventoPresenter(this, service);

        //carregando evento
        presenter.carregarEvento();

        list_view_eventos = v.findViewById(R.id.list_view_eventos);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Toast.makeText(getContext(), "teste oie", Toast.LENGTH_SHORT).show();

        //Abrindo nova fragment e passando parâmetros
        Evento eventoClicado = eventoAdapter.getItem(position);
        Fragment itemEvento = ItemEventoFragment
                .newInstance(eventoClicado.getId(), eventoClicado.getTitulo(), eventoClicado.getData(), eventoClicado.getHorario(), eventoClicado.getLocal(), eventoClicado.getDescricao());

        mainActivity.abrirFragment(itemEvento);
    }

    @Override
    public void exibirEvento(List<Evento> evento) {

        //limpando o listview
        eventoAdapter.clear();

        //adicionando os eventos na tela
        eventoAdapter.addAll(evento);

    }

}
