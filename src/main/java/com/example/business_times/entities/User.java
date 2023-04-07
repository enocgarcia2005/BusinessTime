package com.example.business_times.entities;


import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME="users";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_ID= BaseColumns._ID;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID)
    public long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "lastName")
    private String lastName;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "password")
    private String password;

    public User(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
