package com.example.bojansolution.culinar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bojansolution.culinar.Adapter.OrderListViewAdapter;
import com.example.bojansolution.culinar.model.OrderPopulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 28/01/2018.
 */

public class CurtnerFragment1 extends Fragment {

    OrderListViewAdapter adapter;
    ListView listView;
    List<OrderPopulation> orders;
    String[] orderStrings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_curtner_1, containter, false);

        // set data
        listView = (ListView) view.findViewById(R.id.listOrder);
        orderStrings = new String[] { "Packet 1", "Januar ", "ayam bakar 4", "jus mangga" };
        orders = new ArrayList<>();
        for(int i=0;i<orderStrings.length;i++) {
            OrderPopulation order = new OrderPopulation(i, orderStrings[i]);
            orders.add(order);
        }
        adapter = new OrderListViewAdapter(getActivity(), orders);
        listView.setAdapter(adapter);

        return view;
    }
}
