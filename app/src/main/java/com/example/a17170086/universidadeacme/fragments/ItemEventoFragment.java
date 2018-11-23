package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.model.Evento;

public class ItemEventoFragment  extends Fragment {

    Evento evento;
    TextView txt_titulo_item, txt_data_evento, txt_horario_evento, txt_local_evento, txt_subtitulo_item_evento;
    int id;
    String titulo_evento, horario_evento, local_evento, data_evento, descricao_evento;

    //Pegando os argumentos passados pelo bundle
    public static ItemEventoFragment newInstance(int idEvento, String titulo, String data, String horario, String local, String descricao){
        ItemEventoFragment itemEvento = new ItemEventoFragment();
        Bundle b = new Bundle();
        b.putInt("idEvento", idEvento);
        b.putString("titulo", titulo);
        b.putString("horario", horario);
        b.putString("local", local);
        b.putString("data", data);
        b.putString("descricao", descricao);

        itemEvento.setArguments(b);
        return itemEvento;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_evento, container, false);

        //Armazenando os argumentos nas variáveis
        Bundle bundle = this.getArguments();
        if (bundle != null){
            id = bundle.getInt("idEvento");
            titulo_evento = bundle.getString("titulo");
            horario_evento = bundle.getString("horario");
            local_evento = bundle.getString("local");
            data_evento = bundle.getString("data");
            descricao_evento = bundle.getString("descricao");
        }

        //Find view by id
        txt_titulo_item = v.findViewById(R.id.txt_titulo_item);
        txt_subtitulo_item_evento = v.findViewById(R.id.txt_subtitulo_item_evento);
        txt_data_evento = v.findViewById(R.id.txt_data_evento);
        txt_horario_evento = v.findViewById(R.id.txt_horario_evento);
        txt_local_evento = v.findViewById(R.id.txt_local_evento);

        //Atualizando conteúdo dos campos
        txt_titulo_item.setText(titulo_evento);
        txt_subtitulo_item_evento.setText(descricao_evento);
        txt_data_evento.setText(data_evento);
        txt_horario_evento.setText(horario_evento + "h");
        txt_local_evento.setText(local_evento);

        return v;
    }


}
