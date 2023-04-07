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
    public void save(User user, Context context){
        UserDataBase userDataBase=getConnection(context);
        userList=userDataBase.userDao().getAll();
        if(userList!=null){
            boolean userExist=false;
            for (User users:userList) {
                userExist=users.getUserName().equalsIgnoreCase(user.getUserName());
            }

            if (!userExist) {
                userDataBase.userDao().insert(user);
                Toast.makeText(context, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private UserDataBase getConnection(Context context){
        return Room.databaseBuilder(context,UserDataBase.class, Constant.BD_NAME).
                allowMainThreadQueries().build();
    }
}
