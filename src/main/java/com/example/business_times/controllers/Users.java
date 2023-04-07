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
    public void validate(User user,Context context){
       userDataBase=getConnection(context);
       userList=userDataBase.userDao().getAll();
        if (!userExist(user,userList)) {
            Toast.makeText(context, "EL usuario no existe", Toast.LENGTH_SHORT).show();
        }else {
            toAccess(user,userList,context);
        }
    }
    private UserDataBase getConnection(Context context){
        return Room.databaseBuilder(context,UserDataBase.class, Constant.BD_NAME).
                allowMainThreadQueries().build();
    }
    private boolean userExist(User user,List<User> userList){
        boolean userExist=false;
        if(userList!=null){
            for (User users:userList) {
                userExist=users.getUserName().equalsIgnoreCase(user.getUserName());
                if(userExist){
                    break;
                }
            }
        }
        return userExist;
    }

    private void toAccess(User user,List<User> userList,Context context){
        boolean userName=false;
        boolean password=false;
        for (User users:userList){
            userName= users.getUserName().equalsIgnoreCase(user.getUserName());
            password=users.getPassword().equals(user.getPassword());
        }
        boolean log= userName&&password;
        if (log){
            Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "El usuario y/o contraseña no coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}