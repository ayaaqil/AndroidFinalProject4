package com.example.androidfinalproject2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository myRepostory;
    public ViewModel(@NonNull Application application) {
        super(application);
        myRepostory = new Repository(application);
    }

    void insertUser(Users users){
        myRepostory.insertUser(users);
    }
    void deleteUser(Users users){
        myRepostory.deleteUser(users);
    }
    void updateUser(Users users) {
        myRepostory.updateUser(users);
    }
    LiveData<List<Users>> getAllUsers(){
        return myRepostory.getAllUsers();

        }}
