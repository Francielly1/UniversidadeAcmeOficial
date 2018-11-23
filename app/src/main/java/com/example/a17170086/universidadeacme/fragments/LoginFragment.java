package com.example.a17170086.universidadeacme.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a17170086.universidadeacme.R;
import com.example.a17170086.universidadeacme.view.MainFragmentContract;

public class LoginFragment extends Fragment {

    Button btn_logar;

    MainFragmentContract mainActivity;
    public void configDependencias(MainFragmentContract mainActivity){
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //carregando o XML para a vaiavel v
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_login, container, false);

        //find view by id
        btn_logar = v.findViewById(R.id.btn_logar);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.abrirFragment(new EventoFragment());
            }
        });

        return v;
    }
}
