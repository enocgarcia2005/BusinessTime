package com.example.business_times.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.entities.Payment;
import com.example.business_times.holders.PaymentsHolder;

import java.util.List;

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsHolder>{
    Context context;
    List<Payment> paymentList;
    public PaymentsAdapter(Context context, List<Payment> paymentList){
        this.context=context;
        this.paymentList=paymentList;
    }

    @NonNull
    @Override
    public PaymentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_earnigs,parent,false);
        return new PaymentsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentsHolder holder, int position) {
        holder.namePerson.setText(paymentList.get(position).getDetails());
        holder.money.setText(String.valueOf(paymentList.get(position).getPrice()));
        if(paymentList.get(position).getCategory().equalsIgnoreCase("earnings")){
            holder.money.setTextColor(Color.parseColor("#66873F"));
        }else {
            holder.money.setTextColor(Color.parseColor("#F23A30"));
        }
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }
}
