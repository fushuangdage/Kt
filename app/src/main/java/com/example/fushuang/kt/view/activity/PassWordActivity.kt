package com.example.fushuang.kt.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Gravity

import com.example.fushuang.kt.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class PassWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{

            var editText = editText {
                gravity = Gravity.CENTER_HORIZONTAL
                width = matchParent;
                height = dip(40)
                hint = "请输入密码"
            }

            button{
                text="校验"
                onClick {
                    var password = editText.text.toString()
                    checkPwd(password)

                }
            }

        }.let { setContentView(it) }
    }

    private fun checkPwd(password: String) {

        if (password.contains(" ")){
            toast("含有不合理字符")
            return
        }

       if (password.length>5){

            if (Regex("[0-9]+").matches(password)) {
                toast("不能为纯数字")
                return
            }

            if (Regex("[a-z]+",RegexOption.IGNORE_CASE).matches(password)) {
                toast("不能为纯字母")
                return
            }


            if (Regex("[0-9]").containsMatchIn(password)
                    &&Regex("[a-z]").containsMatchIn(password)
                    &&Regex("[A-Z]").containsMatchIn(password)) {

                if (Regex("[!@#$%^&*()_+=,.？]").containsMatchIn(password)) {
                    toast("强")
                    return
                }

                toast("中")
                return
            }

            toast("弱")


        }else{
            toast("密码长度必须大于5位")
        }


    }





}
