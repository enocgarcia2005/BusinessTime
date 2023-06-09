package com.example.business_times.adapters;

import android.app.Dialog;
import android.content.Context;
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
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Vent;
import com.example.business_times.holders.VentsHolder;
import com.example.business_times.views.activities.HomeActivity;

import java.util.List;


public class VentsAdapter extends RecyclerView.Adapter<VentsHolder>{
    List<Vent> ventList;
    Context context;
    Vents vents=new Vents();
    SharedPreferencesHelper sharedPreferencesHelper;
    Navigation navigation=new Navigation();
    public VentsAdapter(Context context,List<Vent> ventList){
        this.context=context;
        this.ventList=ventList;
        sharedPreferencesHelper=new SharedPreferencesHelper(context);
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

            String update="Actualizar";
            Vent vent=ventList.get(position);
            holder.setCreateContextMenu((menu, v, menuInfo) -> {
                menu.add(update).setOnMenuItemClickListener(item -> {
                    final Dialog dialog=new Dialog(context);
                    dialog.setContentView(R.layout.add_payment);
                    dialog.setCancelable(false);

                    Button btnUpdateClient=dialog.findViewById(R.id.btnAddNewPayment);
                    Button btnCancel=dialog.findViewById(R.id.btnCancelPayment);
                    EditText txtPrice=dialog.findViewById(R.id.txtPricePayment);
                    EditText txtDetails=dialog.findViewById(R.id.txtDetailsPayment);

                    txtPrice.setText(String.valueOf(ventList.get(position).getPrice()));
                    txtDetails.setText(ventList.get(position).getDetails());

                    btnUpdateClient.setOnClickListener(v1->{
                        vent.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                        vent.setDetails(txtDetails.getText().toString());
                        vents.updateVents(context,vent);
                        this.notifyItemChanged(position);
                        dialog.cancel();
                        context.startActivity(navigation.createIntent(context, HomeActivity.class));
                    });
                    btnCancel.setOnClickListener(v2->dialog.cancel());
                    dialog.show();
                    return true;
                });
                menu.add("Eliminar").setOnMenuItemClickListener(item ->{
                    Vent vent1=ventList.get(position);
                    vents.deleteVents(context,vent1);
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
        return ventList.size();
    }
}
