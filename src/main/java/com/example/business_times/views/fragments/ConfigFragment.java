package com.example.business_times.views.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.views.activities.ClientsActivity;

public class ConfigFragment extends Fragment {
    CardView btnClients;
    Navigation navigation=new Navigation();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_config, container, false);
        btnClients=view.findViewById(R.id.cardViewClients);

        btnClients.setOnClickListener(v->startActivity(navigation.createIntent(getContext(), ClientsActivity.class)));
        return view;
    }
}