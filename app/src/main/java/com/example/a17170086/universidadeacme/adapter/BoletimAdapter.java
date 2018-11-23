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
import com.example.a17170086.universidadeacme.model.Boletim;

import java.util.ArrayList;

public class BoletimAdapter extends ArrayAdapter<Boletim> {

    public BoletimAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Boletim>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item_boletim, parent, false);
        }

        TextView txtDisciplina = v.findViewById(R.id.txt_disciplina);
        TextView txtNota = v.findViewById(R.id.txt_nota);
        TextView txtFalta = v.findViewById(R.id.txt_falta);

        Boletim boletim = getItem(position);

        txtDisciplina.setText(boletim.getDisciplina());
        txtNota.setText(boletim.getNota().toString());
        txtFalta.setText(boletim.getFalta().toString());

        return v;
    }
}
