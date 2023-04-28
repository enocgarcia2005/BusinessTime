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
import com.example.business_times.adapters.SpentAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Payments;
import com.example.business_times.controllers.Spents;
import com.example.business_times.entities.Payment;
import com.example.business_times.entities.Spent;

import java.util.Iterator;
import java.util.List;

public class SpentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Spent> spentList;
    Spents spents=new Spents();
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
        setContentView(R.layout.activity_spent);
        recyclerView=findViewById(R.id.rwSpent);
        btnPayment=findViewById(R.id.btnAddPaymentS);
        btnBack=findViewById(R.id.btnBackSpent);
        lblMoney=findViewById(R.id.lblMoneySpents);
        lblTotalVents=findViewById(R.id.lblNumberTransactionSpent);
        name=findViewById(R.id.tittleTotalSpents);
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getApplicationContext());

        spentList=spents.getSpentList(getApplicationContext(),sharedPreferencesHelper.getPreferences("nameUser"));
        spentList.removeIf(spent -> !spent.getNameProvide().equals(sharedPreferencesHelper.getPreferences("provide")));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpentAdapter spentAdapter=new SpentAdapter(SpentActivity.this,spentList);
        recyclerView.setAdapter(spentAdapter);
        updateInfo();

        btnPayment.setOnClickListener(v -> {
            final Dialog dialog=new Dialog(SpentActivity.this);
            dialog.setContentView(R.layout.add_payment);
            dialog.setCancelable(false);

            Button btnAddPayment=dialog.findViewById(R.id.btnAddNewPayment);
            Button btnCancelPayment=dialog.findViewById(R.id.btnCancelPayment);
            EditText txtPrice=dialog.findViewById(R.id.txtPricePayment);
            EditText txtDetails=dialog.findViewById(R.id.txtDetailsPayment);


            btnAddPayment.setOnClickListener(v1->{
                double totalPayment=Double.parseDouble(txtPrice.getText().toString());
                operationPayment(totalPayment);
                recyclerView.setAdapter(spentAdapter);
                updateInfo();
                payment.setDetails(txtDetails.getText().toString());
                payment.setPrice(Double.parseDouble(txtPrice.getText().toString()));
                payment.setCategory("expense");
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
        Iterator<Spent> iterator = spentList.iterator();
        while (iterator.hasNext()) {
            Spent spent = iterator.next();
            if (paymentCopy >= spent.getPrice()) {
                paymentCopy = paymentCopy - spent.getPrice();
                spents.deleteSpent(getApplicationContext(),spent);
                iterator.remove();
            } else {
                spent.setPrice(spent.getPrice() - paymentCopy);
                spents.updateSpent(getApplicationContext(),spent);
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
        for (Spent spent:spentList){
            money+= spent.getPrice();
        }
        String totalMoney=money+"$";
        String totalClient=spentList.size()+" Transacciones";

        lblMoney.setText(totalMoney);
        lblTotalVents.setText(totalClient);
        name.setText(spentList.get(0).getNameProvide());
    }
}