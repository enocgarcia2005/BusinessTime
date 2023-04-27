package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.adapters.VentsAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Payments;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Payment;
import com.example.business_times.entities.Vent;

import java.util.Iterator;
import java.util.List;

public class VentsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Vent> ventList;
    Vents vents=new Vents();
    Button btnPayment;
    ImageView btnBack;
    Navigation navigation=new Navigation();
    TextView lblMoney;
    TextView lblTotalVents;
    TextView name;
    Payment payment=new Payment();
    Payments payments=new Payments();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vents);
        recyclerView=findViewById(R.id.rwVents);
        btnPayment=findViewById(R.id.btnAddPayment);
        btnBack=findViewById(R.id.btnBackVent);
        lblMoney=findViewById(R.id.lblMoneyVents);
        lblTotalVents=findViewById(R.id.lblNumberTransaction);
        name=findViewById(R.id.tittleTotalVents);
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getApplicationContext());

        ventList=vents.getVentList(getApplicationContext(),sharedPreferencesHelper.getPreferences("nameUser"));
        ventList.removeIf(vent -> !vent.getNameClient().equals(sharedPreferencesHelper.getPreferences("client")));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VentsAdapter ventsAdapter=new VentsAdapter(getApplicationContext(),ventList);
        recyclerView.setAdapter(ventsAdapter);
        updateInfo();

        btnPayment.setOnClickListener(v -> {
            final Dialog dialog=new Dialog(VentsActivity.this);
            dialog.setContentView(R.layout.add_payment);
            dialog.setCancelable(false);

            Button btnAddPayment=dialog.findViewById(R.id.btnAddNewPayment);
            Button btnCancelPayment=dialog.findViewById(R.id.btnCancelPayment);
            EditText txtPrice=dialog.findViewById(R.id.txtPricePayment);
            EditText txtDetails=dialog.findViewById(R.id.txtDetailsPayment);


            btnAddPayment.setOnClickListener(v1->{
                double totalPayment=Double.parseDouble(txtPrice.getText().toString());
                operationPayment(totalPayment);
                recyclerView.setAdapter(ventsAdapter);
                updateInfo();
                payment.setDetails(txtDetails.getText().toString());
                payment.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                payment.setCategory("earnings");
                payment.setUserName(sharedPreferencesHelper.getPreferences("nameUser"));
                payments.save(getApplicationContext(),payment);
                dialog.cancel();
            });

            btnCancelPayment.setOnClickListener(v1->dialog.cancel());

            dialog.show();
        });
        btnBack.setOnClickListener(v->startActivity(navigation.createIntent(getApplicationContext(),HomeActivity.class)));
    }
    public void operationPayment(double payment){
        double paymentCopy = payment;
        Iterator<Vent> iterator = ventList.iterator();
        while (iterator.hasNext()) {
            Vent vent = iterator.next();
            if (paymentCopy >= vent.getPrice()) {
                paymentCopy = paymentCopy - vent.getPrice();
                vents.deleteVents(getApplicationContext(),vent);
                iterator.remove();
            } else {
                vent.setPrice(vent.getPrice() - paymentCopy);
                vents.updateVents(getApplicationContext(),vent);
                paymentCopy = 0;
            }
            if (paymentCopy == 0) {
                Toast.makeText(this, "Abono registrado correctamente", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
    public void updateInfo(){
        double money=0;
        for (Vent vent:ventList){
            money+= vent.getPrice();
        }
        String totalMoney=money+"$";
        String totalClient=ventList.size()+" Transacciones";

        lblMoney.setText(totalMoney);
        lblTotalVents.setText(totalClient);
        name.setText(ventList.get(0).getNameClient());
    }
}