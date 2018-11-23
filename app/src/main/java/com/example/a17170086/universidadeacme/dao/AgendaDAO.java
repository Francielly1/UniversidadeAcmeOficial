package com.example.a17170086.universidadeacme.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a17170086.universidadeacme.model.Agenda;

import java.util.ArrayList;

public class AgendaDAO {

    ArrayList<Agenda> lstAgenda = new ArrayList<>();

    private Integer id = 0;

    Context context;

    /*Esquema de classe Singleton*/
    private static AgendaDAO instance;

    public static AgendaDAO getInstance() {
        //se não houver um evento, cria um novo
        if (instance == null) {
            instance = new AgendaDAO();
        }
        //se houver um evento, retorna o mesmo
        return instance;
    }

    /*MÉTODO INSERIR*/
    public Boolean inserir(Context context, Agenda agenda){

        //Acessar banco de dados
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", agenda.getTitulo());
        valores.put("descricao", agenda.getDescricao());
        valores.put("data", agenda.getData());
        valores.put("horario", agenda.getHorario());

        long id = db.insert("tbl_agenda", null, valores);

        //verifica de deu erro ou  não na hora de inserir
        if(id != -1){
            //confirma inserção
            return true;
        }else{
            return false;
        }
    }

    /*SELECIONAR UM EVENTO*/
    public Agenda selectionarUm(Context context, int id){

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql = "select * from tbl_agenda where _id =" +id;

        Cursor cursor= db.rawQuery(sql, null);

        if(cursor.getCount() > 0){

            cursor.moveToFirst();

            Agenda a = new Agenda();
            a.setId(cursor.getInt(0) /*acessando a coluna do ID*/);
            a.setTitulo(cursor.getString(1));
            a.setDescricao(cursor.getString(2));
            a.setData(cursor.getString(3));
            a.setHorario(cursor.getString(4));


            cursor.close();
            return a;

        }

        //retorna que não achou item
        return null;
    }

    /*MÉTODO ATUALIZAR*/
    public Boolean atualizar(Context context, Agenda a){

        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", a.getTitulo());
        valores.put("descricao", a.getDescricao());
        valores.put("data", a.getData());
        valores.put("horario", a.getHorario());

        db.update("tbl_agenda", valores, "_id=?", new String[]{a.getId().toString()});

        return true;
    }

    /*MÉTODO REMOVER*/
    public Boolean remover(Context context, Integer id){

        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();
        db.delete("tbl_agenda", "_id=?", new String[]{id.toString()});

        return true;
    }

    /*SELECIONAR TODOS OS EVENTOS - VISUALIZAR*/
    public ArrayList<Agenda> selecionarTodos(Context context){

        ArrayList<Agenda> retorno = new ArrayList<>();

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        String sql = "select * from tbl_agenda;";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Agenda a = new Agenda();
            a.setId(cursor.getInt(0));
            a.setTitulo(cursor.getString(1));
            a.setDescricao(cursor.getString(2));
            a.setData(cursor.getString(3));
            a.setHorario(cursor.getString(4));

            retorno.add(a);
        }
        return retorno;
    }
}
