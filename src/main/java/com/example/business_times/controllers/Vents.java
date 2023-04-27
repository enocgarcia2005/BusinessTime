package com.example.business_times.controllers;

import android.content.Context;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Vent;

import java.util.List;

public class Vents {
    AdminDataBase adminDataBase;
    public void save(Vent vent, Context context){
        adminDataBase =getConecction(context);
        adminDataBase.userDao().insert(vent);
    }

    public List<Vent> getVentList(Context context,String userName){
        AdminDataBase adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllVents(userName);
    }

    public void deleteVents(Context context,Vent vent){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().deleteVent(vent);
    }
    public  void deleteVentList(Context context,List<Vent> ventList){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().deleteVentList(ventList);
    }
    public void updateVents(Context context,Vent vent){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().updateVent(vent);
    }
    public void updateListVents(Context context,List<Vent> ventList){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().updateVents(ventList);
    }
    private AdminDataBase getConecction(Context context){
        return Room.databaseBuilder(context, AdminDataBase.class, Constant.BD_NAME).allowMainThreadQueries().build();
    }
}
