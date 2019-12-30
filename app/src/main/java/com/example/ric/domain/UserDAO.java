package com.example.ric.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserDAO extends DAOBase {

    public static final String TABLE_NAME = "user";
    public static final String KEY = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String USER_TABLE_CREATE = "CREATE TABLE User (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "password TEXT NOT NULL)";

    public static final String USER_TABLE_DROP = "DROP TABLE IF EXISTS User;";

    public UserDAO(Context pContext) {
        super(pContext);
    }

    public void ajouter(User u){
        ContentValues value = new ContentValues();
        value.put(UserDAO.NAME, u.getName());
        value.put(UserDAO.EMAIL, u.getEmail());
        value.put(UserDAO.PASSWORD, u.getPassword());
        mDb.insert(UserDAO.TABLE_NAME, null, value);
    }

    public User selectionerUserName (String userName){
        Cursor c = mDb.rawQuery("select * from " + TABLE_NAME + " where name = ?", new String[]{userName});
        User u = null;
        if(c.getCount() > 0){
            c.moveToFirst();
            u = new User(c.getLong(0), c.getString(1), c.getString(2), c.getString(3));
        }

        return u;
    }
}
