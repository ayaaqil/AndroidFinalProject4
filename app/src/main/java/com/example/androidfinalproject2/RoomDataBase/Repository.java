package com.example.androidfinalproject2.RoomDataBase;

import android.app.Application;


import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private UserDoa userDao;
    private LevelDoa levelDoa;
    private PatternDao patternDao;
    private PuzzlesDoa puzzlesDoa;

    Repository(Application application){
        MyRoomDataBase db=MyRoomDataBase.getDatabase(application);
        userDao=db.daoUser();
        levelDoa= db.daoLevel();
        patternDao=  db.daoPattern();
        puzzlesDoa=db.daoPuzzles();
    }
    void insertUser(Users users){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertUser(users);
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


    void deleteUser(Users users){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.deleteUser(users);
            }
        });

    }


    LiveData<List<Users>> getAllUser(){
        return userDao.getAllUser();
    }


    void insertLevel(Levels levels){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDoa.insertLevel(levels);
            }
        });
    }

    void updateLevel(Levels levels){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDoa.deleteLevel(levels);
            }
        });
    }


    void deleteLevel(Levels levels){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDoa.deleteLevel(levels);
            }
        });
    }


    LiveData<List<Levels>> getAllLevel(){
        return levelDoa.getAllLevel();
    }

    void insertPattern(Pattern pattern){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternDao.insertPattern(pattern);
            }
        });
    }


    void updatePattern(Pattern pattern){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternDao.updatePattern(pattern);
            }
        });
    }


    void deletePattern(Pattern pattern){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternDao.deletePattern(pattern);
            }
        });
    }


    LiveData<List<Pattern>> getAllPattern(){
        return patternDao.getAllPattern();
    }


    void insertPuzzles(Puzzles puzzles){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzlesDoa.insertPuzzles(puzzles);
            }
        });
    }

    void updatePuzzles(Puzzles puzzles){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzlesDoa.updatePuzzles(puzzles);
            }
        });
    }


    void deletePuzzles(Puzzles puzzles){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzlesDoa.deletePuzzles(puzzles);
            }
        });
    }

    LiveData<List<Puzzles>> getAllPuzzles(){
        return puzzlesDoa.getAllPuzzles();
    }


}
