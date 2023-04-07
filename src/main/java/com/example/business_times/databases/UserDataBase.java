package com.example.business_times.databases;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.business_times.entities.User;
import com.example.business_times.interfaces.UserDao;

@Database(entities = {User.class},version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
