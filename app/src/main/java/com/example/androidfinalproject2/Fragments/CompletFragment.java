package com.example.androidfinalproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.R;


public class CompletFragment extends Fragment {
    private static final String PUZZLES_TITLE = "title";
    private static final String PUZZLES_TRUE = "true_answer";
    private static final String PUZZLES_POINTS = "points";
    private static final String PUZZLES_DURATION = "duration";
    private static final String PUZZLES_HINT = "hint";
    private  static  final  String PUZZLES_LEVEL_NO="level_no";
    // TODO: Rename and change types of parameters
    private String title;
    private String true_answer;
    private  int points;
    private  int duration;
    private  String  hint;
    private int level_no;

    public CompletFragment() {

    }


    public static CompletFragment newInstance(String s, String title, String true_answer, int ponits, int level_no, int duration) {
        CompletFragment fragment = new CompletFragment();
        Bundle args = new Bundle();
        args.putString(PUZZLES_TITLE, title);
        args.putString(PUZZLES_TITLE, true_answer);
        args.putInt(PUZZLES_POINTS, ponits);
        args.putInt(PUZZLES_TITLE, level_no);
        args.putInt(PUZZLES_DURATION, duration);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(PUZZLES_TITLE);
            true_answer = getArguments().getString(PUZZLES_TITLE);
            points = getArguments().getInt(PUZZLES_POINTS);
            level_no = getArguments().getInt(PUZZLES_LEVEL_NO);
            duration = getArguments().getInt(PUZZLES_DURATION);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_complet, container, false);
    }
}