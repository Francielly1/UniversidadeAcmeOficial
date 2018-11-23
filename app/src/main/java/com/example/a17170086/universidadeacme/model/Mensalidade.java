package com.example.a17170086.universidadeacme.model;

public class Mensalidade {

    private int id;
    private String valor;
    private String data_vencimento;
    private int status;

    //construtor
    public Mensalidade(int id, String mes, String valor, String data_vencimento, int status) {
        this.setId(id);
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.status = status;

    }

    //get e set
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return data_vencimento;
    }

    public void setDataVencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
