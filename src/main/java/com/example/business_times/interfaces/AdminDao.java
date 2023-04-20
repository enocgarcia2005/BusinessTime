package com.example.business_times.interfaces;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.business_times.entities.Client;
import com.example.business_times.entities.User;
import com.example.business_times.entities.Vent;

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
    void insert(User user);
    @Insert
    void insert(Client client);
    @Insert
    void insert(Vent vent);

    /**
     * list all users of data base .
     * @return  return arrayList with all users.
     */
    @Query("SELECT * FROM "+User.TABLE_USERS)
    List<User> getAll();

    @Query("SELECT * FROM "+ Client.TABLE_CLIENTS +" WHERE user= :userName")
    List<Client> getAllCLients(String userName);

    @Query("SELECT * FROM "+Vent.TABLE_PRODUCTS+" WHERE nameUser= :userName")
    List<Vent> getAllVents(String userName);
}
