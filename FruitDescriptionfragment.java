package com.example.fragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FruitDescriptionfragment extends Fragment {
    public static FruitDescriptionfragment instance(String Description , String Price) {
        FruitDescriptionfragment fruitDescriptionfragment = new FruitDescriptionfragment();

        Bundle args = new Bundle();
        args.putString("argDescription", Description);
        args.putString("argPrice", Price);


        fruitDescriptionfragment.setArguments(args);

        return fruitDescriptionfragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apple, container, false);
        TextView textView = view.findViewById(R.id.textViewdescription);
        TextView textView1 = view.findViewById(R.id.textviewprice);

       String Description = getArguments().getString("argDescription");
       String Price =getArguments().getString("argPrice");

        textView.setText(Description);
        textView1.setText(Price);


        return view;


    }

}