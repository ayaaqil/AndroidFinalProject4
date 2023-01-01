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
        myRepository = new Repository(application);
    }

    public void insertUser(Users users) {
        myRepository.insertUser(users);

    }

    public void updateUser(Users users) {
        myRepository.updateUser(users);

    }


    public void deleteUser(Users users) {
        myRepository.deleteUser(users);

    }


    public LiveData<List<Users>> getAllUser() {
        return myRepository.getAllUser();
    }

    public void insertLevel(Levels levels) {
        myRepository.insertLevel(levels);
    }

    public void updateLevel(Levels levels) {
        myRepository.updateLevel(levels);
    }


    public void deleteLevel(Levels levels) {
        myRepository.deleteLevel(levels);
    }


    public LiveData<List<Levels>> getAllLevel() {
        return myRepository.getAllLevel();
    }

    public void insertPattern(Pattern pattern) {
        myRepository.insertPattern(pattern);
    }


    public void updatePattern(Pattern pattern) {
        myRepository.updatePattern(pattern);
    }


    public void deletePattern(Pattern pattern) {
        myRepository.deletePattern(pattern);
    }


    public LiveData<List<Pattern>> getAllPattern() {
        return myRepository.getAllPattern();
    }


    public void insertPuzzles(Puzzles puzzles) {

        myRepository.insertPuzzles(puzzles);
    }

    public void updatePuzzles(Puzzles puzzles) {
        myRepository.updatePuzzles(puzzles);
    }


    public void deletePuzzles(Puzzles puzzles) {
        myRepository.deletePuzzles(puzzles);
    }

    public LiveData<List<Puzzles>> getAllPuzzles() {
        return myRepository.getAllPuzzles();
    }


}
