package com.example.eventorganisator;

import android.app.Application;

import com.example.eventorganisator.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    static MyApplication instance;

    static List<User> userList;

    public static List<User> getUserList() {
        return userList;
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
        userList.add(new User("root", "root@root", "rootroot"));
        instance = this;
    }
}
