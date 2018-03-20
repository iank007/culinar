package com.example.bojansolution.culinar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bojansolution.culinar.Adapter.PackageListViewAdapter;
import com.example.bojansolution.culinar.model.PackagePopulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 28/01/2018.
 */

public class CurtnerFragment2 extends Fragment {

    PackageListViewAdapter adapter;
    ListView listView;
    List<PackagePopulation> packages;
    String[] packageNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_curtner_2, containter, false);

        // set data
        listView = (ListView) view.findViewById(R.id.listPackage);
        packageNames = new String[] { "PACK 1", "PACK 2", "PACK 3", "PACK 4" };
        packages = new ArrayList<>();
        for(int i=0;i<packageNames.length;i++) {
            PackagePopulation packageData = new PackagePopulation(i, packageNames[i]);
            packages.add(packageData);
        }
        adapter = new PackageListViewAdapter(getActivity(), packages);
        listView.setAdapter(adapter);

        return view;
    }
}
