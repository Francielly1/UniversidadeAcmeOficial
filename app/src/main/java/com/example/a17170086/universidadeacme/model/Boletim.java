package com.example.a17170086.universidadeacme.model;

public class Boletim {

    private int id;
    private String disciplina;
    private Integer nota;
    private Integer falta;
    private String semestre;

    //construtor
    public Boletim(int id, String disciplina, int nota, int falta, String semestre) {
        this.setId(id);
        this.disciplina = disciplina;
        this.nota = nota;
        this.falta = falta;
        this.semestre = semestre;

    }

    //get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
    }
}
