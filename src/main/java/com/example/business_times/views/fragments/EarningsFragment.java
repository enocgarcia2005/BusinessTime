package com.example.business_times.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.business_times.R;
import com.example.business_times.adapters.EarningsAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.entities.Client;
import com.example.business_times.entities.Vent;
import com.example.business_times.views.activities.NewVentsActivity;

import java.util.ArrayList;
import java.util.List;


public class EarningsFragment extends Fragment {
    /**
     * The object "btnAdd" has the task of save the events of the button add new vent.
     */
    Button btnAdd;
    /**
     * this list has all clients of the data base.
     */
    List<Client> clients;
    /**
     * this list has all vents of the data base.
     */
    List<Vent> vents;
    /**
     * The object of contains all vents and show in this fragment.
     */
    RecyclerView recyclerViewClients;
    /**
     * The object "navigation" has the unique function of create a Intent Object to navigate between activities.
     */
    Navigation navigation=new Navigation();
    public EarningsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_earnings, container, false);

        btnAdd=view.findViewById(R.id.btnAdd);
        recyclerViewClients=view.findViewById(R.id.rwEarnigs);

        btnAdd.setOnClickListener(v -> startActivity(navigation.createIntent(getContext(), NewVentsActivity.class)));


        recyclerViewClients.setLayoutManager(new LinearLayoutManager(getContext()));
        EarningsAdapter earningsAdapter =new EarningsAdapter(getContext(),clients,vents);
        recyclerViewClients.setAdapter(earningsAdapter);
         return view;
    }
}