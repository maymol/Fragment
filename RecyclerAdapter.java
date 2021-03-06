package com.example.fragment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class  RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private RecyclerViewClickInterface recyclerViewClickInterface;

    private List<Fruitname> fruitArray;

    public RecyclerAdapter(Context context, ArrayList<Fruitname> fruitArray, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.fruitArray = fruitArray;
        this.recyclerViewClickInterface =recyclerViewClickInterface;
        this.layoutInflater= LayoutInflater.from(context);
    }

    private LayoutInflater layoutInflater;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =layoutInflater.inflate(R.layout.recyclerlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruitname fruits =fruitArray.get(position);


        holder.textViewname.setText(fruits.getName());
      // holder.textViewdes.setText(fruits.getDescription());
      //holder.textViewprice.setText(fruits.getPrice());

    }

    @Override
    public int getItemCount() {
        return fruitArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewname;
        TextView textViewdes;
        TextView textViewprice;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.fruitlist);
            textViewname=itemView.findViewById(R.id.name);
            textViewdes=itemView.findViewById(R.id.description);
            textViewprice=itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewClickInterface.OnItemClick(getAdapterPosition());

                }
            });
        }
    }
}

