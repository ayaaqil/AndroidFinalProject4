package com.example.androidfinalproject2.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository myRepository;
    public ViewModel(@NonNull Application application) {
        super(application);
        myRepository=new Repository(application);
    }

    void insertUser(Users users){
       myRepository.insertUser(users);

    }

    void updateUser(Users users){
      myRepository.updateUser(users);

    }


    void deleteUser(Users users){
    myRepository.deleteUser(users);

    }


    LiveData<List<Users>> getAllUser(){
        return myRepository.getAllUser();
    }

    void insertLevel(Levels levels){
      myRepository.insertLevel(levels);
    }

    void updateLevel(Levels levels){
      myRepository.updateLevel(levels);
    }


    void deleteLevel(Levels levels){
   myRepository.deleteLevel(levels);
    }


    LiveData<List<Levels>> getAllLevel(){
        return myRepository.getAllLevel();
    }

    void insertPattern(Pattern pattern){
      myRepository.insertPattern(pattern);
    }


    void updatePattern(Pattern pattern){
     myRepository.updatePattern(pattern);
    }


    void deletePattern(Pattern pattern){
       myRepository.deletePattern(pattern);
    }


    LiveData<List<Pattern>> getAllPattern(){
        return myRepository.getAllPattern();
    }


    public void insertPuzzles(Puzzles puzzles){

        myRepository.insertPuzzles(puzzles);
    }

    void updatePuzzles(Puzzles puzzles){
     myRepository.updatePuzzles(puzzles);
    }


    void deletePuzzles(Puzzles puzzles){
      myRepository.deletePuzzles(puzzles);
    }

    LiveData<List<Puzzles>> getAllPuzzles(){
        return myRepository.getAllPuzzles();
    }



}
