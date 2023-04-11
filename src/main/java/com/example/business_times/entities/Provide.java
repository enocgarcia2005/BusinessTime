package com.example.business_times.entities;


import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Provide.TABLE_PROVIDES)
public class Provide {
    public static final String TABLE_PROVIDES="provides";
    public static  final String COLUMN_ID_PROVIDE= BaseColumns._ID;
    public Provide(){}
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID_PROVIDE)
    private long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "lastName")
    private String lastName;
    @ColumnInfo(name = "user")
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}