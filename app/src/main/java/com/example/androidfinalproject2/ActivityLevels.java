package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidfinalproject2.databinding.ActivityLevelsBinding;

public class ActivityLevels extends AppCompatActivity {
    ActivityLevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}