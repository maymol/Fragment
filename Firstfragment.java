   package com.example.fragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


  public class Firstfragment extends Fragment implements RecyclerViewClickInterface {


      private TextView textView;
      Bottomsheet bottomsheet;
      private ArrayList<Fruitname> fruitArray = new ArrayList<>();


      //final String[] fruitArray = {"Apple", "Grapes", "Orange", "Pineapple","Banana", "Pineapple", "Strawberry","Jackfruit"};

      public static Firstfragment newInstance(String text) {
          Firstfragment firstfragment = new Firstfragment();

          Bundle args = new Bundle();
          args.putString("argText", text);
          firstfragment.setArguments(args);

          return firstfragment;

      }

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          // Bundle  bundle=getArguments();
          String text = getArguments().getString("argText");
          //String data=bundle.getString("value");
          View view = inflater.inflate(R.layout.fragment_firstfragment, container, false);
          RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerlist);
          recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

          fruitArray.add(new Fruitname("Apple", "Apple is red", "Price is 56"));
          fruitArray.add(new Fruitname("Grapes", "Grapes are violet", "Price is 64"));
          fruitArray.add(new Fruitname("Pineapple", "Pieapple is yellow.", "Price is 44"));
          fruitArray.add(new Fruitname("Orange", "Orange is orange", "Price is 55"));
          fruitArray.add(new Fruitname("Blackberry", "Blackberry is black", "Price is 55"));
          fruitArray.add(new Fruitname("Blueberry", "Blueberry is blue", "Price is 66"));
          fruitArray.add(new Fruitname("Orange", "Mango is yellow", "Price is 44"));
          fruitArray.add(new Fruitname("Dragonfruit", "Dragonfruit colour is pink", "Price is 44"));
          fruitArray.add(new Fruitname("Dragonfruit", "Dragonfruit colour is pink", "Price is 44"));
          fruitArray.add(new Fruitname("Dragonfruit", "Dragonfruit colour is pink", "Price is 44"));
          fruitArray.add(new Fruitname("Dragonfruit", "Dragonfruit colour is pink", "Price is 44"));
          fruitArray.add(new Fruitname("Dragonfruit", "Dragonfruit colour is pink", "Price is 44"));








          RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), fruitArray, this);
          recyclerView.setAdapter(adapter);


          //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, fruitArray);
          // list= Arrays.asList(getResources().getStringArray(R.array.fruits));


          //ListView list = (ListView) view.findViewById(R.id.fruitlist);
          //list.setAdapter(adapter);
          textView = (TextView) view.findViewById(R.id.text);
          textView.setText("welcome" + text);

           /* list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> Parent, View view, int position, long id) {
                String selectedItem = (String) Parent.getItemAtPosition(position);
                if(position==0)
                {
                Apple apple = new Apple();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.first, apple);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();}
                else if(position==1){
                    Grapes grapes=new Grapes();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.first, grapes);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();}


                else if(position==2){
                    Orange orange=new Orange();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.first, orange);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();}



            });*/
          return view;

      }


      @Override

      public void OnItemClick(int position) {



         if(position<fruitArray.size()) {

              Fruitname fruitname = fruitArray.get(position);
              FruitDescriptionfragment fruitDescriptionfragment = FruitDescriptionfragment.instance(fruitname.getDescription(), fruitname.getPrice());
              FragmentManager fragmentManager = getFragmentManager();
              fragmentManager.beginTransaction()
                      .replace(R.id.first, fruitDescriptionfragment).commit();
          }
      }

  }

















       /* if(position==0){
                  FruitDescriptionfragment descriptionfragment = new FruitDescriptionfragment();


                  FragmentManager fragmentManager = getFragmentManager();

                  fragmentManager.beginTransaction()
                          .replace(R.id.first, descriptionfragment).commit();
                  textView.setText("name =Apple");
                  textView.setText("Description=Apple is red");
                  Fruitname fruitname=new Fruitname("Apple","Apple is red","12");
                  textView.setText(fruitname.getDescription());
        }
        else{
            Toast.makeText(getContext(),"ffffff",Toast.LENGTH_LONG).show();
        }

                  //Fruitname fruitname = new Fruitname("pos","des","12");
                 // String n = fruitname.getName();
                   //FruitDescriptionfragment fruitDescriptionfragment = new FruitDescriptionfragment().instance(n);



      }
  }











       /* if (position == 0) {
            FruitDescriptionfragment descriptionfragment = new FruitDescriptionfragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.first, descriptionfragment);
            fragmentTransaction.addToBackStack(null);
        }
        else if(position==1){
            Toast.makeText(getContext(),"dddd",Toast.LENGTH_SHORT).show();

          }


        }
        }*/












