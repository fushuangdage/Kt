package com.example.fushuang.kt.view.fragment


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.fushuang.kt.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI


/**
 * A simple [Fragment] subclass.
 */
class NewsDetailFragment : Fragment() {


  lateinit var rootView: View


  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    rootView = UI {

      scrollView {
        verticalLayout {

          lparams(width = matchParent, height = matchParent)//设置布局的宽高

          imageView {
            backgroundResource = R.mipmap.ic_launcher
          }.lparams(width = matchParent, height = dip(100))

          textView {
            backgroundColor = Color.GRAY
            text = "22222222222222222222"
            textSize = sp(24).toFloat()
          }.lparams(width = matchParent, height = dip(2000))
        }
      }

    }.view
    return rootView
  }

}// Required empty public constructor
