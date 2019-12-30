package com.example.ric.domain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ric.bdd.Databasehandler;

public abstract class DAOBase {

    protected final static int VERSION = 1;
    // Le nom du fichier qui représente ma base
    protected final static String NOM = "database.db";

    protected SQLiteDatabase mDb = null;
    protected Databasehandler mHandler = null;

    public DAOBase(Context pContext) {
        this.mHandler = new Databasehandler(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}
