package com.example.androidfinalproject2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Levels.class, parentColumns = {"LevelId"}
        ,childColumns = {"Level_id"},onUpdate = ForeignKey.CASCADE,onDelete = ForeignKey.CASCADE),
@ForeignKey(entity = pattern.class,parentColumns = {"pattern_id"},
        childColumns = {"pattern_id"},onUpdate = ForeignKey.CASCADE,
onDelete = ForeignKey.CASCADE)
})
public class Puzzles {
    @PrimaryKey(autoGenerate = true)
    int puzzles_id;
   String title;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    String ans_ture;
    int points;
    int Level_id;
    int duration;
    int pattern_id;
    String hint;



 

    public Puzzles(String title, String ans1, String ans2, String ans3, String ans4, String ans_ture, int points, int level_id, int duration, int pattern_id, String hint) {
        this.title = title;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans_ture = ans_ture;
        this.points = points;
        Level_id = level_id;
        this.duration = duration;
        this.pattern_id = pattern_id;
        this.hint = hint;
    }

    public Puzzles() {
        
        
    }

    public Puzzles(String title, String answer_1, String answer_2, String answer_3, String answer_4, String true_answer, int points, int duration, String hint) {
    }

    public int getPuzzles_id() {
        return puzzles_id;
    }

    public void setPuzzles_id(int puzzles_id) {
        this.puzzles_id = puzzles_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel_id() {
        return Level_id;
    }

    public void setLevel_id(int level_id) {
        Level_id = level_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPattern_id() {
        return pattern_id;
    }

    public void setPattern_id(int pattern_id) {
        this.pattern_id = pattern_id;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
