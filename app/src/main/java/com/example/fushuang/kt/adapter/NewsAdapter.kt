package com.example.fushuang.kt.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fushuang.kt.R

import com.example.fushuang.kt.module.Cat
import org.jetbrains.anko.*

import java.util.Calendar

/**
 * Created by fushuang on 2018/3/22.
 */

class NewsAdapter(var list: List<Cat>, var context: Context) : RecyclerView.Adapter<NewsAdapter.BaseViewHolder>() {



    private val ankoContext = AnkoContext.createReusable(context, this)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder? {

        return if (viewType == 1) {
            var itemView = MovieListHeadUI().createView(ankoContext)
            NewsHeadViewHolder(itemView)
        } else {
            NewsViewHolder(MovieListAdapterUI().createView(ankoContext))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

         if (holder is NewsViewHolder){
             var imageView = holder.itemView.findViewById<ImageView>(3)
             imageView.setBackgroundResource(R.mipmap.ic_launcher)
             var text = holder.itemView.findViewById<TextView>(4)
             var cat = list.get(position)
             text.text = "age ${cat.age}"
         }else{


         }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position==0){
            return  1
        }else{
            return 2
        }
    }

    class NewsViewHolder(itemView: View) : BaseViewHolder(itemView){
        //为什么拿不到itemView
//        itemView
    }

    class NewsHeadViewHolder(itemView: View) : BaseViewHolder(itemView)

    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
class MovieListAdapterUI : AnkoComponent<NewsAdapter> {
    override fun createView(ui: AnkoContext<NewsAdapter>) = with(ui) {
        linearLayout {

            padding = dip(10)//设置padding
            lparams(width = matchParent ,height = wrapContent)
            backgroundColor =Color.GRAY
            gravity =Gravity.CENTER

            imageView {
                id = 3//设置id
                scaleType = ImageView.ScaleType.CENTER_CROP//图片中心裁剪
            }.lparams(width = dip(60), height = dip(60))//设置图片的宽高
            textView {
                id = 4//设置id
                textSize = 14f//字体大小
                paint.isFakeBoldText = true//粗体
            }.lparams {
                leftMargin = dip(10)//左边偏移量
                gravity = Gravity.CENTER_VERTICAL//竖直居中
            }
        }
    }
}


class MovieListHeadUI : AnkoComponent<NewsAdapter> {
    override fun createView(ui: AnkoContext<NewsAdapter>) = with(ui) {
        linearLayout {

            padding = dip(10)//设置padding
            textView {
                id = 5//设置id
                text="标题"
                textSize = 24f  //字体大小
                paint.isFakeBoldText = true//粗体
            }.lparams {
                leftMargin = dip(10)//左边偏移量
                gravity = Gravity.CENTER//竖直居中
            }
        }
    }
}