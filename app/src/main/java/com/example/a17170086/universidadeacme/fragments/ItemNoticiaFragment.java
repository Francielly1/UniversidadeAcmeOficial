package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.model.Noticia;
import com.squareup.picasso.Picasso;

public class ItemNoticiaFragment extends Fragment {

    Noticia noticia;
    TextView txt_titulo_item, txt_descricao_item, txt_subtitulo_item;
    ImageView img_item;

    String titulo_noticia, subtitulo_noticia, descricao_noticia, imagem;
    int id;

    //Pegando os argumentos passados pelo bundle
    public static Fragment newInstance(int idNoticia, String titulo, String subtitulo, String descricao, String imagem) {
        ItemNoticiaFragment itemNoticia = new ItemNoticiaFragment();
        Bundle b = new Bundle();
        b.putInt("idNoticia", idNoticia);
        b.putString("titulo", titulo);
        b.putString("subtitulo", subtitulo);
        b.putString("descricao", descricao);
        b.putString("imagem", imagem);

        itemNoticia.setArguments(b);
        return itemNoticia;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_item_noticia, container, false);

        //Armazenando os argumentos nas variáveis
        Bundle bundle = this.getArguments();
        if (bundle != null){
            id = bundle.getInt("idNoticia");
            titulo_noticia = bundle.getString("titulo");
            subtitulo_noticia = bundle.getString("subtitulo");
            descricao_noticia = bundle.getString("descricao");
            imagem = bundle.getString("imagem");
        }

        //Find view by id
        txt_titulo_item = v.findViewById(R.id.txt_titulo_item);
        txt_descricao_item = v.findViewById(R.id.txt_descricao_item);
        img_item = v.findViewById(R.id.img_item);
        txt_subtitulo_item = v.findViewById(R.id.txt_subtitulo_item);

        //Atualizando conteúdo dos campos
        txt_titulo_item.setText(titulo_noticia);
        txt_descricao_item.setText(descricao_noticia);
        txt_subtitulo_item.setText(subtitulo_noticia);

        Picasso.get()
                .load(getContext().getString(R.string.URL_IMAGENS) + imagem)
                .into(img_item);

        return v;
    }


}
