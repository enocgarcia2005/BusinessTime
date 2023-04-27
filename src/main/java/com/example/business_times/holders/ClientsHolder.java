package com.example.business_times.holders;

import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class ClientsHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
    public ImageView imageClient;
    public TextView nameClient;
    View.OnCreateContextMenuListener contextClick;
    public ClientsHolder(@NonNull View itemView) {
        super(itemView);
        this.imageClient=itemView.findViewById(R.id.imageClient);
        this.nameClient=itemView.findViewById(R.id.lblClientName);
        itemView.setOnCreateContextMenuListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        contextClick.onCreateContextMenu(menu,v,menuInfo);
    }
    public void setCreateContextMenu(View.OnCreateContextMenuListener contextClick){
        this.contextClick=contextClick;
    }
}
