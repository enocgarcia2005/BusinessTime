package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.business_times.R;
import com.example.business_times.adapters.ProvideAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.controllers.Providers;
import com.example.business_times.entities.Provide;

import java.util.List;

public class ProvideActivity extends AppCompatActivity {
    Button btnAdd;
    ImageView btnBack;
    Providers providers=new Providers();
    Provide provide=new Provide();
    List<Provide> provideList;
    RecyclerView rwProviders;
    TextView lblTotalProviders;
    Navigation navigation=new Navigation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide);
        btnAdd=findViewById(R.id.btnAddProvider);
        rwProviders=findViewById(R.id.rwProviders);
        lblTotalProviders=findViewById(R.id.numberProviders);
        btnBack=findViewById(R.id.btnBackProvide);

        SharedPreferences preferences=getSharedPreferences("User", Context.MODE_PRIVATE);
        String nameUser=preferences.getString("nameUser","");

        provideList=providers.getProvideList(getApplicationContext(),nameUser);
        String totalClient=provideList.size()+"";
        lblTotalProviders.setText(totalClient);

        btnAdd.setOnClickListener(v->{
            final Dialog dialog=new Dialog(ProvideActivity.this);
            dialog.setContentView(R.layout.new_client);
            dialog.setTitle("Agregar clientes");
            dialog.setCancelable(false);
            Button btnAddClient=dialog.findViewById(R.id.btnNew);
            Button btnCancel=dialog.findViewById(R.id.btnCancel);

            btnAddClient.setOnClickListener(v1->{
                EditText txtNameClient=dialog.findViewById(R.id.txtNameClientAdd);
                EditText txtLastNameClient=dialog.findViewById(R.id.txtLastNameClientAdd);
                provide.setName(txtNameClient.getText().toString());
                provide.setLastName(txtLastNameClient.getText().toString());
                provide.setUser(nameUser);

                providers.save(provide,getApplicationContext(),nameUser);
                updateRecyclerView(nameUser);
                provideList=providers.getProvideList(getApplicationContext(),nameUser);
                String totalClient2=provideList.size()+"";
                lblTotalProviders.setText(totalClient2);
                dialog.cancel();
            });
            btnCancel.setOnClickListener(v2->dialog.cancel());
            dialog.show();
        });
        btnBack.setOnClickListener(v -> startActivity(navigation.createIntent(getApplicationContext(), HomeActivity.class)));
        updateRecyclerView(nameUser);

    }
    public void updateRecyclerView(String userName){
        rwProviders.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ProvideAdapter provideAdapter =new ProvideAdapter(ProvideActivity.this,providers.getProvideList(getApplicationContext(),userName));
        rwProviders.setAdapter(provideAdapter);
    }
}