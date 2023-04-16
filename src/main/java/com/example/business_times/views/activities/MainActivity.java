package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;

/**
 * This class is connected with the xml "activity_main",and have all configuration of navigation on click any button.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The object "navigation" has the unique function of create a Intent Object to navigate between activities.
     */
    private final Navigation navigation =new Navigation();

    /**
     * This method contain the events "onClickListener" of buttons:(btnLogin,btnRegister).
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnLogin);
        TextView btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> startActivity(navigation.createIntent(getApplicationContext(), LoginActivity.class)));
        btnRegister.setOnClickListener(v->startActivity(navigation.createIntent(getApplicationContext(), RegisterActivity.class)));
    }
}