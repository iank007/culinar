package com.example.bojansolution.culinar.repository;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bojansolution.culinar.Adapter.StoreListViewAdapter;
import com.example.bojansolution.culinar.model.Curtner;
import com.example.bojansolution.culinar.model.StorePopulation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 11/11/2017.
 */

public class CurtnerRepository {

    private DatabaseReference reference;
    private List<Curtner> curtners;
    StoreListViewAdapter adapter;

    public CurtnerRepository() {
        reference = FirebaseDatabase.getInstance().getReference();
        curtners = new ArrayList<>();
    }

    public List<Curtner> selectAll(StoreListViewAdapter adapter) {
        this.adapter = adapter;
        selectAll2();
        return curtners;
    }

    private void selectAll2() {
        reference.child("curtners").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Curtner curtner = ds.getValue(Curtner.class);
                    curtners.add(curtner);
                    StorePopulation sp = new StorePopulation(curtner.getCurtnerCode(), curtner.getCurtnerName(), curtner.getCurtnerCode());
                    adapter.addChild(sp);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("tCurtner", "getCurtner:onCanceled", databaseError.toException());
            }
        });
    }
}
