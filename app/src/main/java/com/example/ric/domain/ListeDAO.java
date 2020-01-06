package com.example.ric.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ListeDAO extends DAOBase {

    public static final String TABLE_NAME = "Liste";
    public static final String KEY = "id";
    public static final String NAME = "name";

    public static final String LISTE_TABLE_CREATE = "CREATE TABLE " + ListeDAO.TABLE_NAME + " (" +
            ListeDAO.KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ListeDAO.NAME + " TEXT NOT NULL)";

    public static final String LISTE_TABLE_DROP = "DROP TABLE IF EXISTS Liste;";

    public ListeDAO(Context pContext) {
        super(pContext);
    }


    public void ajouter(Liste l) {
        ContentValues value = new ContentValues();
        value.put(ListeDAO.NAME, l.getName());
        mDb.insert(ListeDAO.TABLE_NAME, null, value);
    }

    public Liste selectionerListeName (String name){
        Cursor c = mDb.rawQuery("select * from " + TABLE_NAME + " where " + NAME + " = ?", new String[] {name});
        Liste l = null;
        if(c.getCount() > 0){
            c.moveToFirst();
            l = new Liste(c.getLong(0), c.getString(1));
        }

        return l;
    }

    public boolean supprimer(Liste l){
        // TODO
        return false;
    }
}
