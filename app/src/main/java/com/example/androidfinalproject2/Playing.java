package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidfinalproject2.databinding.ActivityPlayingBinding;

import org.json.JSONArray;

public class Playing extends AppCompatActivity {
    ActivityPlayingBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ActivityLevels.class);
                startActivity(intent);
            }
        });

        binding.level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),ActivityLevels.class);
                startActivity(intent);
            }
        });


    }
}