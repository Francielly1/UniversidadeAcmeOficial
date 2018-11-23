package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.model.Agenda;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

public class AgendaFragment extends Fragment {

    Button btn_cadastrar, btn_visualizar_agenda;
    CalendarView calendarView;
    TextView data;
    String passarData;

    Agenda agenda;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_agenda, container, false);

        //find view by id
        btn_cadastrar = v.findViewById(R.id.btn_cadastrar);
        btn_visualizar_agenda = v.findViewById(R.id.btn_visualizar_agenda);
        calendarView = v.findViewById(R.id.calendar_view);
        data = v.findViewById(R.id.mostra_data);

        //Click date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                int mes = month + 1;
                String dia = String.valueOf(day);
                if (dia.length() == 1){
                    dia = "0"+dia;
                }

                String dataSelecionada = ""+dia+"/"+mes+"/"+year;
                data.setText(dataSelecionada);
            }

        });


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //armazena data na variável para passar para fragment de cadastro
                passarData = data.getText().toString();

                //Abrindo nova fragment e passando parâmetros
                Fragment itemAgenda = AgendaCadastrarFragment
                        .newInstance(passarData);

                mainActivity.abrirFragment(itemAgenda);
            }
        });

        btn_visualizar_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgendaVisualizarFragment visualziar = new AgendaVisualizarFragment();
                visualziar.configDependencias(mainActivity);

                mainActivity.abrirFragment(visualziar);
            }
        });


        return v;
    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;

        //mainActivity.abrirFragment(new AgendaCadastrarFragment());
    }*/

    /*public void abrirCadastrar(View view){

        mainActivity.abrirFragment(new AgendaCadastrarFragment());
    }*/
}
