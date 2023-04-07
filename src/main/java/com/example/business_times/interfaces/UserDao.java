package com.example.business_times.interfaces;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.business_times.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT COUNT(*) FROM "+ User.TABLE_NAME)
    int count();
    @Insert
    long insert(User user);
    @Query("SELECT * FROM "+User.TABLE_NAME)
    List<User> getAll();
    @Query("DELETE FROM "+User.TABLE_NAME+" WHERE "+User.COLUMN_ID+ " = :id")
    int delete(long id);
    @Update
    int update(User user);
}
