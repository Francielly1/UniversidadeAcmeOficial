package com.example.a17170086.universidadeacme.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.model.Evento;

import java.util.ArrayList;

public class EventoAdapter extends ArrayAdapter<Evento> {

    public EventoAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Evento>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item_evento, parent, false);
        }

        TextView txt_dia_item_evento = v.findViewById(R.id.txt_dia_item_evento);
        TextView txt_mes_item_evento = v.findViewById(R.id.txt_mes_item_evento);
        TextView txt_titulo_evento = v.findViewById(R.id.txt_titulo_evento);

        Evento evento = getItem(position);

        //Formatando data
        String data = evento.getData().toString();
        String[] item_data = data.split("/");
        String day = item_data[0];
        String item = item_data[1];

        int month=0;
        month = Integer.parseInt(item);
        String mes = null;
        switch(month) {
            case 1:
                mes = "JAN";
                break;
            case 2:
                mes = "FEV";
                break;
            case 3:
                mes = "MAR";
                break;
            case 4:
                mes = "ABR";
                break;
            case 5:
                mes = "MAIO";
                break;
            case 6:
                mes = "JUN";
                break;
            case 7:
                mes = "JUL";
                break;
            case 8:
                mes = "AGO";
                break;
            case 9:
                mes = "SET";
                break;
            case 10:
                mes = "OUT";
                break;
            case 11:
                mes = "NOV";
                break;
            case 12:
                mes = "DEZ";
                break;

        }

        txt_dia_item_evento.setText(day);
        txt_mes_item_evento.setText(mes.toString());
        txt_titulo_evento.setText(evento.getTitulo());

        return v;
    }
}
