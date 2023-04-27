package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.business_times.R;
import com.example.business_times.adapters.PaymentsAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Payments;
import com.example.business_times.entities.Payment;

import java.util.List;

public class PaymentsActivity extends AppCompatActivity {
    ImageView btnBack;
    RecyclerView rwPayments;
    List<Payment> paymentList;
    Payments payments=new Payments();
    Navigation navigation=new Navigation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        btnBack=findViewById(R.id.btnBackPayment);
        rwPayments=findViewById(R.id.rwPayments);
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getApplicationContext());

        paymentList=payments.getAllPayments(getApplicationContext(),sharedPreferencesHelper.getPreferences("nameUser"));

        rwPayments.setLayoutManager(new LinearLayoutManager(this));
        PaymentsAdapter paymentsAdapter=new PaymentsAdapter(getApplicationContext(),paymentList);
        rwPayments.setAdapter(paymentsAdapter);
        btnBack.setOnClickListener(v->startActivity(navigation.createIntent(getApplicationContext(),HomeActivity.class)));
    }
}