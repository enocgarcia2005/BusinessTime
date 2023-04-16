package com.example.business_times.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.business_times.R;
import com.example.business_times.views.fragments.ConfigFragment;
import com.example.business_times.views.fragments.EarningsFragment;
import com.example.business_times.views.fragments.ExpensesFragment;

public class HomeActivity extends AppCompatActivity {
    /**
     * The variable "ID_EARNINGS" has the number of position the button in the groups of buttons tab navigation.
     */
    private final int ID_EARNINGS=1;
    /**
     * The variable "ID_EXPENSES" has the number of position the button in the groups of buttons tab navigation.
     */
    private final int ID_EXPENSES=2;
    /**
     * The variable "ID_ACCOUNT" has the number of position the button in the groups of buttons tab navigation.
     */
    private final int ID_ACCOUNT=3;
    /**
     * This object is created to save the fragment depending the button clicked in the button tab navigator.
     */
    Fragment fragment;

    /**
     * This method contain the configuration of meow button navigation, depending of is clicked load the fragment corresponding.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MeowBottomNavigation meowBottomNavigation=findViewById(R.id.bottomNavigation);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(ID_EARNINGS,R.drawable.baseline_attach_money_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(ID_EXPENSES,R.drawable.baseline_money_off_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.baseline_manage_accounts_24));

        meowBottomNavigation.setOnClickMenuListener(item -> {});

        meowBottomNavigation.setOnShowListener(
                item -> {
                    switch (item.getId()){
                        case ID_EARNINGS:
                            fragment=new EarningsFragment();
                            break;
                        case ID_EXPENSES:
                            fragment=new ExpensesFragment();
                            break;
                        case ID_ACCOUNT:
                            fragment=new ConfigFragment();
                            break;
                    }
                    loadFragment(fragment);
                });

        meowBottomNavigation.setOnReselectListener(item -> {});

        meowBottomNavigation.setCount(ID_EXPENSES,"10");
        meowBottomNavigation.show(ID_EARNINGS,true);
    }
    /**
     * This method load a fragment in the activity.
     * @param fragment- the fragment that want load.
     */
    public void loadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerL,fragment,null)
                .commit();
    }
    /**
     * This method is empty to disabled the event of the button back the device and only use the btnBack created for the developer.
     */
    @Override
    public void onBackPressed() {}
}