package com.example.business_times.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class VentsHolder extends RecyclerView.ViewHolder{
    public TextView ventName,date,money;
    public VentsHolder(@NonNull View itemView) {
        super(itemView);
        ventName=itemView.findViewById(R.id.lblDetailsVent);
        date=itemView.findViewById(R.id.lblDateVent);
        money=itemView.findViewById(R.id.moneyVent);
    }
}
