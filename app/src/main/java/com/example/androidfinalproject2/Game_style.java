package com.example.androidfinalproject2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game_style {
    @PrimaryKey(autoGenerate = true)
    int style_id;
    String style_name;



    public Game_style() {
        this.style_name = style_name;
    }

    public Game_style(int style_id, String style_name) {
        this.style_id = style_id;
        this.style_name = style_name;
    }

    public int getStyle_id() {
        return style_id;
    }

    public void setStyle_id(int style_id) {
        this.style_id = style_id;
    }

    public String getStyle_name() {
        return style_name;
    }

    public void setStyle_name(String style_name) {
        this.style_name = style_name;
    }


}
