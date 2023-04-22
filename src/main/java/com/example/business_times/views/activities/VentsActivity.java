package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.business_times.R;
import com.example.business_times.adapters.VentsAdapter;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Vent;

import java.util.List;

public class VentsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Vent> ventList;
    Vents vents=new Vents();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vents);
        recyclerView=findViewById(R.id.rwVents);
        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(getApplicationContext());

        ventList=vents.getVentList(getApplicationContext(),sharedPreferencesHelper.getPreferences("nameUser"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VentsAdapter ventsAdapter=new VentsAdapter(getApplicationContext(),ventList);
        recyclerView.setAdapter(ventsAdapter);
    }
}