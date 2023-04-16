package com.example.business_times.controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.example.business_times.config.Constant;
import com.example.business_times.databases.AdminDataBase;
import com.example.business_times.entities.Client;

import java.util.List;

public class Clients {
    List<Client> clientList;
    AdminDataBase adminDataBase;
    public void save(Client client,Context context,String userName){
        adminDataBase =getConecction(context);
        clientList= getClientList(context,userName);
        if(!clientExist(client,clientList)){
            adminDataBase.userDao().insert(client);
        }else{
            Toast.makeText(context, "El cliente ya ha sido agregado", Toast.LENGTH_SHORT).show();
        }
    
    }

    public List<Client> getClientList(Context context,String userName){
        AdminDataBase adminDataBase=getConecction(context);
        return adminDataBase.userDao().getAllCLients(userName);
    }
    private boolean clientExist(Client client,List<Client> clientList){
        if (clientList!=null){
            for (Client clientAux:clientList){
                if(clientAux.getName().equalsIgnoreCase(client.getName())&&clientAux.getLastName().equalsIgnoreCase(client.getLastName())){
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
