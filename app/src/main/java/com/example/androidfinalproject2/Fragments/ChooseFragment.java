package com.example.androidfinalproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.R;
import com.example.androidfinalproject2.databinding.FragmentChooseBinding;


public class ChooseFragment extends Fragment {

    private static final String PUZZLES_TITLE = "title";
    private static final String PUZZLES_ANS1 = "answer_1";
    private static final String PUZZLES_ANS2 = "answer_2";
    private static final String PUZZLES_ANS3 = "answer_3";
    private static final String PUZZLES_ANS4 = "answer_4";
    private static final String PUZZLES_TRUE = "true_answer";
    private static final String PUZZLES_POINTS = "points";
    private static final String PUZZLES_DURATION = "duration";
    private static final String PUZZLES_HINT = "hint";


    // TODO: Rename and change types of parameters
    private String title;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private String true_answer;
    private  int points;
    private  String duration;
    private  String hint;

    public ChooseFragment() {
    }


    public static ChooseFragment newInstance(String title, String answer_1,String answer_2,String answer_3,
    String answer_4,String true_answer,int points,String duration,String hint) {
        ChooseFragment fragment = new ChooseFragment();
        Bundle args = new Bundle();
        args.putString(PUZZLES_TITLE, title);
        args.putString(PUZZLES_ANS1, answer_1);
        args.putString(PUZZLES_ANS2, answer_2);
        args.putString(PUZZLES_ANS3, answer_3);
        args.putString(PUZZLES_ANS4, answer_4);
        args.putString(PUZZLES_TRUE, true_answer);
        args.putInt(PUZZLES_POINTS, points);
        args.putString(PUZZLES_DURATION, duration);
        args.putString(PUZZLES_HINT,hint);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(PUZZLES_TITLE);
            answer_1 = getArguments().getString(PUZZLES_ANS1);
            answer_2 = getArguments().getString(PUZZLES_ANS2);
            answer_3 = getArguments().getString(PUZZLES_ANS3);
            answer_4 = getArguments().getString(PUZZLES_ANS4);
            true_answer = getArguments().getString(PUZZLES_TRUE);
           points = getArguments().getInt(PUZZLES_POINTS);
           duration = getArguments().getString(PUZZLES_DURATION);
           hint=getArguments().getString(PUZZLES_HINT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChooseBinding binding=FragmentChooseBinding.inflate(getLayoutInflater(),container,false);
        return  binding.getRoot();

    }
}