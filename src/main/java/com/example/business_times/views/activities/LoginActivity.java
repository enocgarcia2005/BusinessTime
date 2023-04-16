package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.business_times.R;
import com.example.business_times.config.CheckText;
import com.example.business_times.config.Navigation;
import com.example.business_times.controllers.Users;
import com.example.business_times.entities.User;

/**
 * This class is connected with the xml "activity_login",and have all configuration of navigation on click any button,
 * validate if all texts fields are empty and access to Home if user name and password is corrects with the data base information.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * The object "btnLogin" is a button that if you click validate if the user name and passwords is corrects and if all texts fields
     * are empty.
     */
    Button btnLogin;
    /**
     * The object "checkText" has 2 task, identify if there are a text field empty and show a error message on that is empty.
     */
    CheckText checkText=new CheckText();
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

    /**
     * This method contain the event of the btnLogin and all validations of the accounts and event btnBack.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnBack=findViewById(R.id.btnBackToWelcomeActivity);
        btnLogin=findViewById(R.id.btnGoToHome);
        txtUserName=findViewById(R.id.txtUserName);
        txtPassword=findViewById(R.id.txtPasword);

        btnLogin.setOnClickListener(v -> {
            txtUserName.setError(null);
            txtPassword.setError(null);

            EditText[]editTexts={txtPassword,txtUserName};

            if (checkText.textEmpty(editTexts)){
                checkText.selectError(editTexts);
            }else{
                user.setName("-");
                user.setLastName("-");
                user.setUserName(txtUserName.getText().toString());
                user.setPassword(txtPassword.getText().toString());

            String answer=users.validate(user,getApplicationContext());
                if ("bienvenido".equals(answer)) {
                    startActivity(navigation.createIntent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
                }
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