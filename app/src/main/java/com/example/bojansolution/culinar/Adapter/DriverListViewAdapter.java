package com.example.bojansolution.culinar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bojansolution.culinar.R;
import com.example.bojansolution.culinar.model.DriverPopulation;

import java.sql.Driver;
import java.util.List;

/**
 * Created by bojan solution on 14/02/2018.
 */

public class DriverListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<DriverPopulation> drivers;

    public DriverListViewAdapter(Context context, List<DriverPopulation> drivers) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.drivers = drivers;
    }

    public class ViewHolder {
        DriverPopulation driver;
        TextView textDriverName;
    }

    @Override
    public int getCount() {
        return drivers.size();
    }

    @Override
    public DriverPopulation getItem(int position) {
        return drivers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.driver_list, null);
        ViewHolder holder = new ViewHolder();
        holder.driver = drivers.get(position);
        holder.textDriverName = (TextView) convertView.findViewById(R.id.labelDriverName);
        convertView.setTag(holder);
        holder.textDriverName.setText(holder.driver.getDriverName());

        final String driverName = drivers.get(position).getDriverName();

        return convertView;
    }
}
