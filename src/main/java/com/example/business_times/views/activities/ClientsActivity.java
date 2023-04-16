package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.business_times.R;
import com.example.business_times.adapters.ClientsAdapter;
import com.example.business_times.controllers.Clients;
import com.example.business_times.entities.Client;


public class ClientsActivity extends AppCompatActivity {
    Button btnAdd;
    Clients clients=new Clients();
    Client client=new Client();
    RecyclerView rwClients;
    TextView lblTotalClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);

        btnAdd=findViewById(R.id.btnAddClient);
        rwClients=findViewById(R.id.rwClients);
        lblTotalClients=findViewById(R.id.numberClients);
        updateRecyclerView();

        btnAdd.setOnClickListener(v->{
            final Dialog dialog=new Dialog(ClientsActivity.this);
            dialog.setContentView(R.layout.new_client);
            dialog.setTitle("Agregar clientes");
            dialog.setCancelable(false);
            Button btnAddClient=dialog.findViewById(R.id.btnNew);
            Button btnCancel=dialog.findViewById(R.id.btnCancel);

            btnAddClient.setOnClickListener(v1->{
                EditText txtNameClient=dialog.findViewById(R.id.txtNameClientAdd);
                EditText txtLastNameClient=dialog.findViewById(R.id.txtLastNameClientAdd);
                client.setName(txtNameClient.getText().toString());
                client.setLastName(txtLastNameClient.getText().toString());
                client.setUser("g");

                clients.save(client,getApplicationContext());
                updateRecyclerView();
                dialog.cancel();
            });
            btnCancel.setOnClickListener(v2->dialog.cancel());
            dialog.show();
        });

    }
    public void updateRecyclerView(){
        rwClients.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ClientsAdapter clientsAdapter =new ClientsAdapter(getApplicationContext(),clients.getClientList(getApplicationContext()));
        rwClients.setAdapter(clientsAdapter);
    }
}