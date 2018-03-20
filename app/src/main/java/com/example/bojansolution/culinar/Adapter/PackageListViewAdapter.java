package com.example.bojansolution.culinar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bojansolution.culinar.R;
import com.example.bojansolution.culinar.model.PackagePopulation;

import java.util.List;

/**
 * Created by bojan solution on 04/02/2018.
 */

public class PackageListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<PackagePopulation> packages;

    public PackageListViewAdapter(Context context, List<PackagePopulation> packages) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.packages = packages;
    }

    public class ViewHolder {
        PackagePopulation packageData;
        TextView packageName;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public PackagePopulation getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.package_list, null);
        ViewHolder holder = new ViewHolder();
        holder.packageData = packages.get(position);
        holder.packageName = (TextView) convertView.findViewById(R.id.labelPackageName);
        convertView.setTag(holder);
        holder.packageName.setText(holder.packageData.getPackageName());

        final int packageId = holder.packageData.getPackageId();
        final String packageName = holder.packageData.getPackageName();

        return convertView;
    }
}
