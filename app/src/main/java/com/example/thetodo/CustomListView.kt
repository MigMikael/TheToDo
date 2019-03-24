package com.example.thetodo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListView(context: Context, list: ArrayList<String>) : BaseAdapter() {

    private var list: ArrayList<String> = ArrayList()
    private var context: Context

    init {
        this.list = list
        this.context = context
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var v: View

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = inflater.inflate(R.layout.custom_list_view, null)

        val name = v.findViewById<TextView>(R.id.textView)
        name.text = list[position]

        val delete = v.findViewById<ImageView>(R.id.icon_delete)
        delete.setOnClickListener ({
            list.removeAt(position)
            this.notifyDataSetChanged()
        })

        return v
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}