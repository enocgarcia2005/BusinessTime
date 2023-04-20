package com.example.business_times.controllers;

import android.content.Context;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Vent;

import java.util.List;

public class Vents {
    List<Vent> clientVent;
    AdminDataBase adminDataBase;
    public void save(Vent vent, Context context,String userName){
        adminDataBase =getConecction(context);
        clientVent= getVentList(context,userName);
        adminDataBase.userDao().insert(vent);
    }

    public List<Vent> getVentList(Context context,String userName){
        AdminDataBase adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllVents(userName);
    }

    private AdminDataBase getConecction(Context context){
        return Room.databaseBuilder(context, AdminDataBase.class, Constant.BD_NAME).allowMainThreadQueries().build();
    }
}
