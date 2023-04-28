package com.example.business_times.interfaces;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.business_times.entities.Client;
import com.example.business_times.entities.Payment;
import com.example.business_times.entities.Provide;
import com.example.business_times.entities.Spent;
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
     */
    @Insert
    void insert(User user);
    @Insert
    void insert(Client client);
    @Insert
    void  insert(Provide provide);
    @Insert
    void insert(Vent vent);
    @Insert
    void insert(Spent spent);
    @Insert
    void insert(Payment payment);
    @Delete
    void deleteVent(Vent vent);
    @Delete
    void deleteVentList(List<Vent> ventList);
    @Delete
    void deleteSpent(Spent spent);
    @Delete
    void deleteSpentList(List <Spent> spentList);
    @Delete
    void deleteClient(Client client);
    @Delete
    void deleteProvide(Provide provide);
    /**
     * list all users of data base .
     * @return  return arrayList with all users.
     */
    @Query("SELECT * FROM "+User.TABLE_USERS)
    List<User> getAll();

    @Query("SELECT * FROM "+ Client.TABLE_CLIENTS +" WHERE user= :userName")
    List<Client> getAllCLients(String userName);
    @Query("SELECT * FROM "+ Provide.TABLE_PROVIDES+" WHERE user=:userName")
    List<Provide> getAllProviders(String userName);
    @Query("SELECT * FROM "+Vent.TABLE_PRODUCTS+" WHERE nameUser= :userName")
    List<Vent> getAllVents(String userName);
    @Query("SELECT * FROM "+Spent.TABLE_SPENT+" WHERE nameUser=:userName")
    List<Spent> getAllSpent(String userName);
    @Query("SELECT * FROM "+Payment.TABLE_PAYMENTS+" WHERE userName=:userName")
    List<Payment> getAllPayments(String userName);
   @Update
    void updateVent(Vent vent);
   @Update
    void updateVents(List<Vent> ventList);
   @Update
   void updateSpent(Spent spent);
   @Update
   void updateSpentList(List<Spent> spentList);
   @Update
    void  updateClient(Client client);
   @Update
    void updateProvide(Provide provide);
}
