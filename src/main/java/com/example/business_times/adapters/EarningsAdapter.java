package com.example.business_times.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.entities.Vent;
import com.example.business_times.holders.EarningsHolder;

import java.util.ArrayList;
import java.util.List;

public class EarningsAdapter extends RecyclerView.Adapter<EarningsHolder> {
    Context context;
    List<Vent> ventList;
    List<String> earnings;

    public EarningsAdapter(Context context, List<Vent> ventList){
        this.context=context;
        this.ventList=ventList;
        earnings=nameClients();

    }

    @NonNull
    @Override
    public EarningsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_earnigs,parent,false);
        return new EarningsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EarningsHolder holder, final int position) {
        String name=earnings.get(position);
        double money=0;
        for (Vent vent:ventList){
            if(earnings.get(position).equals(vent.getNameClient())){
                money+=vent.getPrice();
            }
        }
        String totalMoney= money+"$";
        holder.namePerson.setText(name);
        holder.money.setText(totalMoney);
    }

    @Override
    public int getItemCount() {
        if(earnings==null){
            return 0;
        }
        return earnings.size();
    }
    public List<String> nameClients(){
        List<String> earningsList=new ArrayList<>();

        for (Vent vent:ventList) {
            if(!earningsList.contains(vent.getNameClient())){
                earningsList.add(vent.getNameClient());
            }
        }
        return earningsList;
    }
}
