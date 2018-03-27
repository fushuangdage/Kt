package com.example.fushuang.kt.util

import android.app.Application
import com.example.fushuang.kt.KtApplication
import org.jetbrains.anko.toast

/**
 * @date 2018-03-26 下午7:07:45
 * @author fushuang
 * @description
 */

object ToastUtil{
  fun toast(string: String){
    KtApplication.context.toast(string)
  }
}