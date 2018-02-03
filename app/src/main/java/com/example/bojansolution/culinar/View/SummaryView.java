package com.example.bojansolution.culinar.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bojansolution.culinar.R;

/**
 * Created by bojan solution on 31/12/2017.
 */

public class SummaryView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.food_summary);

        Intent intent = getIntent();
        String storeId = intent.getStringExtra("storeId");
        String total = intent.getStringExtra("total");

        TextView textStoreId = (TextView) findViewById(R.id.storeId);
        TextView textTotal = (TextView) findViewById(R.id.total);

        textStoreId.setText(storeId);
        textTotal.setText(total);
    }
}
