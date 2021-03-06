package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.fushuang.kt.R
import com.example.fushuang.kt.view.view.myRichView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    linearLayout {

    }
    MainActivityUi().setContentView(this)
  }


}

class MainActivityUi : AnkoComponent<MainActivity> {
  private val customStyle = { v: Any ->
    when (v) {
      is Button -> v.textSize = 26f
      is EditText -> v.textSize = 24f
    }
  }

  override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
    verticalLayout {
      padding = dip(32)

      imageView(android.R.drawable.ic_menu_manage).lparams {
        margin = dip(16)
        gravity = Gravity.CENTER
      }

      val name = editText {
        hintResource = R.string.name
      }
      val password = editText {
        hintResource = R.string.password
        inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
      }

      button("Log in") {
        onClick {
          startActivity<NewsActivity>()

        }
      }

      myRichView()
    }.applyRecursively(customStyle)
  }
}
