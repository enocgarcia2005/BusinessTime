package com.example.business_times.databases;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.business_times.entities.Client;
import com.example.business_times.entities.Provide;
import com.example.business_times.entities.Spent;
import com.example.business_times.entities.User;
import com.example.business_times.entities.Vent;
import com.example.business_times.interfaces.AdminDao;

/**
 * The abstract class AdminDataBase has the all entities in the annotation Database
 */
@Database(entities = {User.class,Client.class, Provide.class, Spent.class,Vent.class},version = 2)
public abstract class AdminDataBase extends RoomDatabase {
    /**
     * This method contain the implementation of methods of the interface AdminDao
     * @return return a object with the this operations.
     */
    public abstract AdminDao userDao();
}
