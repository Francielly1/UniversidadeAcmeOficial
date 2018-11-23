package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a17170086.universidadeacme.NoticiaPresenter;
import com.example.a17170086.universidadeacme.NoticiaService;
import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.adapter.NoticiaAdapter;
import com.example.a17170086.universidadeacme.model.Noticia;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;
import com.example.a17170086.universidadeacme.view.NoticiaView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiaFragment extends Fragment implements AdapterView.OnItemClickListener, NoticiaView {

    ListView list_view_noticias;
    NoticiaService service;
    NoticiaAdapter noticiaAdapter;
    NoticiaPresenter presenter;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = getLayoutInflater().from(getContext()).inflate(R.layout.fragment_noticia, container, false);

        //Find view by id
        list_view_noticias = v.findViewById(R.id.list_view_noticias);

        //configurando o adapter
        noticiaAdapter = new NoticiaAdapter(getContext());
        list_view_noticias.setAdapter(noticiaAdapter);

        //configurando o click da lista
        list_view_noticias.setOnItemClickListener(this);

        //Configurar o Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_BASE))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instanciando o serviço
        service = retrofit.create(NoticiaService.class);

        //instanciando o presenter
        presenter = new NoticiaPresenter(this, service);

        //carregar noticia
        presenter.carregarNoticia();

        list_view_noticias = v.findViewById(R.id.list_view_noticias);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Toast.makeText(getContext(), "teste oie", Toast.LENGTH_SHORT).show();

        //Abrindo nova fragment e passando parâmetros
        Noticia noticiaClicada = noticiaAdapter.getItem(position);
        Fragment itemNoticia = ItemNoticiaFragment
                .newInstance(noticiaClicada.getId(), noticiaClicada.getTitulo(), noticiaClicada.getSubTitulo(), noticiaClicada.getDescricao(), noticiaClicada.getImagem());

        mainActivity.abrirFragment(itemNoticia);

    }

    @Override
    public void exibirNoticia(List<Noticia> noticia) {
        //limpando o listview
        noticiaAdapter.clear();

        //adicionando as noticia na tela
        noticiaAdapter.addAll(noticia);

    }
}
