
package com.example.fragment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.example.fragment1.MainActivity.fragmentManager;


public class  Loginpage extends Fragment {
    private Button b1, b2;
    private EditText e1, e2;
    public static final String MyPREFERENCES = "MYPREF" ;
    public static final String Name = "nameKey";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loginpage, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences("MYPREFERENCES",Context.MODE_PRIVATE);

        final String uname = pref.getString(Name,null);
        b1 = (Button)view.findViewById(R.id.button);
        e1 =  (EditText)view.findViewById(R.id.username);
        e2 =  (EditText)view.findViewById(R.id.password);
        b2 = (Button)view.findViewById(R.id.button2);
        e1.setText(uname);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().equals("Maymol") &&
                        e2.getText().toString().equals("admin")) {
                    String n = e1.getText().toString().trim();
                   SharedPreferences.Editor editor = pref.edit();
                    editor.putString(Name, n);

                   editor.commit();
                   Firstfragment firstfragment = Firstfragment.newInstance(n);
                    //Bundle bundle=new Bundle();
                   // bundle.putString("value",e1.getText().toString());
                   // firstfragment.setArguments(bundle);
                    FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main,firstfragment);
                    fragmentTransaction.commit();
                    //MainActivity.fragmentManager.beginTransaction().replace(R.id.main, new Firstfragment(), null).commit();

                } else {
                    Toast.makeText(getContext(), "Invalid feilds", Toast.LENGTH_SHORT).show();
                }
            }
            });
        return  view;

    }
}