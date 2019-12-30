package com.example.ric;

import android.app.Application;
import android.content.Context;

import com.example.ric.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    static MyApplication instance;
    private static Context context;

    static List<User> userList;

    public static List<User> getUserList() {
        return userList;
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

    public static void setUserList(List<User> userList) {
        userList = userList;
    }

    public void addUser(User u){
        userList.add(u);
    }

    public static MyApplication getInstance(){
        if(instance == null){
            instance = new MyApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        userList = new ArrayList<User>();
        userList.add(new User(1,"root", "root@root", "rootroot"));
        MyApplication.context = getApplicationContext();
        instance = this;
    }
}
