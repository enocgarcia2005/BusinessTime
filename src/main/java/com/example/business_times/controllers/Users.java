package com.example.business_times.controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.UserDataBase;
import com.example.business_times.entities.User;

import java.util.List;

/**
 * The Users class has the method that connect the data write for the user with the DataBase information.
 */
public class Users {
    /**
     * userList contain all user that are in data base
     */
    private List<User> userList;
    /**
     * userDataBase communicate the information of the application with the data base.
     */
    private UserDataBase userDataBase;

    /**
     * this method save a user that not exist in the data base.
     * @param user- user write for the users.
     * @param context-context of the activity.
     */
    public void save(User user, Context context){
        userDataBase=getConnection(context);
        userList=userDataBase.userDao().getAll();
            if (!userExistent(user, userList)) {
                userDataBase.userDao().insert(user);
                Toast.makeText(context, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            }
        }

    /**
     * this method validate if usernames and passwords are equals with are in the data base.
     * @param user-user with username and password
     * @param context-context of the activity.
     * @return return a string, if user and password are equals return "bienvenido",
     * if the user exist return "El usuario no existe,
     * else return "Contraseña y/o no coinciden".
     */
    public String validate(User user,Context context){
       userDataBase=getConnection(context);
       userList=userDataBase.userDao().getAll();
        if (!userExistent(user, userList)) {
            return "EL usuario no existe";
        }else {
           return toAccess(user,userList);
        }
    }

    /**
     * This method create the object with the connection with the data base.
     * @param context-context of the activity.
     * @return return the object of type UserDataBase.
     */
    private UserDataBase getConnection(Context context){
        return Room.databaseBuilder(context,UserDataBase.class, Constant.BD_NAME).
                allowMainThreadQueries().build();
    }

    /**
     * This method validate if the user written exist or no.
     * @param user-user written for the user.
     * @param userList-list with all users.
     * @return return true if user exist, else return false.
     */
    private boolean userExistent(User user, List<User> userList){
        if(userList!=null){
            for (User users:userList) {
                if(users.getUserName().equalsIgnoreCase(user.getUserName())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this method validate if the user and password are equals with data base.
     * @param user-user written for the user.
     * @param userList-list with all users.
     * @return if the user exist return "El usuario no existe,
     * else return "Contraseña y/o no coinciden".
     */
    private String toAccess(User user,List<User> userList){
        boolean userName=false;
        boolean password=false;
        for (User users:userList){
            userName= users.getUserName().equalsIgnoreCase(user.getUserName());
            password=users.getPassword().equals(user.getPassword());
        }
        boolean log=userName&&password;
        if (log){
          return "bienvenido";
        }
        return "Contraseña y/o no coinciden";
    }
}