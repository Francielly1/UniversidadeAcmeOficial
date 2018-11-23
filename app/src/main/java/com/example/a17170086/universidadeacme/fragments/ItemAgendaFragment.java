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

public class ItemAgendaFragment extends Fragment {

    int id;
    String titulo, horario, data, descricao;
    TextView txt_t_agenda, txt_d_agenda, txt_dt_agenda, txt_h_agenda;
    //Button btn_excluir_agenda;

    //Pegando os argumentos passados pelo bundle
    public static ItemAgendaFragment newInstance(int id, String titulo, String descricao, String data, String horario){
        ItemAgendaFragment itemAgenda = new ItemAgendaFragment();
        Bundle b = new Bundle();
        b.putInt("idAgenda", id);
        b.putString("titulo", titulo);
        b.putString("descricao", descricao);
        b.putString("data", data);
        b.putString("horario", horario);

        itemAgenda.setArguments(b);
        return itemAgenda;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_agenda, container, false);

        //Armazenando os argumentos nas variáveis
        Bundle bundle = this.getArguments();
        if (bundle != null){
            id = bundle.getInt("idAgenda");
            titulo = bundle.getString("titulo");
            descricao = bundle.getString("descricao");
            data = bundle.getString("data");
            horario = bundle.getString("horario");
        }

        //find view by id
        txt_t_agenda = v.findViewById(R.id.txt_t_agenda);
        txt_d_agenda = v.findViewById(R.id.txt_d_agenda);
        txt_dt_agenda = v.findViewById(R.id.txt_dt_agenda);
        txt_h_agenda = v.findViewById(R.id.txt_h_agenda);
        //btn_excluir_agenda = v.findViewById(R.id.btn_excluir_agenda);

        //Atualizando conteúdo dos campos
        txt_t_agenda.setText(titulo);
        txt_d_agenda.setText(descricao);
        txt_dt_agenda.setText(data);
        txt_h_agenda.setText(horario);

        return v;
    }
}
