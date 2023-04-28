package com.example.business_times.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.holders.ExpensesHolder;
import com.example.business_times.views.activities.SpentActivity;
import com.example.business_times.config.Navigation;
import com.example.business_times.entities.Spent;

import java.util.ArrayList;
import java.util.List;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesHolder>{
        Context context;
        List<Spent> spentList;
        List<String> expenses;
        Navigation navigation=new Navigation();

    public ExpensesAdapter(Context context, List<Spent> spentList){
        this.context=context;
        this.spentList=spentList;
        expenses=nameProviders();
    }

    @NonNull
    @Override
    public ExpensesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_expenses,parent,false);
        return new ExpensesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExpensesHolder holder, final int position) {
        String name=expenses.get(position);
        double money=0;
        for (Spent spent:spentList){
        if(expenses.get(position).equals(spent.getNameProvide())){
        money+=spent.getPrice();
            }

        }
        String totalMoney= money+"$";
        holder.namePerson.setText(name);
        holder.money.setText(totalMoney);
    }

    @Override
    public int getItemCount() {
        if(expenses==null){
        return 0;
        }
        return expenses.size();
    }
    public List<String> nameProviders(){
        List<String> earningsList=new ArrayList<>();

        for (Spent spent:spentList) {
        if(!earningsList.contains(spent.getNameProvide())){
        earningsList.add(spent.getNameProvide());
            }
        }
        return earningsList;
    }

        public void onItemClicked(int position) {
        context.startActivity(navigation.createIntent(context, SpentActivity.class));
    }
}
