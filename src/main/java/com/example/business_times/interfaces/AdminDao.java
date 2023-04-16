package com.example.business_times.interfaces;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.business_times.entities.Client;
import com.example.business_times.entities.User;

import java.util.List;
/**
 * The interface AdminDao contain the operation with the data base.
 */
@Dao
public interface AdminDao {
    /**
     * insert user in data base
     * @param user-user write for the user
     * @return return 1 if is all ok.
     */
    @Insert
    long insert(User user);
    @Insert
    long insert(Client client);

    /**
     * list all users of data base .
     * @return  return arrayList with all users.
     */
    @Query("SELECT * FROM "+User.TABLE_USERS)
    List<User> getAll();

    @Query("SELECT * FROM "+ Client.TABLE_CLIENTS +" WHERE user= :userName")
    List<Client> getAllCLients(String userName);
}
