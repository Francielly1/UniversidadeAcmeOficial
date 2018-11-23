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
import com.example.a17170086.universidadeacme.model.Agenda;

import java.util.ArrayList;

public class AgendaAdapter extends ArrayAdapter<Agenda>{


    public AgendaAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Agenda>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item_agenda, parent, false);
        }

        TextView txtTitulo = v.findViewById(R.id.txt_titulo_item_agenda);
        TextView txtData = v.findViewById(R.id.txt_data_item_agenda);

        final Agenda agenda = getItem(position);

        txtTitulo.setText(agenda.getTitulo());
        txtData.setText(agenda.getData());

        return v;
    }

}
