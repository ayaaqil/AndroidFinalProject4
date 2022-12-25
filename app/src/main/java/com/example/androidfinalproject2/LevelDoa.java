package com.example.androidfinalproject2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface LevelDoa {
    @Insert
    void insertLevel(Levels levels);
    @Update
    void updateLevel(Levels levels);

    @Delete
    void deleteLevel(Levels levels);

    @Query("select * from Levels ")
    LiveData<List<Levels>> getAllLevel();
}
