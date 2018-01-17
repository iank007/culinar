package com.example.bojansolution.culinar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bojansolution.culinar.model.StorePopulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by bojan solution on 17/12/2017.
 */

public class StoreListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<StorePopulation> storePopulations;
    private ArrayList<StorePopulation> storePopulationArrayList;

    public StoreListViewAdapter(Context context, List<StorePopulation> storePopulations) {
        this.context = context;
        this.storePopulations = storePopulations;
        inflater = LayoutInflater.from(context);
        this.storePopulationArrayList = new ArrayList<>();
        this.storePopulationArrayList.addAll(storePopulations);
    }

    public class ViewHolder {
        TextView textStoreId;
        TextView textStoreName;
        TextView textStoreStatus;
    }

    @Override
    public int getCount() {
        return storePopulations.size();
    }

    @Override
    public StorePopulation getItem(int position) {
        return storePopulations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(null == convertView) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.store_list, null);
            holder.textStoreId = (TextView) convertView.findViewById(R.id.storeId);
            holder.textStoreName = (TextView) convertView.findViewById(R.id.storeName);
            holder.textStoreStatus = (TextView) convertView.findViewById(R.id.storeStatus);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final String storeId = storePopulations.get(position).getStoreId();
        final String storeName = storePopulations.get(position).getStoreName();
        final String storeStatus = storePopulations.get(position).getOpenClosedStatus();

        holder.textStoreId.setText(storeId);
        holder.textStoreName.setText(storeName);
        holder.textStoreStatus.setText(storeStatus);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleItemView.class);
                intent.putExtra("storeId", storeId);
                intent.putExtra("storeName", storeName);
                intent.putExtra("storeStatus", storeStatus);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        storePopulations.clear();
        if(0 == charText.length()) {
            storePopulations.addAll(storePopulationArrayList);
        } else {
            for(StorePopulation sp : storePopulationArrayList) {
                if(sp.getStoreName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    storePopulations.add(sp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
