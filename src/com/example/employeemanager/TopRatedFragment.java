package com.example.employeemanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class TopRatedFragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,     Bundle savedInstanceState) 
    {
 
        View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
         
        return rootView;
       
    }
}