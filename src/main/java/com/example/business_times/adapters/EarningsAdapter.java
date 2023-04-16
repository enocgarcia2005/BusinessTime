package com.example.business_times.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Vent;
import com.example.business_times.holders.EarningsHolder;

import java.util.List;

public class EarningsAdapter extends RecyclerView.Adapter<EarningsHolder> {
    Context context;
    List<Client> dataClients;
    List<Vent> dataVents;
    public EarningsAdapter(Context context, List<Client> dataClients, List<Vent> dataVents){
        this.context=context;
        this.dataClients=dataClients;
        this.dataVents=dataVents;
    }

    @NonNull
    @Override
    public EarningsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_earnigs,parent,false);
        return new EarningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EarningsHolder holder, final int position) {
        String name=dataClients.get(position).getName()+" "+dataClients.get(position).getLastName();
        String money= dataVents.get(position).getPrice()+"$";
        holder.namePerson.setText(name);
        holder.money.setText(money);
        holder.date.setText(dataVents.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        if(dataClients==null){
            return 0;
        }
        return dataClients.size();
    }
}
