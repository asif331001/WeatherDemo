package com.example.weatherdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherRVAdapter extends RecyclerView.Adapter<WeatherRVAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeatherRVModel> weatherRVModelArrayList;

    public WeatherRVAdapter(Context context, ArrayList<WeatherRVModel> weatherRVModelArrayList) {
        this.context = context;
        this.weatherRVModelArrayList = weatherRVModelArrayList;
    }

    @NonNull
    @Override
    public WeatherRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter.ViewHolder holder, int position) {
        if (weatherRVModelArrayList == null || weatherRVModelArrayList.isEmpty()) {
            return;
        }
        WeatherRVModel modal = weatherRVModelArrayList.get(position);
        holder.temperatureCardTV.setText(modal.getTemperature() + "°c");
        holder.conditionTV.setText(modal.getText() + " Km/h");
        holder.windTV.setText(modal.getWindSpeed());
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");

        try {
            Date t = input.parse(modal.getTime());
            holder.timeTV.setText(output.format(t));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView windTV, temperatureCardTV, timeTV, conditionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            conditionTV  = itemView.findViewById(R.id.idTVWindSpeed);
            temperatureCardTV = itemView.findViewById(R.id.idTVCardTemperature);
            windTV = itemView.findViewById(R.id.idIVCondition); // Update to use the correct id
            timeTV = itemView.findViewById(R.id.idTVTime); // Update to use the correct id
        }
    }
}