package com.example.ric.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ric.domain.ListeDAO;

public class Databasehandler extends SQLiteOpenHelper {

    public static final String USER_TABLE_CREATE = "CREATE TABLE User (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "password TEXT NOT NULL)";


    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS User;";

    public static final int DATABASE_VERSION = 2;


    public Databasehandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ListeDAO.LISTE_TABLE_CREATE);
        db.execSQL(USER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ListeDAO.LISTE_TABLE_DROP);
        db.execSQL(USER_TABLE_DROP);
        onCreate(db);
    }
}
