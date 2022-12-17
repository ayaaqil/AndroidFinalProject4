package com.example.androidfinalproject2;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConvirter {

    @TypeConverter
    public long getLong(Date date){
        return date.getTime();

    }

    @TypeConverter
    public Date getDate(Long date){
        return new Date(date);

    }
}
