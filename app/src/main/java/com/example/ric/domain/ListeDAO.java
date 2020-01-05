package com.example.ric.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ListeDAO extends DAOBase {

    public static final String TABLE_NAME = "Liste";
    public static final String KEY = "id";
    public static final String NAME = "name";

    public static final String USER_TABLE_CREATE = "CREATE TABLE " + ListeDAO.TABLE_NAME + " (" +
            ListeDAO.KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ListeDAO.NAME + " TEXT NOT NULL)";

    public static final String LISTE_TABLE_DROP = "DROP TABLE IF EXISTS Liste;";

    public ListeDAO(Context pContext) {
        super(pContext);
    }


    public void ajouter(Liste l) {
        ContentValues value = new ContentValues();
        value.put(UserDAO.NAME, l.getName());
        mDb.insert(UserDAO.TABLE_NAME, null, value);
    }

    public Liste selectionerUserName (int id){
        // TODO

        return null;
    }

    public boolean supprimer(Liste l){
        // TODO
        return false;
    }
}
