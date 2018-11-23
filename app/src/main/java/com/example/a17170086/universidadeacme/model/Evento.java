package com.example.a17170086.universidadeacme.model;

import com.google.gson.annotations.SerializedName;

public class Evento {

    @SerializedName("id_eventos")
    private int id;
    private String titulo;
    private String descricao;
    private String horario;
    private String local;
    private String data;
    private String imagem;

    //construtor
    public Evento(int id, String titulo, String descricao, String horario, String local, String data, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.horario = horario;
        this.local = local;
        this.data = data;
        this.setImagem(imagem);
    }

    //get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
