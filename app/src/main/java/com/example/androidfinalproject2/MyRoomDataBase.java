package com.example.androidfinalproject2;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Users.class}, version = 1, exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {

    public abstract UserDao daoUser();


    private static volatile MyRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDataBase.class, "Users_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

