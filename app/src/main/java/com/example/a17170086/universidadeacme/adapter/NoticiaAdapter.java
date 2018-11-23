package com.example.a17170086.universidadeacme.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.model.Noticia;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    public NoticiaAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Noticia>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item_noticia, parent, false);
        }

        TextView txt_item_titulo_noticia = v.findViewById(R.id.txt_item_titulo_noticia);
        TextView txt_item_subtitulo_noticia = v.findViewById(R.id.txt_item_subtitulo_noticia);
        ImageView img_item_noticia = v.findViewById(R.id.img_item_noticia);


        Noticia noticia = getItem(position);

        txt_item_titulo_noticia.setText(noticia.getTitulo());
        txt_item_subtitulo_noticia.setText(noticia.getSubTitulo());

        Picasso.get()
                .load(getContext().getString(R.string.URL_IMAGENS) +  noticia.getImagem())
                .into(img_item_noticia);


        return v;
    }
}
