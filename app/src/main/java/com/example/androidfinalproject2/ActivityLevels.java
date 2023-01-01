package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.androidfinalproject2.Fragments.ChooseFragment;
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
//         fragmentArrayList.add(ChooseFragment.newInstance("ffvf","ef",
//                 "wer","wef","ef","ff",3,"ef","ef"));

        AdapterViewPager adapterViewPager=new AdapterViewPager(this,fragmentArrayList);
        binding.VP.setAdapter(adapterViewPager);


    }


}