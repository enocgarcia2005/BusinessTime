package com.example.business_times.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class ClientsHolder extends RecyclerView.ViewHolder{
    public ImageView imageClient;
    public TextView nameClient;

    public ClientsHolder(@NonNull View itemView) {
        super(itemView);
        this.imageClient=itemView.findViewById(R.id.imageClient);
        this.nameClient=itemView.findViewById(R.id.lblClientName);
    }
}
