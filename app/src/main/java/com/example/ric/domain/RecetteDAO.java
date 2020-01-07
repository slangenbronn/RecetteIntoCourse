package com.example.ric.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class RecetteDAO extends DAOBase{

    public static final String TABLE_NAME = "Recette";
    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String INGREDIENTS = "ingredients";
    public static final String PREPARATION = "preparation";
    public static final String STEP = "step";

    public static final String RECETTE_TABLE_CREATE = "CREATE TABLE Recette (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "ingredients TEXT NOT NULL," +
            "preparation TEXT NOT NULL," +
            "step TEXT NOT NULL)";

    public static final String RECETTE_TABLE_DROP = "DROP TABLE IF EXISTS Recette;";

    public RecetteDAO(Context pContext) {
        super(pContext);
    }

    public void ajouter(Recette r){
        ContentValues value = new ContentValues();
        value.put(RecetteDAO.NAME, r.getName());
        value.put(RecetteDAO.INGREDIENTS, r.getIngredients());
        value.put(RecetteDAO.PREPARATION, r.getPreparation());
        value.put(RecetteDAO.STEP, r.getStep());
        mDb.insert(RecetteDAO.TABLE_NAME, null, value);
    }

    public ArrayList<Recette> selectionerAllRecette (){
        final ArrayList<Recette> listRecette = new ArrayList<Recette>();
        Cursor c = mDb.rawQuery("select * from " + TABLE_NAME, new String[]{});
        Recette r = null;
        if(c.getCount() > 0){
            for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                r = new Recette(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                listRecette.add(r);
            }
            c.close();
        }

        return listRecette;
    }
}
