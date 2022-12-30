package com.example.androidfinalproject2.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;



import java.util.List;

@Dao
public interface PatternDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPattern(Pattern pattern);

    @Update
    void updatePattern(Pattern pattern);

    @Delete
    void deletePattern(Pattern pattern);

    @Query("select * from Pattern")
    LiveData<List<Pattern>> getAllPattern();
}
