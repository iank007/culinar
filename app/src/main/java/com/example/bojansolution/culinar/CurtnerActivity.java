package com.example.bojansolution.culinar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CurtnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curtner);

        String str = getIntent().getStringExtra("fieldSearchExtra");
        TextView fieldSearch = (TextView)findViewById(R.id.textSearchId);

        fieldSearch.setText(str);
    }
}
