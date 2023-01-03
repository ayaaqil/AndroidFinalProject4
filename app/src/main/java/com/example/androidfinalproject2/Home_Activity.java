package com.example.androidfinalproject2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.androidfinalproject2.RoomDataBase.Levels;
import com.example.androidfinalproject2.RoomDataBase.Pattern;
import com.example.androidfinalproject2.RoomDataBase.Puzzles;
import com.example.androidfinalproject2.RoomDataBase.ViewModel;
import com.example.androidfinalproject2.databinding.ActivityHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Home_Activity extends AppCompatActivity {
    ActivityHomeBinding binding;
    MediaPlayer mediaPlayer;
    ViewModel viewModel;
    JSONArray jsonArray;
    List<Levels> levelsList;
    String jsonString;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClick();
        levelsList = new ArrayList<>();
        viewModel = new ViewModel(getApplication());
        int static_number = 0;
        viewModel.getAllLevel().observe(this, new Observer<List<Levels>>() {
            @Override
            public void onChanged(List<Levels> levels) {

                if (levels.size() <= 0) {
                    jsonString = UtilString.readFormats(getApplicationContext(), "puzzleGameData.json");
                    parsejsonstring(jsonString);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            add_petterns();

                        }
                    }, 1000);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            add_puzzle();

                        }
                    }, 3000);

                } else {
                    levelsList = levels;
                }
            }
        });

        Intent intent = new Intent(getBaseContext(), MyService.class);
        startForegroundService(intent);

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);


            }
        });
        binding.btnSettinges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Settings.class);
                startActivity(intent);
            }
        });
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Playing.class);
                // intent.putExtra("id",String.valueOf(id));
                startActivity(intent);

            }
        });
        binding.btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                public void logOut() {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Home_Activity.this);
                alertDialogBuilder.setTitle("Exit Application?");
                alertDialogBuilder
                        .setMessage("Are you sure you want to exit the application?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
//            }
        });


    }

    private void parsejsonstring(String jsonString) {
        try {
            jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                // ArrayList<question> questionsArrayList = new ArrayList<>();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int level_no = jsonObject.getInt("level_no");
                int unlock_points = jsonObject.getInt("unlock_points");
                Log.d("Error_check", "" + level_no);
                Levels levels = new Levels(level_no, unlock_points);
                viewModel.insertLevel(levels);
            }/*
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ArrayList<question> questionsArrayList = new ArrayList<>();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int level_no = jsonObject.getInt("level_no");
                            JSONArray questions_array = jsonObject.getJSONArray("questions");
                            for (int j = 0; j < questions_array.length(); j++) {
                                JSONObject jsonObject1 = questions_array.getJSONObject(j);
                                int id = jsonObject1.getInt("id");
                                String title = jsonObject1.getString("title");
                                String answer_1 = jsonObject1.getString("answer_1");
                                String answer_2 = jsonObject1.getString("answer_2");
                                String answer_3 = jsonObject1.getString("answer_3");
                                String answer_4 = jsonObject1.getString("answer_4");
                                String true_answer = jsonObject1.getString("true_answer");
                                int points = jsonObject1.getInt("points");
                                int duration = jsonObject1.getInt("duration");
                                String hint = jsonObject1.getString("hint");
                                JSONObject jsonobjectpattern = jsonObject1.getJSONObject("pattern");
                                int pattern_id = jsonobjectpattern.getInt("pattern_id");
                                String pattern_name = jsonobjectpattern.getString("pattern_name");
                                viewModel.insertPattern(new Pattern(pattern_id, pattern_name));
                                Log.d("databaseTest", "onCreate : in here" + pattern_id + pattern_name);
//                                Puzzles puzzle = new Puzzles(title, answer_1, answer_2,
//                                        answer_3, answer_4, true_answer, points
//                                        , level_no, duration, pattern_id, hint);
//                                viewModel.insertPuzzles(puzzle);
                            }
                        }
                    } catch (JSONException c) {
                        System.out.println(c.getMessage());
                    }

                }
            }, 5000);*/

        } catch (
                JSONException e) {
            e.printStackTrace();
        }


    }

    void add_petterns() {
        JSONArray jsonArray = null;
        Log.d("jsonString", jsonString.toString());
        try {
            jsonArray = new JSONArray(jsonString);
//            ArrayList<questions> questionsArrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
//                ArrayList<questions> questions = new ArrayList<>();

                JSONObject jsonObj = jsonArray.getJSONObject(i);

                int level_no = jsonObj.getInt("level_no");
                int unlock_points = jsonObj.getInt("unlock_points");
                JSONArray jsonArray2 = jsonObj.getJSONArray("questions");
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj1 = jsonArray2.getJSONObject(j);
                    int id = jsonObj1.getInt("id");
                    String title = jsonObj1.getString("title");
                    String answer_1 = jsonObj1.getString("answer_1");
                    String answer_2 = jsonObj1.getString("answer_2");
                    String answer_3 = jsonObj1.getString("answer_3");
                    String answer_4 = jsonObj1.getString("answer_4");
                    String true_answer = jsonObj1.getString("true_answer");
                    int points = jsonObj1.getInt("points");
                    int duration = jsonObj1.getInt("duration");
                    String hint = jsonObj1.getString("hint");
                    JSONObject jsonObjectpattern = jsonObj1.getJSONObject("pattern");
                    int pattern_id = jsonObjectpattern.getInt("pattern_id");
                    String pattern_name = jsonObjectpattern.getString("pattern_name");
                    Pattern pattern = new Pattern(pattern_id, pattern_name);
                    viewModel.insertPattern(pattern);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void add_puzzle() {
        JSONArray jsonArray = null;
        Log.d("jsonString", jsonString.toString());
        try {
            jsonArray = new JSONArray(jsonString);
//            ArrayList<questions> questionsArrayList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
//                ArrayList<questions> questions = new ArrayList<>();

                JSONObject jsonObj = jsonArray.getJSONObject(i);

                int level_no = jsonObj.getInt("level_no");
                int unlock_points = jsonObj.getInt("unlock_points");
                JSONArray jsonArray2 = jsonObj.getJSONArray("questions");
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj1 = jsonArray2.getJSONObject(j);
                    int id = jsonObj1.getInt("id");
                    String title = jsonObj1.getString("title");
                    String answer_1 = jsonObj1.getString("answer_1");
                    String answer_2 = jsonObj1.getString("answer_2");
                    String answer_3 = jsonObj1.getString("answer_3");
                    String answer_4 = jsonObj1.getString("answer_4");
                    String true_answer = jsonObj1.getString("true_answer");
                    int points = jsonObj1.getInt("points");
                    int duration = jsonObj1.getInt("duration");
                    String hint = jsonObj1.getString("hint");
                    JSONObject jsonObjectpattern = jsonObj1.getJSONObject("pattern");
                    int pattern_id = jsonObjectpattern.getInt("pattern_id");
                    viewModel.insertPuzzles(new Puzzles(title, answer_1, answer_2, answer_3, answer_4,
                            true_answer, points, level_no, duration, pattern_id, hint));

                }
            }
        } catch (JSONException c) {
            System.out.println(c.getMessage());
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(), MyService.class);
        stopService(intent);
    }

    //JOB SERVICE
    private void onClick() {
        JobInfo jobInfo = null;
        ComponentName componentName = new ComponentName(getBaseContext(), MyJobService.class);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            jobInfo = new JobInfo.Builder(101, componentName)

                    .setPeriodic(24 * 60 * 60 * 1000, 5 * 60 * 1000)


                    .build();
        }
        JobScheduler scheduler =
                (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(jobInfo);

    }
}
