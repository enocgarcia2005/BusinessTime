package com.example.business_times.views.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.views.activities.ClientsActivity;
import com.example.business_times.views.activities.MainActivity;
import com.example.business_times.views.activities.PaymentsActivity;
import com.example.business_times.views.activities.ProvideActivity;

public class ConfigFragment extends Fragment {
    CardView btnClients;
    CardView btnLogOut;
    CardView btnProvide;
    Navigation navigation=new Navigation();
    CardView btnPayments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_config, container, false);
        btnClients=view.findViewById(R.id.cardViewClients);
        btnLogOut=view.findViewById(R.id.cardViewLeave);
        btnPayments=view.findViewById(R.id.cardViewPayments);
        btnProvide=view.findViewById(R.id.cardViewProviders);

        btnClients.setOnClickListener(v->startActivity(navigation.createIntent(getContext(), ClientsActivity.class)));

        btnLogOut.setOnClickListener(v->{
            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
            builder.setMessage("Quieres cerrar sesión?").setPositiveButton("Si", (dialog, which) -> {
                SharedPreferences prefs = view.getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.apply();
                startActivity(navigation.createIntent(view.getContext(), MainActivity.class));
            }).setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        btnPayments.setOnClickListener(v->startActivity(navigation.createIntent(view.getContext(), PaymentsActivity.class)));
        btnProvide.setOnClickListener(v->startActivity(navigation.createIntent(view.getContext(), ProvideActivity.class)));
        return view;
    }
}