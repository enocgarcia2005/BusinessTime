package com.example.business_times.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.business_times.R;

public class HomeActivity extends AppCompatActivity {
    private final int ID_EARNINGS=1;
    private final int ID_EXPENSES=2;
    private final int ID_ACCOUNT=3;

    Fragment fragmentA;
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
                            fragmentA=new EarningsFragment();
                            break;
                        case ID_EXPENSES:
                            fragmentA=new ExpensesFragment();
                            break;
                        case ID_ACCOUNT:
                            fragmentA=new ConfigFragment();
                            break;
                    }
                    loadFragment(fragmentA);
                });
        meowBottomNavigation.setOnReselectListener(item -> {});

        meowBottomNavigation.setCount(ID_EXPENSES,"10");
        meowBottomNavigation.show(ID_EARNINGS,true);
    }

    public void loadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerL,fragment,null)
                .commit();
    }
}