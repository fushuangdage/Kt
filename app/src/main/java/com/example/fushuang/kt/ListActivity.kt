package com.example.fushuang.kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import org.jetbrains.anko.*
import java.util.ArrayList

class ListActivity : AppCompatActivity() ,IView {



    lateinit var presenter :MyPresenter

    val items = arrayListOf<Cat>()

    var customAdapter = CustomAdapter(items)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         presenter=MyPresenter()

        presenter.attachView(this)

        verticalLayout {
            val listView = listView {  }

            listView.adapter = customAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val cat = parent.getItemAtPosition(position) as Cat
                toast("age"+cat.age)
            }
        }

        presenter.getData()
    }


    override fun showData(list: ArrayList<Cat>?) {
        for (item in items) {
            items.add(item)
        }
        customAdapter.notifyDataSetChanged()
    }

}

