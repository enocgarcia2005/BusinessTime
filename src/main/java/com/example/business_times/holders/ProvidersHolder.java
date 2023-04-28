package com.example.business_times.holders;

import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class ProvidersHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
    public ImageView imageProvide;
    public TextView nameProvide;
    View.OnCreateContextMenuListener contextClick;
    public ProvidersHolder(@NonNull View itemView) {
        super(itemView);
        this.imageProvide=itemView.findViewById(R.id.imageProvide);
        this.nameProvide=itemView.findViewById(R.id.lblProvideName);
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