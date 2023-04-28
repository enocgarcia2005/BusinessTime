package com.example.business_times.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;

public class ExpensesHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView namePerson,money;
    public ExpensesHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.imgProvide);
        this.namePerson=itemView.findViewById(R.id.lblTittleProvide);
        this.money=itemView.findViewById(R.id.numberProvider);
    }
}
