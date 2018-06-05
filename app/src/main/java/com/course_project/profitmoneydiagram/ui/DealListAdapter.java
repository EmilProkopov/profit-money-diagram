package com.course_project.profitmoneydiagram.ui;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.course_project.profitmoneydiagram.R;
import com.course_project.profitmoneydiagram.model.DealListData;
import com.course_project.profitmoneydiagram.network.lab.Orders;

import java.util.ArrayList;
import java.util.List;

//Adapter for RecyclerView.
public class DealListAdapter extends RecyclerView.Adapter <DealListAdapter.DealViewHolder> {

    private DealListData data;

    public DealListAdapter(DealListData dldata) {

        this.data = dldata;
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new DealViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {

        String text = data.getTypes().get(position)+" "+data.getAmounts().get(position)
                +" at "+data.getNames().get(position)
                +"\nfor price of "+data.getPrices().get(position);

        holder.weatherTextView.setText(text);
    }

    @Override
    public int getItemCount() {

        return data.getPrices().size();
    }

    public static class DealViewHolder extends RecyclerView.ViewHolder {

        public TextView weatherTextView;

        public DealViewHolder(View itemView) {
            super(itemView);
            weatherTextView = (TextView) itemView;
        }
    }

}
