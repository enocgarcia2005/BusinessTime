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
import com.example.business_times.controllers.Providers;
import com.example.business_times.controllers.Spents;
import com.example.business_times.entities.Provide;
import com.example.business_times.entities.Spent;
import com.example.business_times.holders.ProvidersHolder;
import com.example.business_times.views.activities.HomeActivity;

import java.util.List;

public class ProvideAdapter extends RecyclerView.Adapter<ProvidersHolder>{
    Context context;
    List<Provide> provideList;
    List<Spent> spentList;
    Providers providers=new Providers();
    Spents spents=new Spents();
    Navigation navigation=new Navigation();

    public ProvideAdapter(Context context,List<Provide> provideList){
        this.context=context;
        this.provideList=provideList;
    }
    @NonNull
    @Override
    public ProvidersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_provide,parent,false);
        return new ProvidersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProvidersHolder holder, final int position) {
        String nameProvide = provideList.get(position).getName() + " " + provideList.get(position).getLastName();
        holder.nameProvide.setText(nameProvide);
        String update="Actualizar";
        Provide provide = new Provide();
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(context);

        holder.setCreateContextMenu((menu, v, menuInfo) -> {
            spentList=spents.getSpentList(context,sharedPreferencesHelper.getPreferences("nameUser"));

            menu.add(update).setOnMenuItemClickListener(item -> {
                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.new_client);
                dialog.setCancelable(false);

                Button btnUpdateClient=dialog.findViewById(R.id.btnNew);
                Button btnCancel=dialog.findViewById(R.id.btnCancel);
                EditText txtNameClient=dialog.findViewById(R.id.txtNameClientAdd);
                EditText txtLastNameClient=dialog.findViewById(R.id.txtLastNameClientAdd);

                txtNameClient.setText(provideList.get(position).getName());
                txtLastNameClient.setText(provideList.get(position).getLastName());
                spentList.removeIf(spent -> !spent.getNameProvide().equals(txtNameClient.getText().toString()
                        +" "+txtLastNameClient.getText().toString()));

                btnUpdateClient.setOnClickListener(v1->{
                    provide.setId(provideList.get(position).getId());
                    provide.setName(txtNameClient.getText().toString());
                    provide.setLastName(txtLastNameClient.getText().toString());
                    provide.setUser(provideList.get(position).getUser());
                    for(Spent spent:spentList){
                        spent.setNameProvide(provide.getName()+" "+provide.getLastName());
                    }
                    spents.updateListSpent(context,spentList);
                    providers.updateProvide(context,provide);
                    this.notifyItemChanged(position);
                    dialog.cancel();
                    context.startActivity(navigation.createIntent(context, HomeActivity.class));
                });

                btnCancel.setOnClickListener(v2->dialog.cancel());
                dialog.show();
                return true;
            });
            menu.add("Eliminar").setOnMenuItemClickListener(item ->{
                providers.deleteProvide(context,provideList.get(position));
                spentList.removeIf(spent -> !spent.getNameProvide().equals(provideList.get(position).getName()
                        +" "+provideList.get(position).getLastName()));
                spents.deleteSpentList(context,spentList);
                Toast.makeText(context, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                context.startActivity(navigation.createIntent(context, HomeActivity.class));
                return true;
            });
        });
    }

    @Override
    public int getItemCount() {
        return provideList.size();
    }
}
