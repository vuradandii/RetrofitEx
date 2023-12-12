package com.example.retrofitex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitex.R;
import com.example.retrofitex.model.ExampleModel;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleModel> exampleModelArrayList;

    public ExampleAdapter(ArrayList<ExampleModel> exampleModelArrayList) {
        this.exampleModelArrayList = exampleModelArrayList;
    }

    @NonNull
    @Override
    public ExampleAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new ExampleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.ExampleViewHolder holder, int position) {
        holder.textView.setText(exampleModelArrayList.get(position).getId());
        holder.textView1.setText(exampleModelArrayList.get(position).getCategory());
        holder.textView2.setText(exampleModelArrayList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return exampleModelArrayList.size();
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView1,textView2;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
