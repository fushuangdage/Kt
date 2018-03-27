package com.example.fushuang.kt.global

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import com.example.fushuang.kt.KtApplication

/**
 * @date 2018-03-27 上午10:29:43
 * @author fushuang
 * @description 记录全局Size Color
 */


object UIColor {
  val mainColor = Color.argb(255,80,80,80)
  val Purple = Color.argb(255,118,47,142)
}

object BaseSize {

  val passwordEditTextHeight = autoConvertUIPx(50)
  val headerHeight = autoConvertUIPx(64)

  private fun autoConvertUIPx(dpVal: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            dpVal.toFloat(), KtApplication.context.resources.displayMetrics).toInt()
  }


}
