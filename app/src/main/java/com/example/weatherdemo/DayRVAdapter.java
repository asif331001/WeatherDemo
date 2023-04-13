package com.example.weatherdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DayRVAdapter extends RecyclerView.Adapter<DayRVAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DayRVModel> dayRVModelArrayList;

    public DayRVAdapter(Context context, ArrayList<DayRVModel> dayRVModelArrayList) {
        this.context = context;
        this.dayRVModelArrayList = dayRVModelArrayList;
    }

    @NonNull
    @Override
    public DayRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_rv_item, parent, false);
        return new DayRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayRVAdapter.MyViewHolder holder, int position) {
        if (dayRVModelArrayList == null || dayRVModelArrayList.isEmpty()) {
            return;
        }
        DayRVModel dayRVModel = dayRVModelArrayList.get(position);

        if(holder.dayTV != null) {
            holder.dayTV.setText(dayRVModel.getDate());
        }

        if(holder.avgtempTV != null) {
            holder.avgtempTV.setText(dayRVModel.getAvgtemp());
        }

        if(holder.maxwindTV != null) {
            holder.maxwindTV.setText(dayRVModel.getMaxwind());
        }

        if(holder.conditionTextTV != null) {
            holder.conditionTextTV.setText(dayRVModel.getText());
        }

    }

    @Override
    public int getItemCount() {
        return dayRVModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView dayTV, avgtempTV, maxwindTV, conditionTextTV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dayTV  = itemView.findViewById(R.id.idUpComingDayTV);
            avgtempTV = itemView.findViewById(R.id.idTVavgtemp);
            maxwindTV = itemView.findViewById(R.id.idTVmaxwind); // Update to use the correct id
            conditionTextTV = itemView.findViewById(R.id.idTVConditionText); // Update to use the correct id
        }
    }
}
