package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.androidfinalproject2.Fragments.ChooseFragment;
import com.example.androidfinalproject2.Fragments.CompletFragment;
import com.example.androidfinalproject2.Fragments.True_FalseFragment;
import com.example.androidfinalproject2.RoomDataBase.Puzzles;
import com.example.androidfinalproject2.RoomDataBase.ViewModel;
import com.example.androidfinalproject2.databinding.ActivityLevelsBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityLevels extends AppCompatActivity {
    ActivityLevelsBinding binding;
    ArrayList<Fragment>fragmentArrayList=new ArrayList<>();
    ViewModel viewModel;
    ArrayList<Puzzles>puzzelsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentArrayList.add(new ChooseFragment());
        fragmentArrayList.add(new True_FalseFragment());
        fragmentArrayList.add(new CompletFragment());
puzzelsArrayList=new ArrayList<>();

//        AdapterViewPager adapterViewPager=new AdapterViewPager(this,fragmentArrayList);
//        binding.VP.setAdapter(adapterViewPager);
//
        viewModel.getAllPuzzles().observe(this, new Observer<List<Puzzles>>() {
            @Override
            public void onChanged(List<Puzzles> puzzles) {
                puzzelsArrayList= (ArrayList<Puzzles>) puzzles;
                for (int i = 0; i < puzzelsArrayList.size(); i++) {
                    int pattern_id = puzzelsArrayList.get(i).getPattern_id();
                    String title = puzzelsArrayList.get(i).getTitle();
                    String answer1 = puzzelsArrayList.get(i).getAns1();
                    String answer2 = puzzelsArrayList.get(i).getAns2();
                    String answer3 = puzzelsArrayList.get(i).getAns3();
                    String answer4 = puzzelsArrayList.get(i).getAns4();
                    String trueans = puzzelsArrayList.get(i).getAns_ture();
                    String hint = puzzelsArrayList.get(i).getHint();
                    int ponits = puzzelsArrayList.get(i).getPoints();
                    int level_no = puzzelsArrayList.get(i).getLevel_id();
                    int  duration = puzzelsArrayList.get(i).getDuration();
                    if (pattern_id == 1) {
                       fragmentArrayList.add(True_FalseFragment.newInstance(title, trueans, hint, ponits, level_no, duration);
                    } else if (pattern_id == 2) {
                       fragmentArrayList.add(ChooseFragment.newInstance(title,answer1,answer2,answer3,answer4,trueans,hint,ponits,level_no,duration));
                    } else if (pattern_id == 3) {
                       fragmentArrayList.add(CompletFragment.newInstance(title, trueans, hint, ponits, level_no, duration));
                    }
                    AdapterViewPager adapterViewPager=new AdapterViewPager(ActivityLevels.this,fragmentArrayList);
                    binding.VP.setAdapter(adapterViewPager);
                }
            }

        });





    }


}