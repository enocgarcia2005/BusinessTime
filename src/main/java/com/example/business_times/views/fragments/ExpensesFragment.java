package com.example.business_times.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.business_times.adapters.ExpensesAdapter;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Spents;
import com.example.business_times.entities.Spent;
import com.example.business_times.views.activities.NewExpense;
import com.example.business_times.R;
import com.example.business_times.config.Navigation;
import com.example.business_times.views.activities.NewVentsActivity;

import java.util.List;


public class ExpensesFragment extends Fragment {
    Button btnAdd;
    List<Spent> spentList;
    RecyclerView recyclerViewExpenses;
    Navigation navigation=new Navigation();
    Spents spents=new Spents();
    public ExpensesFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View view=inflater.inflate(R.layout.fragment_expenses, container, false);
         btnAdd=view.findViewById(R.id.btnAddE);
         recyclerViewExpenses=view.findViewById(R.id.rwExpenses);

         btnAdd.setOnClickListener(v->startActivity(navigation.createIntent(getContext(), NewExpense.class)));

        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(view.getContext());
        String userName=sharedPreferencesHelper.getPreferences("nameUser");

        spentList=spents.getSpentList(view.getContext(),userName);

        recyclerViewExpenses.setLayoutManager(new LinearLayoutManager(getActivity()));
        ExpensesAdapter expensesAdapter =new ExpensesAdapter(getContext(),spentList);
        recyclerViewExpenses.setAdapter(expensesAdapter);
        recyclerViewExpenses.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            final GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(view.getContext());
                    sharedPreferencesHelper.savePreferences("provide",spentList.get(position).getNameProvide());
                    expensesAdapter.onItemClicked(position);
                    return true;
                }
                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
        });
        return view;
    }
}