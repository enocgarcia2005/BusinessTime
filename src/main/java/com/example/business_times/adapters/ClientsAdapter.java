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
import com.example.business_times.controllers.Clients;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Vent;
import com.example.business_times.holders.ClientsHolder;
import com.example.business_times.views.activities.HomeActivity;

import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<ClientsHolder>{
    Context context;
    List<Client> clientList;
    List<Vent> ventList;
    Clients clients=new Clients();
    Vents vents=new Vents();
Navigation navigation=new Navigation();


    public ClientsAdapter(Context context,List<Client> clients){
        this.context=context;
        this.clientList=clients;
    }
    @NonNull
    @Override
    public ClientsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_clients,parent,false);
        return new ClientsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClientsHolder holder, final int position) {
        String nameClient = clientList.get(position).getName() + " " + clientList.get(position).getLastName();
        holder.nameClient.setText(nameClient);
        String update="Actualizar";
        Client client = new Client();
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(context);

        holder.setCreateContextMenu((menu, v, menuInfo) -> {
            ventList=vents.getVentList(context,sharedPreferencesHelper.getPreferences("nameUser"));

            menu.add(update).setOnMenuItemClickListener(item -> {
                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.new_client);
                dialog.setCancelable(false);

                Button btnUpdateClient=dialog.findViewById(R.id.btnNew);
                Button btnCancel=dialog.findViewById(R.id.btnCancel);
                EditText txtNameClient=dialog.findViewById(R.id.txtNameClientAdd);
                EditText txtLastNameClient=dialog.findViewById(R.id.txtLastNameClientAdd);

                txtNameClient.setText(clientList.get(position).getName());
                txtLastNameClient.setText(clientList.get(position).getLastName());
                ventList.removeIf(vent -> !vent.getNameClient().equals(txtNameClient.getText().toString()
                        +" "+txtLastNameClient.getText().toString()));

                btnUpdateClient.setOnClickListener(v1->{
                    client.setId(clientList.get(position).getId());
                    client.setName(txtNameClient.getText().toString());
                    client.setLastName(txtLastNameClient.getText().toString());
                    client.setUser(clientList.get(position).getUser());
                    for(Vent vent:ventList){
                        vent.setNameClient(client.getName()+" "+client.getLastName());
                    }
                    vents.updateListVents(context,ventList);
                    clients.updateClient(context,client);
                    this.notifyItemChanged(position);
                    dialog.cancel();
                    context.startActivity(navigation.createIntent(context, HomeActivity.class));

                });

                btnCancel.setOnClickListener(v2->dialog.cancel());
                dialog.show();
                return true;
            });
            menu.add("Eliminar").setOnMenuItemClickListener(item ->{
                clients.deleteClient(context,clientList.get(position));
                ventList.removeIf(vent -> !vent.getNameClient().equals(clientList.get(position).getName()
                        +" "+clientList.get(position).getLastName()));
                vents.deleteVentList(context,ventList);
                Toast.makeText(context, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                context.startActivity(navigation.createIntent(context, HomeActivity.class));
                return true;
            });
        });
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }
}
