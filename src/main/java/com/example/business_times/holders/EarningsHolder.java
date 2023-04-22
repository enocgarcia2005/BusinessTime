package com.example.business_times.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;


public class EarningsHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView namePerson,money;
    public EarningsHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.imgClient);
        this.namePerson=itemView.findViewById(R.id.lblTittleClient);
        this.money=itemView.findViewById(R.id.numberClients);
    }
}
