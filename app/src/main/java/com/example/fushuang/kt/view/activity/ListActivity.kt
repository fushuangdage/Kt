package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fushuang.kt.adapter.CustomAdapter
import com.example.fushuang.kt.module.Cat
import com.example.fushuang.kt.presenter.MyPresenter
import com.example.fushuang.kt.view.view.IView

import org.jetbrains.anko.*
import java.util.ArrayList

class  ListActivity : AppCompatActivity() ,IView{



    lateinit var presenter : MyPresenter

    val items = arrayListOf<Cat>()

    var customAdapter = CustomAdapter(items)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         presenter = MyPresenter()

//        presenter.attachView(this)

        verticalLayout {
            val listView = listView {  }

            listView.adapter = customAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val cat = parent.getItemAtPosition(position) as Cat
                toast("age"+cat.age)
            }
        }.let {
            setContentView(it)
        }

//        presenter.getData()
    }


    override fun showData(list: ArrayList<Cat>?) {
        items.addAll(list!!)
        customAdapter.notifyDataSetChanged()
    }

}

