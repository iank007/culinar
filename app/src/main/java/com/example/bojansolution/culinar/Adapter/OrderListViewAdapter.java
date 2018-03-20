package com.example.bojansolution.culinar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bojansolution.culinar.R;
import com.example.bojansolution.culinar.model.OrderPopulation;

import java.util.List;

/**
 * Created by bojan solution on 02/02/2018.
 */

public class OrderListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<OrderPopulation> orders;

    public OrderListViewAdapter(Context context, List<OrderPopulation> orders) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.orders = orders;
    }

    public class ViewHolder {
        OrderPopulation order;
        TextView textString;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public OrderPopulation getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.order_list, null);
        ViewHolder holder = new ViewHolder();
        holder.order = orders.get(position);
        holder.textString = (TextView) convertView.findViewById(R.id.labelOrderString);

        convertView.setTag(holder);
        holder.textString.setText(holder.order.getOrderString());

        final int orderId = holder.order.getOrderId();
        final String orderString = holder.order.getOrderString();
        final String orderStatus = holder.order.getOrderStatus();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, null);
                intent.putExtra("orderId", orderId);
                intent.putExtra("orderString", orderString);
                intent.putExtra("orderStatus", orderStatus);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
