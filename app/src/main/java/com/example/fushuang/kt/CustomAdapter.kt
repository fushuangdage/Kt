package com.example.fushuang.kt

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.jetbrains.anko.*

/**
 * Created by fushuang on 2018/3/21.
 */

class CustomAdapter(private val list : List<Cat>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val cat = getItem(position)

        return with(parent!!.context){
            relativeLayout {
                val imageView = imageView {
                    id = 1
                }.lparams {
                    alignParentTop()
                    alignParentLeft()
                    width = 200
                    height = 200
                }
                val textView1 = textView {
                    id = 2
                }.lparams {
                    alignParentTop()
                    alignParentRight()
                    width = parent.width - 200
                    topMargin = 20
                    leftMargin = 20
                }
                val textView2 = textView {
                    id = 3
                }.lparams {
                    below(2)
                    alignParentRight()
                    width = parent.width - 200
                    topMargin = 20
                    leftMargin = 20
                }

                textView1.text ="${cat.age}"

            }
        }
    }

    override fun getItem(position: Int): Cat {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getCount(): Int {
        return list.size
    }

}
