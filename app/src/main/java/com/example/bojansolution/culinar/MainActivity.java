package com.example.bojansolution.culinar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.bojansolution.culinar.model.StorePopulation;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    StoreListViewAdapter adapter;
    String[] storeIds;
    String[] storeNames;
    String[] storeStatus;
    ArrayList<StorePopulation> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storeIds = new String[] {"CRT_0001", "CRT_0002", "CRT_0003"
                , "CRT_0004", "CRT_0005", "CRT_0006"
                , "CRT_0007", "CRT_0008", "CRT_0009", "CRT_0010" };
        storeNames = new String[] {"Janu 1", "Janu 2", "Janu 3"
                , "Janu 4", "Janu 5", "Janu 6"
                , "Janu 7", "Janu 8", "Janu 9", "Janu 10" };
        storeStatus = new String[] {"open", "open", "closed", "open", "open"
                , "closed", "open", "closed", "open", "closed"};

        listView = (ListView) findViewById(R.id.listSearchStoreResult);
        for(int i=0;i<10;i++) {
            StorePopulation sp = new StorePopulation(storeIds[i], storeNames[i], storeStatus[i]);
            arrayList.add(sp);
        }
        adapter = new StoreListViewAdapter(this,arrayList);
        listView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.textSearchStore);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }

    public void curtner(View view) {
        Intent intent = new Intent(this, CurtnerMain.class);
        startActivity(intent);
    }
}