package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.androidfinalproject2.databinding.ActivitySplashSecrenBinding;

public class Splash_Secren extends AppCompatActivity {
    ActivitySplashSecrenBinding binding;
    Animation top, bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashSecrenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        top=AnimationUtils.loadAnimation(this,R.anim.top_splash);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_splash);

        binding.imageView.setAnimation(top);
        binding.textView2.setAnimation(bottom);
//        Intent intent = new Intent(getApplicationContext(), MyService.class);
//        boolean isplaying = false;
//        if(!isplaying){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                startService(intent);
//            }}

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash_Secren.this, Home_Activity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5000);
    }
}
