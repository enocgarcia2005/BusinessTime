package com.example.business_times.databases;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.business_times.entities.User;
import com.example.business_times.interfaces.UserDao;

/**
 * The abstract class UserDataBase has the all entities in the annotation Database
 */
@Database(entities = {User.class},version = 1)
public abstract class UserDataBase extends RoomDatabase {
    /**
     * This method contain the implementation of methods of the interface UserDao
     * @return return a object with the this operations.
     */
    public abstract UserDao userDao();
}
