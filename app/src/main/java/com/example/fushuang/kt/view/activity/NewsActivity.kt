package com.example.fushuang.kt.view.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.example.fushuang.kt.R
import com.example.fushuang.kt.view.fragment.NewsDetailFragment
import com.example.fushuang.kt.view.fragment.NewsListFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class NewsActivity : AppCompatActivity() {

    private val listFragment: NewsListFragment = NewsListFragment()

    private val detailFragment: NewsDetailFragment= NewsDetailFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {

            verticalLayout{
                id=1
                lparams {
                    width = matchParent
                    height = 0
                    weight=1f
                }

            }

            button{
                text="list"
                onClick {
                    var fragmentTransaction = supportFragmentManager.beginTransaction();
                    fragmentTransaction.replace(1,listFragment)
                    fragmentTransaction.commit()
                }
            }


            button{
                text="detail"
                onClick {
                    var fragmentTransaction = supportFragmentManager.beginTransaction();
                    fragmentTransaction.replace(1,detailFragment)
                    fragmentTransaction.commit()
                }
            }


        }.let { setContentView(it) }

        var fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(1, listFragment)
        fragmentTransaction.add(1, detailFragment)


        fragmentTransaction.show(listFragment)
        fragmentTransaction.commit()

    }
}
