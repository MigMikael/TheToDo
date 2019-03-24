package com.example.thetodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

typealias Arraylist<E> = java.util.ArrayList<E>

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var text_input: String
    private val list: Arraylist<String> = ArrayList()
    private lateinit var adapter: CustomListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CustomListView(this, list)
        list_item.adapter = adapter
        list_item.onItemClickListener = this
        setEvents()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        Toast.makeText(applicationContext, list[position], Toast.LENGTH_LONG).show()
    }

    private fun setEvents() {
        button.setOnClickListener {
            text_input = editText.text.toString()
            Toast.makeText(applicationContext, "Added $text_input", Toast.LENGTH_LONG).show()

            adapter.notifyDataSetChanged()
            list.add(text_input)
            editText.text.clear()
        }

        textClear.setOnClickListener {
            list.clear()
            adapter.notifyDataSetChanged()
        }
    }
}

