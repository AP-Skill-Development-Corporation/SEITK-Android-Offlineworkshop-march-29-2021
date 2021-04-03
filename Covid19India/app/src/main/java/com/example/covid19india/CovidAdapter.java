package com.example.covid19india;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.MyViewHolder> {

    List<CovidData> myList;
    Context ct;
    public CovidAdapter(MainActivity mainActivity, List<CovidData> list) {
        myList = list;
        ct = mainActivity;
    }

    @NonNull
    @Override
    public CovidAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct)
                .inflate(R.layout.row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.MyViewHolder holder, int position) {
        holder.tv_date.setText(myList.get(position).getDate());
        holder.tv_active.setText(myList.get(position).getActivecases());
        holder.tv_recovered.setText(myList.get(position).getRecovered());
        holder.tv_deaths.setText(myList.get(position).getDetahs());
        holder.tv_confimed.setText(myList.get(position).getConfirmedcases());

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date,tv_active,tv_confimed,tv_recovered,tv_deaths;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_active = itemView.findViewById(R.id.tv_active);
            tv_confimed = itemView.findViewById(R.id.tv_confimed);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_recovered = itemView.findViewById(R.id.tv_recovered);
            tv_deaths =itemView.findViewById(R.id.tv_deaths);
        }
    }
}
