package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidfinalproject2.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity {
    ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}