package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidfinalproject2.databinding.ActivityPlayingBinding;

public class Playing extends AppCompatActivity {
    ActivityPlayingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}