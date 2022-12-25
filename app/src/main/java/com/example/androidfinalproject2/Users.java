package com.example.androidfinalproject2;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;
@Entity
@TypeConverters({DataConvirter.class})
public class Users {
@PrimaryKey(autoGenerate = true)
    int userId;
    String userName;
    String email;
    Date birthDate;
    String gender;
    String country;





    public Users(int userId, String userName, String email, Date birthDate, String gender, String country) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.country = country;
    }

    public Users() {
        this.userName = userName;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.country = country;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
