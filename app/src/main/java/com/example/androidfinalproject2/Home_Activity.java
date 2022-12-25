package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.androidfinalproject2.databinding.ActivityHomeBinding;

public class Home_Activity extends AppCompatActivity {
    ActivityHomeBinding binding;
     MediaPlayer mediaPlayer;



//    @Override
//    protected void onStart() {
//        super.onStart();
//       mediaPlayer.start();
//
//   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());
    mediaPlayer =MediaPlayer.create(this,R.raw.s);




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
    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();

    }
}
