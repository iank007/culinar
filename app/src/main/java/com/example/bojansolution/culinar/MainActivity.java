package com.example.bojansolution.culinar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // screen items declaration
    private EditText fieldSearch;
    private Button buttonSearch;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldSearch = (EditText) findViewById(R.id.fieldSearchId);
        buttonSearch =  (Button) findViewById(R.id.buttonSearchId);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), CurtnerActivity.class);
                String str = fieldSearch.getText().toString();
                intent.putExtra("fieldSearchExtra", str);
                startActivity(intent);
            }
        });
    }
}
