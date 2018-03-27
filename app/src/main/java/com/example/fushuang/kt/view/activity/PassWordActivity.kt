package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.example.fushuang.kt.global.BaseSize
import com.example.fushuang.kt.util.ToastUtil

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class PassWordActivity : AppCompatActivity() {

  object ViewID {
    val PASSWORDID = 1001
    val SUBMITID = 1002
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    verticalLayout {

      var password = editText {
        id = ViewID.PASSWORDID
        gravity = Gravity.CENTER_HORIZONTAL
        singleLine = true
        width = matchParent
        height = BaseSize.passwordEditTextHeight
        hint = "请输入密码"
      }

      button {
        id = ViewID.SUBMITID
        text = "校验"
        onClick {
          var password = password.text.toString()
          checkPassword(password)

        }
      }

    }.let { setContentView(it) }
  }

  private fun checkPassword(password: String) {

    when {
      password.contains(" ")
      -> ToastUtil.toast("含有不合理字符")

      password.length < 6
      -> ToastUtil.toast("密码长度必须大于5位")

      Regex("[0-9]+").matches(password)
      -> ToastUtil.toast("不能为纯数字")

      Regex("[a-z]+", RegexOption.IGNORE_CASE).matches(password)
      -> ToastUtil.toast("不能为纯字母")

      Regex("[!@#$%¥^&*()_=+?]").containsMatchIn(password)
              && Regex("[a-z]").containsMatchIn(password)
              && Regex("[A-Z]").containsMatchIn(password)
      -> ToastUtil.toast("强")

      Regex("[0-9]").containsMatchIn(password)
              && Regex("[a-z]").containsMatchIn(password)
              && Regex("[A-Z]").containsMatchIn(password)
      -> ToastUtil.toast("中")

      else ->ToastUtil.toast("弱")

    }

  }

}
