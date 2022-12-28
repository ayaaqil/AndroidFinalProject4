package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidfinalproject2.databinding.ActivityHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {
    ActivityHomeBinding binding;
     MediaPlayer mediaPlayer;
     ViewModel viewModel;
     JSONArray jsonArray;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

         //JobService

         JobInfo jobInfo=null;
         ComponentName componentName=new ComponentName(getBaseContext(),MyJobService.class);

         if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
             jobInfo=new JobInfo.Builder(101,componentName)

                     .setPeriodic(24*60*60*1000,5*60*1000)


                     .build();
         }
         JobScheduler scheduler=
                 (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
         scheduler.schedule(jobInfo);


      String jsonString=UtilString.readFormats(getApplicationContext(),"puzzleGameData.json");

            parsejsonstring(jsonString);
            Intent intent=new Intent(getBaseContext(),MyService.class);
            startService(intent);

            binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);


            }
        });
        binding.btnSettinges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Settings.class);
                startActivity(intent);
            }
        });
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Playing.class);
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

    private void parsejsonstring(String jsonString){
        try {
            jsonArray=new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                ArrayList<question> questionsArrayList=new ArrayList<>();
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                int level_no=jsonObject.getInt("level_no");
                int unlock_points=jsonObject.getInt("unlock_points");
//                Levels levels=new Levels(level_no,unlock_points);
//                viewModel.insertLevel(levels);
                JSONArray jsonArray2=jsonObject.getJSONArray("questions");
                for (int j = 0; j <jsonArray2.length() ; j++) {
                    JSONObject jsonObject1=jsonArray2.getJSONObject(i);
                    int id=jsonObject1.getInt("id");
                    String title=jsonObject1.getString("title");
                    String answer_1=jsonObject1.getString("answer_1");
                    String answer_2=jsonObject1.getString("answer_2");
                    String answer_3=jsonObject1.getString("answer_3");
                    String answer_4=jsonObject1.getString("answer_4");
                    String true_answer=jsonObject1.getString("true_answer");
                    int points=jsonObject1.getInt("points");
                    int duration=jsonObject1.getInt("duration");
                    String hint=jsonObject1.getString("hint");


                    JSONObject jsonobjectpattern=jsonObject1.getJSONObject("pattern");
                    int pattern_id=jsonobjectpattern.getInt("pattern_id");
                    String pattern_name=jsonobjectpattern.getString("pattern_name");

                    Log.d("databaseTest","onCreate : in here"+pattern_id+pattern_name);
                    viewModel.insertPuzzles(new Puzzles(title,answer_1,answer_2,
                            answer_3,answer_4,true_answer,points
                    ,duration,hint));
                }
                
                


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(getBaseContext(),MyService.class);
        stopService(intent);
    }

}
