package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.style.LineHeightSpan
import android.view.Gravity
import android.widget.TextView
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

  inner class CheckPasswordResult(var code: Int, var message: String, var grade: Int)


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
          var result = checkPassword(password)
          if (Code.UNSAFE == result.code) {
            toast(result.message)
          } else {
            toast(result.code.toString())
          }
        }
      }

      passwordStrengthView {
        id = ViewID.STRENGTHVIEW

      }.lparams(height = 100, width = matchParent)

    }.let { setContentView(it) }
  }

  object Code {
    val UNSAFE = 0
    val LOW = 1
    val MIDDLE = 2
    val HIGH = 3
  }


  private fun checkPassword(password: String): CheckPasswordResult {
    var checkPasswordResult = CheckPasswordResult(Code.UNSAFE, "", 0)
    var passwordArray = password.toCharArray()
    when {
      password.contains(" ")
      -> checkPasswordResult.message = "含有不合理字符"

      password.length < 6
      -> checkPasswordResult.message = "密码长度必须大于5位"

      Regex("[0-9]+").matches(password)
      -> checkPasswordResult.message = "不能为纯数字"

      Regex("[a-z]+", RegexOption.IGNORE_CASE).matches(password)
      -> checkPasswordResult.message = "不能为纯字母"

      Regex("[!@#$%¥^&*()_=+?]").containsMatchIn(password)
        && Regex("[a-z]").containsMatchIn(password)
        && Regex("[A-Z]").containsMatchIn(password)
      -> {
        checkPasswordResult.grade = 100
        checkPasswordResult.code = Code.HIGH
      }

      Regex("[a-z]").containsMatchIn(password)
        && Regex("[A-Z]").containsMatchIn(password)
      -> {
        checkPasswordResult.grade = 80
        checkPasswordResult.code = Code.MIDDLE
      }
    }
    var repeatCount = 0
    /**
     * 递增连续字符减分
     */
    for (i in 1 until passwordArray.size) {
      if (passwordArray[i] - passwordArray[i - 1] == 1) {
        repeatCount++
        if (repeatCount >= 2) {
          checkPasswordResult.grade -= 20
          toast("有连续")
          break
        }
      } else
        repeatCount = 0
    }
    /**
     * 连续相同字符减分
     */
    repeatCount = 0
    for (i in 1 until passwordArray.size) {
      if (passwordArray[i] - passwordArray[i - 1] == 0) {
        repeatCount++
        if (repeatCount >= 2) {
          checkPasswordResult.grade -= 20
          toast("有连续")
          break
        }
      } else
        repeatCount = 0
    }

    /**
     * 包含疑似生日减分减分
     */
    if (Regex("19[0-9]{6}").containsMatchIn(password)) {
      checkPasswordResult.grade -= 10
    }
    /**
     * 首字母大写加分加分
     */
    if (Regex("[A-Z].*").matches(password)) {
      checkPasswordResult.grade += 10
    }

    when (checkPasswordResult.grade) {
      in 90..200 -> checkPasswordResult.code = Code.HIGH
      in 60..80 -> checkPasswordResult.code = Code.MIDDLE
      in 0..60 -> checkPasswordResult.code = Code.LOW
    }

    return checkPasswordResult
  }


}
