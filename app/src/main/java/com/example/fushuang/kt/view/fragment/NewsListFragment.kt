package com.example.fushuang.kt.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.example.fushuang.kt.adapter.NewsAdapter
import com.example.fushuang.kt.module.Cat
import com.example.fushuang.kt.presenter.MyPresenter
import com.example.fushuang.kt.view.view.IView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI


/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var rootView :View
    lateinit var newsAdapter:NewsAdapter
    lateinit var data:List<Cat>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        data=ArrayList()

        var myPresenter = MyPresenter()

        rootView=UI {
            verticalLayout {
                lparams(width= matchParent,height = matchParent)//设置布局的宽高

                recyclerView{//设置滚动视图RecyclerView
                    id = 2//控件的id
                }.lparams(width = matchParent, height = matchParent)//控件的宽高
            }
        }.view

        recyclerView = rootView.findViewById<RecyclerView>(2)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        newsAdapter = NewsAdapter(data, activity)
        recyclerView.adapter= newsAdapter

        myPresenter.getData(recyclerView, data as ArrayList<Cat>)


        return rootView
    }



}// Required empty public constructor

