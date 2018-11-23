package com.example.a17170086.universidadeacme.model;

import com.google.gson.annotations.SerializedName;

public class Noticia {

    private int id;
    private String titulo;
    private String subtitulo;
    private String descricao;

    @SerializedName("foto")
    private String imagem;


    //construtor
    public Noticia(int id, String titulo, String subtitulo, String descricao, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descricao = descricao;
        this.imagem = imagem;
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

    public String getSubTitulo() {
        return subtitulo;
    }

    public void setSubTitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
