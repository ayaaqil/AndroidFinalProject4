package com.example.androidfinalproject2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PuzzlesDoa {

    @Insert
    void insertPuzzles(Puzzles puzzles);
    @Update
    void updatePuzzles(Puzzles puzzles);

    @Delete
    void deletePuzzles(Puzzles puzzles);

    @Query("select * from Puzzles ")
    LiveData<List<Puzzles>> getAllPuzzles();
}
