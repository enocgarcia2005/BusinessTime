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

import com.example.business_times.R;
import com.example.business_times.adapters.EarningsAdapter;
import com.example.business_times.config.Navigation;
import com.example.business_times.config.SharedPreferencesHelper;
import com.example.business_times.controllers.Vents;
import com.example.business_times.entities.Vent;
import com.example.business_times.views.activities.NewVentsActivity;

import java.util.List;


public class EarningsFragment extends Fragment {
    /**
     * The object "btnAdd" has the task of save the events of the button add new vent.
     */
    Button btnAdd;

    /**
     * this list has all vents of the data base.
     */
    List<Vent> ventList;
    /**
     * The object of contains all vents and show in this fragment.
     */
    RecyclerView recyclerViewClients;
    /**
     * The object "navigation" has the unique function of create a Intent Object to navigate between activities.
     */
    Navigation navigation=new Navigation();
    Vents vents=new Vents();
    public EarningsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_earnings, container, false);

        btnAdd=view.findViewById(R.id.btnAdd);
        recyclerViewClients=view.findViewById(R.id.rwEarnigs);

        SharedPreferencesHelper sharedPreferencesHelper=new SharedPreferencesHelper(view.getContext());
        String userName=sharedPreferencesHelper.getPreferences("nameUser");

        ventList=vents.getVentList(view.getContext(),userName);
        btnAdd.setOnClickListener(v -> startActivity(navigation.createIntent(getContext(), NewVentsActivity.class)));


        recyclerViewClients.setLayoutManager(new LinearLayoutManager(getActivity()));
        EarningsAdapter earningsAdapter =new EarningsAdapter(getContext(),ventList);
        recyclerViewClients.setAdapter(earningsAdapter);
        recyclerViewClients.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
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
                    sharedPreferencesHelper.savePreferences("client",ventList.get(position).getNameClient());
                    earningsAdapter.onItemClicked(position);
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