package com.example.fushuang.kt.presenter

import android.support.v7.widget.RecyclerView
import com.example.fushuang.kt.view.view.IView
import com.example.fushuang.kt.module.Cat

import kotlin.collections.ArrayList

/**
 * Created by fushuang on 2018/3/21.
 */

class MyPresenter() {


  fun getData(recyclerView: RecyclerView, data: ArrayList<Cat>) {
    data.clear()
    for (i in 1..10) {
      data.add(Cat(1, i))
    }
    recyclerView.adapter.notifyDataSetChanged()

  }
}
