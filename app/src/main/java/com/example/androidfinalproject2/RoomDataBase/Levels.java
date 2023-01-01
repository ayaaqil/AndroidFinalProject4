package com.example.androidfinalproject2.RoomDataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Levels {
    @PrimaryKey
    @ColumnInfo(name = "LevelId")
    int Level_id;
    int Level_score;

    public Levels() {
    }

    public Levels(int level_score) {
        Level_score = level_score;
    }

    public Levels(int level_id, int level_score) {
        Level_id = level_id;
        Level_score = level_score;
    }

    public int getLevel_id() {
        return Level_id;
    }

    public void setLevel_id(int level_id) {
        Level_id = level_id;
    }

    public int getLevel_score() {
        return Level_score;
    }

    public void setLevel_score(int level_score) {
        Level_score = level_score;
    }
}
