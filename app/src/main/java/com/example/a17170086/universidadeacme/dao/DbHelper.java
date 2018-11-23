package com.example.a17170086.universidadeacme.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    //nome
    private static String DB_NAME = "agenda.db";
    //versão
    private static int DB_VERSION = 1;
    //construtor
    public DbHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tabela Agenda
        String sql = "create table tbl_agenda(" +
                "_id INTEGER primary key autoincrement," +
                "titulo VARCHAR(255)," +
                "descricao TEXT," +
                "data VARCHAR(15)," +
                "horario VARCHAR(10));";

        //executa no banco
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table tbl_agenda");
        onCreate(db);
    }
}
