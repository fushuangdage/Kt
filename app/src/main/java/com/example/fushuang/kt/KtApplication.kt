package com.example.fushuang.kt

import android.app.Application
import android.content.Context

/**
 * @author fushuang
 * @date 2018-03-27 上午10:40:07
 * @description
 */
class KtApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    context = applicationContext
  }

  companion object {
    lateinit var context: Context
  }
}
