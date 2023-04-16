package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.business_times.R;
import com.example.business_times.config.CheckText;
import com.example.business_times.config.Navigation;
import com.example.business_times.controllers.Users;
import com.example.business_times.entities.User;
import com.example.business_times.views.activities.MainActivity;

/**
 * This class is connected with the xml "activity_login",and have all configuration of navigation on click any button,
 * validate if all texts fields are empty and access to Home if user name and password is corrects with the data base information.
 */
public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    /**
     * The object "checkText" has 2 task, identify if there are a text field empty and show a error message on that is empty.
     */
    CheckText checkText=new CheckText();
    /**
     * The object "txtName" has the information written in text field of the name.
     */
    EditText txtName;
    /**
     * The object "txtLastName" has the information written in text field of the last name.
     */
    EditText txtLastName;

    /**
     * The object "txtPassword" has the information written in text field of the password.
     */
    EditText txtPassword;
    /**
     * The object "txtUserName" has the information written in the text field of the user name.
     */
    EditText txtUserName;
    /**
     * The object "btnBack" has the function of return the activity previous.
     */
    ImageView btnBack;
    /**
     * The object "navigation" has the unique function of create a Intent Object to navigate between activities.
     */
    Navigation navigation=new Navigation();
    /**
     * The object "users" connect with operation in data base with data written for the user.
     */
    Users users=new Users();
    /**
     * The object "user" save information written in texts fields for the user.
     */
    User user=new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBack=findViewById(R.id.btnBackToWelcomeActivity);
        btnRegister=findViewById(R.id.btnGoToHome);
        txtName=findViewById(R.id.txtName);
        txtLastName=findViewById(R.id.txtLastName);
        txtUserName=findViewById(R.id.txtUserName);
        txtPassword=findViewById(R.id.txtPasword);


        btnRegister.setOnClickListener(v -> {
            txtName.setError(null);
            txtLastName.setError(null);
            txtUserName.setError(null);
            txtPassword.setError(null);

            EditText[]editTexts={txtPassword,txtUserName,txtLastName,txtName};

            if (checkText.textEmpty(editTexts)){
                checkText.selectError(editTexts);
            }else{
                user.setName(txtName.getText().toString());
                user.setLastName(txtLastName.getText().toString());
                user.setUserName(txtUserName.getText().toString());
                user.setPassword(txtPassword.getText().toString());

                users.save(user,getApplicationContext());
            }
        });

        btnBack.setOnClickListener(v->startActivity(navigation.createIntent(getApplicationContext(), MainActivity.class)));
    }
    /**
     * This method is empty to disabled the event of the button back the device and only use the btnBack created for the developer.
     */
    @Override
    public void onBackPressed() {}
}