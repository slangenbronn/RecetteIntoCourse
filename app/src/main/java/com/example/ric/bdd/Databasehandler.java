package com.example.ric.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehandler extends SQLiteOpenHelper {

    public static final String USER_TABLE_CREATE = "CREATE TABLE User (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "password TEXT NOT NULL)";

    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS User;";

    public static final String RECETTE_TABLE_CREATE = "CREATE TABLE Recette (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "ingredients TEXT NOT NULL," +
            "preparation TEXT NOT NULL," +
            "step TEXT NOT NULL)";

    public static final String RECETTE_TABLE_DROP = "DROP TABLE IF EXISTS Recette;";


    public Databasehandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
        db.execSQL(RECETTE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(USER_TABLE_DROP);
        db.execSQL(RECETTE_TABLE_DROP);
        onCreate(db);
    }
}
