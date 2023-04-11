package com.example.business_times.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Client.TABLE_CLIENTS)
public class Client {
    public static final String TABLE_CLIENTS="clients";
    public static  final String COLUMN_ID_CLIENT= BaseColumns._ID;
    public Client(){}
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = COLUMN_ID_CLIENT)
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
