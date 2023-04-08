package com.example.business_times.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.controllers.Users;
import com.example.business_times.entities.User;

public class LoginActivity extends AppCompatActivity {
    EditText txtUserName;
    EditText txtPassword;
    User user=new User();
    Navigation navigation=new Navigation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnLogin=findViewById(R.id.btnToAcces);
        txtUserName=findViewById(R.id.txtUserNameL);
        txtPassword=findViewById(R.id.txtPaswordL);

        Users users=new Users();
        btnLogin.setOnClickListener(v -> {
            if (textsEmptys()){
                Toast.makeText(LoginActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            }else{
                answer(users.validate(create(),getApplicationContext()));
            }
        });

    }
    public boolean textsEmptys(){
        boolean userName=txtUserName.getText().toString().equals("");
        boolean password=txtPassword.getText().toString().equals("");
        return userName||password;
    }
    public User create(){
        user.setName("def");
        user.setLastName("def");
        user.setUserName(txtUserName.getText().toString());
        user.setPassword(txtPassword.getText().toString());
        return user;
    }
    public void answer(String answer){
        if(answer.equalsIgnoreCase("bienvenido")){
            startActivity(navigation.createIntent(getApplicationContext(),HomeActivity.class));
        }else{
            Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
        }
    }

}