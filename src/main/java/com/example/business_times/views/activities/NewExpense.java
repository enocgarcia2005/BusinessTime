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
import com.example.business_times.controllers.Providers;
import com.example.business_times.controllers.Spents;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Provide;
import com.example.business_times.entities.Spent;
import com.example.business_times.entities.Vent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewExpense extends AppCompatActivity {
    Button btnNew;
    ImageView btnBack;
    Navigation navigation=new Navigation();
    Spinner spProviders;
    List<Provide> provideList;
    Providers providers=new Providers();
    Spents spents=new Spents();
    Spent spent=new Spent();
    TextView txtDetails;
    TextView txtPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);
        btnBack=findViewById(R.id.btnBackEx);
        txtPrice=findViewById(R.id.txtPriceE);
        txtDetails=findViewById(R.id.txtDetailsE);
        btnNew=findViewById(R.id.btnNewE);
        spProviders=findViewById(R.id.spProvide);

        SharedPreferences preferences=getSharedPreferences("User",Context.MODE_PRIVATE);
        String nameUser=preferences.getString("nameUser","");

        provideList=providers.getProvideList(getApplicationContext(),nameUser);
        List<String> nameProviders=new ArrayList<>();

        nameProviders.add("Seleccione un Cliente");

        for(Provide provide:provideList){
            nameProviders.add(provide.getName()+" "+provide.getLastName());
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(
                getApplicationContext(), R.layout.spinner_item,nameProviders);
        spProviders.setAdapter(arrayAdapter);

        btnNew.setOnClickListener(v->{
            if(spProviders.getSelectedItem().toString().equals("Seleccione un Cliente")){
                Toast.makeText(this, "Seleccione un cliente", Toast.LENGTH_SHORT).show();
            }else{
                String dateTime = DateTimeFormatter.ofPattern("dd MMMM yyyy",new Locale("es_Es"))
                        .format(LocalDateTime.now());
                spent.setDate(dateTime);
                spent.setDetails(txtDetails.getText().toString());
                spent.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                spent.setNameProvide(spProviders.getSelectedItem().toString());
                spent.setNameUser(nameUser);

                spents.save(spent,getApplicationContext());

                txtPrice.setText("");
                txtDetails.setText("");
                spProviders.setSelection(0);
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