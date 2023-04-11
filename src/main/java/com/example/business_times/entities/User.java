package com.example.business_times.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * the class User is a entity that contain attributes for the users with their getters and setters
 */

@Entity(tableName = User.TABLE_USERS)
public class User {
    /**
     * Name of the table
     */
    public static final String TABLE_USERS="users";

    @PrimaryKey
    @ColumnInfo(name = "userName")
    @NonNull
    private String userName;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "password")
    private String password;

    public User(){
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

    @NonNull
    public String getUserName() {
        return userName;
    }
    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
