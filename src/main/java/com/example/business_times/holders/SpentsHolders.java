package com.example.business_times.holders;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class SpentsHolders extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
    public TextView ventName,date,money;
    View.OnCreateContextMenuListener contextClick;
    public SpentsHolders(@NonNull View itemView) {
        super(itemView);
        ventName=itemView.findViewById(R.id.lblDetailsVent);
        date=itemView.findViewById(R.id.lblDateVent);
        money=itemView.findViewById(R.id.moneyVent);
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
