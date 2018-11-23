package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.dao.AgendaDAO;
import com.example.a17170086.universidadeacme.model.Agenda;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

public class AgendaCadastrarFragment extends Fragment {

    Button btn_salvar;
    EditText txt_titulo_agenda, txt_descricao_agenda, txt_data_agenda, txt_horario_agenda;
    String dataPassada;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }

    public static Fragment newInstance(String data) {
        AgendaCadastrarFragment itemAgenda = new AgendaCadastrarFragment();
        Bundle b = new Bundle();
        b.putString("data", data);

        itemAgenda.setArguments(b);
        return itemAgenda;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_agenda_cadastrar, container, false);

        //Armazenando os argumentos nas variáveis
        Bundle bundle = this.getArguments();
        if (bundle != null){
            dataPassada = bundle.getString("data");

        }

        //find view by id
        btn_salvar = v.findViewById(R.id.btn_salvar);
        txt_titulo_agenda = v.findViewById(R.id.txt_titulo_agenda);
        txt_descricao_agenda = v.findViewById(R.id.txt_descricao_agenda);
        txt_data_agenda = v.findViewById(R.id.txt_data_agenda);
        txt_horario_agenda = v.findViewById(R.id.txt_horario_agenda);

        txt_data_agenda.setText(dataPassada);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agenda a = new Agenda();

                //Adicionando campos
                a.setTitulo(txt_titulo_agenda.getText().toString());
                a.setDescricao(txt_descricao_agenda.getText().toString());
                a.setData(txt_data_agenda.getText().toString());
                a.setHorario(txt_horario_agenda.getText().toString());


                AgendaDAO.getInstance().inserir(getContext(), a);
                Toast.makeText(getContext(), "salvou", Toast.LENGTH_LONG).show();
                //finish();
            }
        });


        return v;
    }


}
