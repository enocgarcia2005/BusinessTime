package com.example.business_times.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Spents;
import com.example.business_times.entities.Spent;
import com.example.business_times.holders.SpentsHolders;
import com.example.business_times.views.activities.HomeActivity;

import java.util.List;

public class SpentAdapter extends RecyclerView.Adapter<SpentsHolders>{
    List<Spent> spentList;
    Context context;
    Spents spents=new Spents();
    SharedPreferencesHelper sharedPreferencesHelper;
    Navigation navigation=new Navigation();
    public SpentAdapter(Context context,List<Spent> spentList){
        this.context=context;
        this.spentList=spentList;
        sharedPreferencesHelper=new SharedPreferencesHelper(context);
    }
    @NonNull
    @Override
    public SpentsHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_vent,parent,false);
        return new SpentsHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpentsHolders holder, int position) {
        if(spentList.get(position).getNameProvide().equals(sharedPreferencesHelper.getPreferences("provide"))) {
            holder.ventName.setText(spentList.get(position).getDetails());
            holder.date.setText(spentList.get(position).getDate());
            holder.money.setText(String.valueOf(spentList.get(position).getPrice()));
            holder.money.setTextColor(Color.parseColor("#F23A30"));

            String update="Actualizar";
            Spent spent=spentList.get(position);
            holder.setCreateContextMenu((menu, v, menuInfo) -> {
                menu.add(update).setOnMenuItemClickListener(item -> {
                    final Dialog dialog=new Dialog(context);
                    dialog.setContentView(R.layout.add_payment);
                    dialog.setCancelable(false);

                    Button btnUpdateClient=dialog.findViewById(R.id.btnAddNewPayment);
                    Button btnCancel=dialog.findViewById(R.id.btnCancelPayment);
                    EditText txtPrice=dialog.findViewById(R.id.txtPricePayment);
                    EditText txtDetails=dialog.findViewById(R.id.txtDetailsPayment);

                    txtPrice.setText(String.valueOf(spentList.get(position).getPrice()));
                    txtDetails.setText(spentList.get(position).getDetails());

                    btnUpdateClient.setOnClickListener(v1->{
                        spent.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                        spent.setDetails(txtDetails.getText().toString());
                        spents.updateSpent(context,spent);
                        this.notifyItemChanged(position);
                        dialog.cancel();
                        context.startActivity(navigation.createIntent(context, HomeActivity.class));
                    });
                    btnCancel.setOnClickListener(v2->dialog.cancel());
                    dialog.show();
                    return true;
                });
                menu.add("Eliminar").setOnMenuItemClickListener(item ->{
                    spents.deleteSpent(context,spentList.get(position));
                    Toast.makeText(context, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                    this.notifyItemChanged(position);
                    context.startActivity(navigation.createIntent(context, HomeActivity.class));
                    return true;
                });
            });
        }
    }

    @Override
    public int getItemCount() {
        return spentList.size();
    }
}
