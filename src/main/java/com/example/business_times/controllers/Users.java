package com.example.business_times.controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.UserDataBase;
import com.example.business_times.entities.User;

import java.util.List;

public class Users {
    private List<User> userList;
    private UserDataBase userDataBase;


    public void save(User user, Context context){
        userDataBase=getConnection(context);
        userList=userDataBase.userDao().getAll();
            if (!userExist(user,userList)) {
                userDataBase.userDao().insert(user);
                Toast.makeText(context, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            }
        }
    public String validate(User user,Context context){
       userDataBase=getConnection(context);
       userList=userDataBase.userDao().getAll();
        if (!userExist(user,userList)) {
            return "EL usuario no existe";
        }else {
           return toAccess(user,userList);
        }
    }
    private UserDataBase getConnection(Context context){
        return Room.databaseBuilder(context,UserDataBase.class, Constant.BD_NAME).
                allowMainThreadQueries().build();
    }
    private boolean userExist(User user,List<User> userList){
        if(userList!=null){
            for (User users:userList) {
                if(users.getUserName().equalsIgnoreCase(user.getUserName())){
                    return true;
                }
            }
        }
        return false;
    }

    private String toAccess(User user,List<User> userList){
        boolean userName=false;
        boolean password=false;
        for (User users:userList){
            userName= users.getUserName().equalsIgnoreCase(user.getUserName());
            password=users.getPassword().equals(user.getPassword());
        }
        boolean log= userName&&password;
        if (log){
          return "bienvenido";
        }
        return "Contraseña y/o no coinciden";
    }
}