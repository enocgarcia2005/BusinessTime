package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.controllers.Clients;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Vent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewVentsActivity extends AppCompatActivity {
    Button btnNew;
    ImageView btnBack;
    Navigation navigation=new Navigation();
    Spinner spClients;
    List<Client> clientList;
    Clients clients=new Clients();
    Vents vents=new Vents();
    Vent vent=new Vent();
    TextView txtDetails;
    TextView txtPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vents);
        btnBack=findViewById(R.id.btnBack);
        spClients=findViewById(R.id.spClients);
        btnNew=findViewById(R.id.btnNew);
        txtPrice=findViewById(R.id.txtPriceE);
        txtDetails=findViewById(R.id.txtDetails);

        SharedPreferences preferences=getSharedPreferences("User",Context.MODE_PRIVATE);
        String nameUser=preferences.getString("nameUser","");

        clientList=clients.getClientList(getApplicationContext(),nameUser);
        List<String> nameClients=new ArrayList<>();

        nameClients.add("Seleccione un Cliente");

        for(Client client:clientList){
            nameClients.add(client.getName()+" "+client.getLastName());
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(
                getApplicationContext(), R.layout.spinner_item,nameClients);
        spClients.setAdapter(arrayAdapter);

        btnNew.setOnClickListener(v->{
            if(spClients.getSelectedItem().toString().equals("Seleccione un Cliente")){
                Toast.makeText(this, "Seleccione un cliente", Toast.LENGTH_SHORT).show();
            }else{
            String dateTime = DateTimeFormatter.ofPattern("dd de MMMM de yyyy",new Locale("es_Es"))
                    .format(LocalDateTime.now());
            vent.setDate(dateTime);
            vent.setDetails(txtDetails.getText().toString());
            vent.setPrice(Double.parseDouble(txtPrice.getText().toString()));
            vent.setNameClient(spClients.getSelectedItem().toString());
            vent.setNameUser(nameUser);

            vents.save(vent,getApplicationContext(),nameUser);

            txtPrice.setText("");
            txtDetails.setText("");
            spClients.setSelection(0);
            Toast.makeText(this, "Venta agregada correctamente", Toast.LENGTH_SHORT).show();}
        });
        btnBack.setOnClickListener(v -> startActivity(navigation.createIntent(getApplicationContext(), HomeActivity.class)));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}