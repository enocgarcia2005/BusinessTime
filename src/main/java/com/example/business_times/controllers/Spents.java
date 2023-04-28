package com.example.business_times.controllers;

import android.content.Context;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Spent;

import java.util.List;

public class Spents {
    AdminDataBase adminDataBase;
    public void save(Spent spent, Context context){
        adminDataBase =getConecction(context);
        adminDataBase.userDao().insert(spent);
    }

    public List<Spent> getSpentList(Context context, String userName){
        AdminDataBase adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllSpent(userName);
    }

    public void deleteSpent(Context context,Spent spent){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().deleteSpent(spent);
    }
    public  void deleteSpentList(Context context,List<Spent> spentList){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().deleteSpentList(spentList);
    }
    public void updateSpent(Context context,Spent spent){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().updateSpent(spent);
    }
    public void updateListSpent(Context context,List<Spent> spentList){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().updateSpentList(spentList);
    }
    private AdminDataBase getConecction(Context context){
        return Room.databaseBuilder(context, AdminDataBase.class, Constant.BD_NAME).allowMainThreadQueries().build();
    }
}
