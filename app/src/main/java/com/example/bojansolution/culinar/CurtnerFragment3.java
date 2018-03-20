package com.example.bojansolution.culinar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bojansolution.culinar.Adapter.DriverListViewAdapter;
import com.example.bojansolution.culinar.model.DriverPopulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 28/01/2018.
 */

public class CurtnerFragment3 extends Fragment {

    DriverListViewAdapter adapter;
    ListView listView;
    List<DriverPopulation> drivers;
    String[] driverNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_curtner_3, container, false);

        // set data
        listView = (ListView) view.findViewById(R.id.listDriver);
        driverNames = new String[] {"januar", "muhtadiin", "ojan"};
        drivers = new ArrayList<>();
        for(int i=0;i<driverNames.length;i++) {
            DriverPopulation driver = new DriverPopulation(i,driverNames[i]);
            drivers.add(driver);
        }
        adapter = new DriverListViewAdapter(getActivity(), drivers);
        listView.setAdapter(adapter);

        return view;
    }
}
