package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidfinalproject2.RoomDataBase.Levels;
import com.example.androidfinalproject2.RoomDataBase.Pattern;
import com.example.androidfinalproject2.RoomDataBase.Puzzles;
import com.example.androidfinalproject2.RoomDataBase.Users;
import com.example.androidfinalproject2.RoomDataBase.ViewModel;
import com.example.androidfinalproject2.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity {
    ActivitySettingsBinding binding;
    boolean isplay=false;
    boolean Notifications=false;
    ViewModel viewModel;
    Levels levels;
    Pattern pattern;
    Users users;
    Puzzles puzzles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);

                if (!isplay) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ContextCompat.startForegroundService(getApplicationContext(),
                                intent);
                        stopService(intent);

                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            startForegroundService(intent);
                        }
                    }
                    isplay = true;
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        startForegroundService(intent);
                        isplay = false;
                    }


                }
            }
        });


        binding.switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JobScheduler scheduler=
                        (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                if (!Notifications){//اذا ما بييجي اشعارات خليه ييجي غير هيك اطفي
                    JobInfo jobInfo=null;
                    ComponentName componentName=new ComponentName(getBaseContext(),MyJobService.class);

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        Log.d("notificationTest", "onClick: im here ");
                        jobInfo=new JobInfo.Builder(101,componentName)
                                .setPeriodic(24*60*60*1000,5*60*1000)

                                .build();

                        Notifications=true;

                    }
                    scheduler.schedule(jobInfo);
                }else {
                    scheduler.cancel(101);
                    Notifications=false;
                }
            }
        });

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.deleteLevel(levels);
                viewModel.deletePattern(pattern);
                viewModel.deleteUser(users);
                viewModel.deletePuzzles(puzzles);

            }
        });


    }}








