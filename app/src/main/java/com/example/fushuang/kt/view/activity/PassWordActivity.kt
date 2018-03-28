package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.example.fushuang.kt.global.BaseSize
import com.example.fushuang.kt.util.ToastUtil
import com.example.fushuang.kt.view.view.PasswordStrengthView
import com.example.fushuang.kt.view.view.passwordStrengthView

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class PassWordActivity : AppCompatActivity() {

  object ViewID {
    val PASSWORDID = 1001
    val SUBMITID = 1002
    val STRENGTHVIEW = 1003
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

      passwordStrengthView {
        id = ViewID.STRENGTHVIEW

      }.lparams(height = 100, width = matchParent)

    }.let { setContentView(it) }
  }

  private fun checkPassword(password: String) {

    var result = 60
    var passwordArray = password.toCharArray()
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
      -> result = 100

      Regex("[0-9]").containsMatchIn(password)
              && Regex("[a-z]").containsMatchIn(password)
              && Regex("[A-Z]").containsMatchIn(password)
      -> result = 80

    }
    var repeatCount = 0
    /**
     * 递增连续字符减分
     */
    for (i in 0..passwordArray.size - 2)
      if (passwordArray[i] - passwordArray[i + 1] == -1)
        repeatCount++
    if (repeatCount >= 3) {
      result -= 20
    }
    /**
     * 连续相同字符减分
     */
    repeatCount = 0
    for (i in 0..passwordArray.size - 2)
      if (passwordArray[i] - passwordArray[i + 1] == 0)
        repeatCount++
    if (repeatCount >= 3) {
      result -= 20
    }
    /**
     * 包含疑似生日减分减分
     */
    if (Regex("19[0-9]{6}").containsMatchIn(password)) {
      result -= 10
    }
    /**
     * 首字母大写加分加分
     */
    if (Regex("[A-Z].*").matches(password)) {
      result += 10
    }

    when (result) {
      in 90..200->ToastUtil.toast("强")
      in 60..80->ToastUtil.toast("中")
      in 0..60->ToastUtil.toast("弱")
    }


  }


}
