package com.example.androidfinalproject2;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class UtilString {
    public  static  String readFormats (Context context,String FileName){
        String string="";
        try{
            InputStream inputStream=context.getAssets().open(FileName);
            int size = inputStream.available();
            byte[] byteobject = new byte[size];
            inputStream.read(byteobject);
            inputStream.close();
            string= new String(byteobject,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
