package com.example.business_times.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;

public class MainActivity extends AppCompatActivity {
    private final Navigation navigation =new Navigation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(v -> startActivity(navigation.createIntent(getApplicationContext(),LoginActivity.class)));
        btnRegister.setOnClickListener(v->startActivity(navigation.createIntent(getApplicationContext(),RegisterActivity.class)));
    }
}