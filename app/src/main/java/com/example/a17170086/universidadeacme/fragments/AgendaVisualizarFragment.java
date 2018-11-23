package com.example.a17170086.universidadeacme.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.adapter.AgendaAdapter;
import com.example.a17170086.universidadeacme.dao.AgendaDAO;
import com.example.a17170086.universidadeacme.model.Agenda;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

import java.util.ArrayList;

public class AgendaVisualizarFragment extends Fragment  implements AdapterView.OnItemClickListener {

    ListView lst_agenda;
    AgendaAdapter adapter;
    AgendaDAO dao;
    Button btn_exluir_agenda;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_agenda_visualizar, container, false);

        //find view by id
        lst_agenda = v.findViewById(R.id.lst_agenda);


        /*CRIANDO LISTA*/
        //Pegando Instancia do DAO
        dao = AgendaDAO.getInstance();

        //configurando o adapter
        adapter = new AgendaAdapter(getContext());
        lst_agenda.setAdapter(adapter);

        //configurando o click da lista
        lst_agenda.setOnItemClickListener(this);


        return v;
    }

    /*ATUALIZANDO PÁGINA INDEPENDENTE DO BOTÃO UTILLIZADO PARA VOLTAR*/
    @Override
    public void onResume() {
        //Pegando os contatos do banco
        ArrayList<Agenda> agendaCadastradas;
        agendaCadastradas = dao.selecionarTodos(getContext());

        //limpar o conteudo
        adapter.clear();

        //preenchendo o adaptador com os dados atualizados
        adapter.addAll(agendaCadastradas);
        super.onResume();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "clicou", Toast.LENGTH_SHORT).show();

        //Abrindo nova fragment e passando parâmetros
        Agenda agendaClicada = adapter.getItem(position);
        Fragment itemAgenda = ItemAgendaFragment.newInstance(
                agendaClicada.getId(), agendaClicada.getTitulo(), agendaClicada.getDescricao(), agendaClicada.getData(), agendaClicada.getHorario());

        mainActivity.abrirFragment(itemAgenda);
    }
}
