package com.example.business_times.controllers;

import android.content.Context;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Payment;

import java.util.List;

public class Payments {
    AdminDataBase adminDataBase;
    public void save(Context context, Payment payment){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().insert(payment);
    }
    public List<Payment> getAllPayments(Context context,String userName){
        adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllPayments(userName);
    }
    private AdminDataBase getConecction(Context context){
        return Room.databaseBuilder(context, AdminDataBase.class, Constant.BD_NAME).allowMainThreadQueries().build();
    }
}
