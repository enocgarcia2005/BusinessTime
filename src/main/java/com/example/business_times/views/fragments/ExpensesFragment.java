package com.example.business_times.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.business_times.views.activities.NewExpense;
import com.example.business_times.R;
import com.example.business_times.config.Navigation;


public class ExpensesFragment extends Fragment {
    Button btnAdd;
    Navigation navigation=new Navigation();
    public ExpensesFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View view=inflater.inflate(R.layout.fragment_expenses, container, false);
         btnAdd=view.findViewById(R.id.btnAddE);

         btnAdd.setOnClickListener(v->navigation.createIntent(getContext(), NewExpense.class));
        return view;
    }
}