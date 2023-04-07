package com.example.business_times.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.config.Constant;
import com.example.business_times.databases.UserDataBase;
import com.example.business_times.entities.User;

public class RegisterActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtLastName;
    EditText txtUserName;
    EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UserDataBase userDataBase= Room.databaseBuilder(getApplicationContext(),UserDataBase.class, Constant.BD_NAME).
                allowMainThreadQueries().build();
        txtName=findViewById(R.id.txtName);
        txtLastName=findViewById(R.id.txtLastName);
         txtUserName=findViewById(R.id.txtUserNameR);
         txtPassword=findViewById(R.id.txtPaswordR);
        Button btnRegister=findViewById(R.id.btnCreateAccount);
        btnRegister.setOnClickListener(v -> {
            if (textsEmptys()){
                Toast.makeText(RegisterActivity.this, "Relleno todo los campos", Toast.LENGTH_SHORT).show();
            }else{
                User user=new User();
                user.setName(txtName.getText().toString());
                user.setLastName(txtLastName.getText().toString());
                user.setUserName(txtUserName.getText().toString());
                user.setPassword(txtPassword.getText().toString());
                userDataBase.userDao().insert(user);
                Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
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
}