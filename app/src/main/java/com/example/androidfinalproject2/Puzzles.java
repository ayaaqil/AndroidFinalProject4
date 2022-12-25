package com.example.androidfinalproject2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Levels.class, parentColumns = {"LevelId"}
        ,childColumns = {"Level_id"},onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE),})
public class Puzzles {
    @PrimaryKey(autoGenerate = true)
    int puzzles_id;
    String puzzles;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    String ans_ture;
    int score_id;
    int Level_id;
    int timer;
    String style_ques;
    String text;

    public Puzzles() {
    }

    public Puzzles(String puzzles, String ans1, String ans2, String ans3, String ans4, String ans_ture, int score_id, int level_id, int timer, String style_ques, String text) {
        this.puzzles = puzzles;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans_ture = ans_ture;
        this.score_id = score_id;
        Level_id = level_id;
        this.timer = timer;
        this.style_ques = style_ques;
        this.text = text;
    }

    public Puzzles(int puzzles_id, String puzzles, String ans1, String ans2, String ans3, String ans4, String ans_ture, int score_id, int level_id, int timer, String style_ques, String text) {
        this.puzzles_id = puzzles_id;
        this.puzzles = puzzles;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans_ture = ans_ture;
        this.score_id = score_id;
        Level_id = level_id;
        this.timer = timer;
        this.style_ques = style_ques;
        this.text = text;
    }

    public int getPuzzles_id() {
        return puzzles_id;
    }

    public void setPuzzles_id(int puzzles_id) {
        this.puzzles_id = puzzles_id;
    }

    public String getPuzzles() {
        return puzzles;
    }

    public void setPuzzles(String puzzles) {
        this.puzzles = puzzles;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getAns_ture() {
        return ans_ture;
    }

    public void setAns_ture(String ans_ture) {
        this.ans_ture = ans_ture;
    }

    public int getScore_id() {
        return score_id;
    }

    public void setScore_id(int score_id) {
        this.score_id = score_id;
    }

    public int getLevel_id() {
        return Level_id;
    }

    public void setLevel_id(int level_id) {
        Level_id = level_id;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getStyle_ques() {
        return style_ques;
    }

    public void setStyle_ques(String style_ques) {
        this.style_ques = style_ques;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
