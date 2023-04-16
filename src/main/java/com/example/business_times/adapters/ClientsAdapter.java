package com.example.business_times.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.business_times.R;
import com.example.business_times.entities.Client;
import com.example.business_times.holders.ClientsHolder;

import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<ClientsHolder>{
    Context context;
    List<Client> clients;

    public ClientsAdapter(Context context,List<Client> clients){
        this.context=context;
        this.clients=clients;
    }
    @NonNull
    @Override
    public ClientsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_clients,parent,false);
        return new ClientsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClientsHolder holder, final int position) {
    String nameClient=clients.get(position).getName()+" "+clients.get(position).getLastName();
    holder.nameClient.setText(nameClient);
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }
}
