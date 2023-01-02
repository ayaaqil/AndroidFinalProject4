package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.androidfinalproject2.Fragments.ChooseFragment;
import com.example.androidfinalproject2.Fragments.CompletFragment;
import com.example.androidfinalproject2.Fragments.True_FalseFragment;
import com.example.androidfinalproject2.RoomDataBase.Puzzles;
import com.example.androidfinalproject2.databinding.ActivityLevelsBinding;

import java.util.ArrayList;

public class ActivityLevels extends AppCompatActivity {
    ActivityLevelsBinding binding;
    ArrayList<Fragment>fragmentArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentArrayList.add(new ChooseFragment());
        fragmentArrayList.add(new True_FalseFragment());
        fragmentArrayList.add(new CompletFragment());


        AdapterViewPager adapterViewPager=new AdapterViewPager(this,fragmentArrayList);
        binding.VP.setAdapter(adapterViewPager);




    }


}