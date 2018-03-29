package com.example.bojansolution.culinar.customer

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bojansolution.culinar.R
import kotlinx.android.synthetic.main.customer.*
import kotlinx.android.synthetic.main.customer_grid_view_item.view.*

/**
 * Created by bojan solution on 27/03/2018.
 */

class CustomerController : AppCompatActivity() {

    var adapter: GridAdapter? = null
    var gridList = ArrayList<Grid>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer)

        gridList.add(Grid("A1", R.drawable.cute_twitter6))
        gridList.add(Grid("A2", R.drawable.cute_twitter6))
        gridList.add(Grid("B1", R.drawable.cute_twitter6))
        gridList.add(Grid("B2", R.drawable.cute_twitter6))
        gridList.add(Grid("C1", R.drawable.cute_twitter6))
        gridList.add(Grid("C2", R.drawable.cute_twitter6))
        adapter = GridAdapter(this, gridList)

        customerGridView.adapter = adapter
    }

    class GridAdapter : BaseAdapter {
        var context: Context? = null
        var gridList = ArrayList<Grid>()

        constructor(context: Context, gridList: ArrayList<Grid>) {
            this.context = context
            this.gridList = gridList
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val grid = gridList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var gridView = inflator.inflate(R.layout.customer_grid_view_item, null)

            gridView.customerTextViewItem.text = grid.name
            gridView.customerImageViewItem.setImageResource(grid.image!!)

            return gridView
        }

        override fun getItem(position: Int): Any {
            return gridList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return gridList.size
        }
    }
}