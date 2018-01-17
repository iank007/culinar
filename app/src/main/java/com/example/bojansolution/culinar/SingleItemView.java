package com.example.bojansolution.culinar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bojansolution.culinar.model.FoodPopulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 19/12/2017.
 */

public class SingleItemView extends Activity {
    TextView textStoreId;
    TextView textSummary;
    String storeId;

    FoodListViewAdapter adapter;
    ListView listView;
    List<FoodPopulation> foods;
    String[] foodNames;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);

        // set data
        foodNames = new String[] {"Food 1", "Food 2", "Food 3"
                , "Food 4", "Food 5", "Food 6"
                , "Food 7", "Food 8", "Food 9", "Food 10" };
        listView = (ListView) findViewById(R.id.listStoreFoods);
        foods = new ArrayList<>();
        for(int i=0;i<10;i++) {
            FoodPopulation food = new FoodPopulation("Janu 1", "FP" + i, foodNames[i], 1000, 3);
            foods.add(food);
        }
        adapter = new FoodListViewAdapter(this, foods);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        storeId = intent.getStringExtra("storeId");
        String storeName = intent.getStringExtra("storeName");
        textStoreId = (TextView) findViewById(R.id.storeId);
        textStoreId.setText("[" + storeId + "] " + storeName);
    }

    public void add(View view) {
        FoodPopulation food = (FoodPopulation)view.getTag();
//        EditText qty = (EditText)view.getTag(R.id.qty);
        textSummary = (TextView) findViewById(R.id.totalPriceId);
        long sum = Long.parseLong(textSummary.getText().toString()) + food.getFoodPrice();
        textSummary.setText(String.valueOf(sum));
    }

    public void order(View view) {
        Intent intent = new Intent(this, SummaryView.class);
        String storeId = textStoreId.getText().toString();
        String total = textSummary.getText().toString();
        intent.putExtra("storeId", storeId);
        intent.putExtra("total", total);
        startActivity(intent);
    }
}
