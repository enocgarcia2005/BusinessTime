package com.example.business_times.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.entities.Vent;
import com.example.business_times.holders.VentsHolder;

import java.util.List;


public class VentsAdapter extends RecyclerView.Adapter<VentsHolder>{
    List<Vent> ventList;
    Context context;
    SharedPreferencesHelper sharedPreferencesHelper;
    public VentsAdapter(Context context,List<Vent> ventList){
        this.context=context;
        this.ventList=ventList;
        sharedPreferencesHelper=new SharedPreferencesHelper(context);
        ventList.removeIf(vent -> !vent.getNameClient().equals(sharedPreferencesHelper.getPreferences("client")));

    }
    @NonNull
    @Override
    public VentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_vent,parent,false);
        return new VentsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VentsHolder holder, int position) {
        if(ventList.get(position).getNameClient().equals(sharedPreferencesHelper.getPreferences("client"))) {
            holder.ventName.setText(ventList.get(position).getDetails());
            holder.date.setText(ventList.get(position).getDate());
            holder.money.setText(String.valueOf(ventList.get(position).getPrice()));
        }
    }

    @Override
    public int getItemCount() {
        return ventList.size();
    }
}
