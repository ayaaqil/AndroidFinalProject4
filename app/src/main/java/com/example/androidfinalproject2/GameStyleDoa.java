package com.example.androidfinalproject2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameStyleDoa {
    @Insert
    void insertGameStyle(Game_style game_style);
    @Update
    void updateGameStyle(Game_style game_style);

    @Delete
    void deleteGameStyle(Game_style game_style);

    @Query("select * from Game_style ")
    LiveData<List<Game_style>> getAllGameStyle();

}
