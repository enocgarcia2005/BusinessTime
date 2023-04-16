package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.views.activities.HomeActivity;

public class NewVentsActivity extends AppCompatActivity {
    ImageView btnBack;
    Navigation navigation=new Navigation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vents);
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> startActivity(navigation.createIntent(getApplicationContext(), HomeActivity.class)));
    }
}