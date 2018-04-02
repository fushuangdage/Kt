package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView

import com.example.fushuang.kt.global.BaseSize
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*
import cn.qqtheme.framework.picker.OptionPicker
import com.example.fushuang.kt.presenter.MoneyPresenter


class MoneyActivity : AppCompatActivity() {


  object ViewID {
    val INCOUNTRTY = 1001
    val OUTCOUNTRY = 1002
    val STRENGTHVIEW = 1003
  }

  val countryList: ArrayList<String> = ArrayList()
  lateinit var resultShow:TextView
  val moneyPresenter:MoneyPresenter= MoneyPresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    init()

    verticalLayout {
      var inCountry = editText {
        id = ViewID.INCOUNTRTY
        gravity = Gravity.CENTER_HORIZONTAL
        singleLine = true
        width = matchParent
        height = BaseSize.passwordEditTextHeight
      }

      inCountry.onClick {
        val picker = OptionPicker(this@MoneyActivity, countryList) //list为选择器中的选项
        picker.setOffset(2)
        picker.setSelectedIndex(1) //默认选中项
        picker.setTextSize(18)
        picker.setCycleDisable(true) //选项不循环滚动
        picker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
          override fun onOptionPicked(position: Int, option: String) {
            inCountry.setText(option) //在文本框中显示选择的选项
          }
        })
        picker.show()
      }

      var outCountry = editText {
        id = ViewID.OUTCOUNTRY
        gravity = Gravity.CENTER_HORIZONTAL
        singleLine = true
        width = matchParent
        height = BaseSize.passwordEditTextHeight
      }

      outCountry.onClick {
        val picker = OptionPicker(this@MoneyActivity, countryList) //list为选择器中的选项
        picker.setOffset(2)
        picker.setSelectedIndex(1) //默认选中项
        picker.setTextSize(18)
        picker.setCycleDisable(true) //选项不循环滚动
        picker.setOnOptionPickListener(object : OptionPicker.OnOptionPickListener() {
          override fun onOptionPicked(position: Int, option: String) {
            outCountry.setText(option) //在文本框中显示选择的选项
          }
        })
        picker.show()
      }

      button {
        text = "提交"
        onClick {
          moneyPresenter.getData(inCountry.text.toString(),outCountry.text.toString(),this@MoneyActivity)
        }
      }

      resultShow = textView {
        width = matchParent
        height = matchParent
      }
    }
  }

  private fun init() {
    countryList.add("GBP")
    countryList.add("EUR")
    countryList.add("USD")
    countryList.add("CNY")

  }
}
