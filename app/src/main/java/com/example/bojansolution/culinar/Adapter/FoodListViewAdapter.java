package com.example.bojansolution.culinar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bojansolution.culinar.R;
import com.example.bojansolution.culinar.model.FoodPopulation;

import java.util.List;

/**
 * Created by bojan solution on 23/12/2017.
 */

public class FoodListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<FoodPopulation> foods;

    public FoodListViewAdapter(Context context, List<FoodPopulation> foodPopulations) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.foods = foodPopulations;
    }

    public class ViewHolder {
        FoodPopulation food;
        TextView textFoodName;
        EditText textQty;
        Button buttonAdd;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public FoodPopulation getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.food_list, null);
        ViewHolder holder = new ViewHolder();
        holder.food = foods.get(position);
        holder.textFoodName = (TextView) convertView.findViewById(R.id.foodName);
        holder.textQty = (EditText) convertView.findViewById(R.id.qty);
        holder.buttonAdd = (Button) convertView.findViewById(R.id.addButton);
        holder.buttonAdd.setTag(holder.food);

        convertView.setTag(holder);

        final String foodName = foods.get(position).getFoodName();
        String prefix = holder.textFoodName.getText().toString();

        holder.textFoodName.setText(prefix + foodName);
//        holder.textQty.setText(0);

        return convertView;
    }
}
