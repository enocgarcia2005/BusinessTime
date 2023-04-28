package com.example.business_times.controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Provide;

import java.util.List;

public class Providers {
    List<Provide> provideList;
    AdminDataBase adminDataBase;
    public void save(Provide provide, Context context, String userName){
        adminDataBase =getConecction(context);
        provideList= getProvideList(context,userName);
        if(!provideExist(provide,provideList)){
            adminDataBase.userDao().insert(provide);
        }else{
            Toast.makeText(context, "El proveedor  ya ha sido agregado", Toast.LENGTH_SHORT).show();
        }

    }

    public List<Provide> getProvideList(Context context,String userName){
        AdminDataBase adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllProviders(userName);
    }
    public void updateProvide(Context context,Provide provide){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().updateProvide(provide);
    }
    public void deleteProvide(Context context,Provide provide){
        adminDataBase=getConecction(context);
        adminDataBase.userDao().deleteProvide(provide);
    }
    private boolean provideExist(Provide provide,List<Provide> provideList){
        if (provideList!=null){
            for (Provide provideAux:provideList){
                if(provideAux.getName().equalsIgnoreCase(provide.getName())&&provideAux.getLastName().equalsIgnoreCase(provide.getLastName())){
                    return true;
                }
            }
        }
        return false;
    }
    private AdminDataBase getConecction(Context context){
        return Room.databaseBuilder(context, AdminDataBase.class, Constant.BD_NAME).allowMainThreadQueries().build();
    }
}
