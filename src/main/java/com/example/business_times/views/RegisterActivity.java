package com.example.business_times.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.controllers.Users;
import com.example.business_times.entities.User;

public class RegisterActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtLastName;
    EditText txtUserName;
    EditText txtPassword;
    User user=new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtName=findViewById(R.id.txtName);
        txtLastName=findViewById(R.id.txtLastName);
        txtUserName=findViewById(R.id.txtUserNameR);
        txtPassword=findViewById(R.id.txtPaswordR);
        Button btnRegister=findViewById(R.id.btnCreateAccount);

        Users users =new Users();

        btnRegister.setOnClickListener(v -> {
            if (textsEmptys()){
                Toast.makeText(RegisterActivity.this, "Relleno todo los campos", Toast.LENGTH_SHORT).show();
            }else{
                users.save(create(),getApplicationContext());
            }
        });
    }
    public boolean textsEmptys(){
        boolean name=txtName.getText().toString().equals("");
        boolean lastName=txtLastName.getText().toString().equals("");
        boolean userName=txtUserName.getText().toString().equals("");
        boolean password=txtPassword.getText().toString().equals("");
        return name||lastName||userName||password;
    }
    public User create(){
        user.setName(txtName.getText().toString());
        user.setLastName(txtLastName.getText().toString());
        user.setUserName(txtUserName.getText().toString());
        user.setPassword(txtPassword.getText().toString());
        return user;
    }
}