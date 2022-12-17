package com.example.androidfinalproject2;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private UserDao userDao;


    Repository(Application application) {
        MyRoomDataBase db = MyRoomDataBase.getDatabase(application);
        userDao = db.daoUser();

    }

    void insertUser(Users users){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(users);
            }
        });

    }

    void deleteUser(Users users){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteUser(users);
            }
        });

    }

    void updateUser(Users users){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.updateUser(users);
            }
        });

    }


    LiveData<List<Users>> getAllUsers(){
        return userDao.getAllUser();

    }

}
