package com.example.androidfinalproject2.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UserDoa {
    @Insert
    void insertUser(Users users);
    @Update
    void updateUser(Users users);

    @Delete
    void deleteUser(Users users);

    @Query("select * from Users")
    LiveData<List<Users>> getAllUser();
}
