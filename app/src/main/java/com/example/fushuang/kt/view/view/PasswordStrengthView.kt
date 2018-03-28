package com.example.fushuang.kt.view.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import android.view.ViewManager
import com.example.fushuang.kt.util.ToastUtil
import org.jetbrains.anko.custom.ankoView

/**
 * @author fushuang
 * @date 2018-03-27 下午1:38:35
 * @description
 */
class PasswordStrengthView : View {

  val textPaint: TextPaint = TextPaint()
  val bgPaint: Paint = Paint()
  var status = 1



  object Status{
    val Low=1
    val Middle=2
    val Height=3
  }


  constructor(context: Context) : super(context) {
    init()
  }


  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    init()
  }

  fun init() {
    textPaint.textSize = 30f
    textPaint.color = Color.BLACK
    textPaint.textAlign=Paint.Align.CENTER
    bgPaint.color = Color.GRAY
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    setMeasuredDimension(getMeasureResult(widthMeasureSpec), getMeasureResult(heightMeasureSpec))
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    canvas.drawRect(0f,0f,measuredWidth.toFloat(),measuredHeight.toFloat(),bgPaint)

    when (status) {
      Status.Low-> {
        bgPaint.color=Color.RED
        canvas.drawRect(0f,0f,measuredWidth/3.toFloat(),measuredHeight.toFloat(),bgPaint)
      }
      Status.Middle-> {
        bgPaint.color=Color.YELLOW
        canvas.drawRect(measuredWidth/3.toFloat(),0f,measuredWidth/3*2.toFloat(),measuredHeight.toFloat(),bgPaint)
      }
      Status.Height-> {
        bgPaint.color=Color.GREEN
        canvas.drawRect(measuredWidth/3*2.toFloat(),measuredWidth.toFloat(),measuredWidth/3.toFloat(),measuredHeight.toFloat(),bgPaint)
      }
      else -> {
        ToastUtil.toast("不存在状态")
      }
    }

    canvas.drawText("弱", measuredWidth / 6f, measuredHeight / 2f, textPaint)
    canvas.drawText("中", measuredWidth / 2f, measuredHeight / 2f, textPaint)
    canvas.drawText("强", measuredWidth / 6f * 5, measuredHeight / 2f, textPaint)


  }

  private fun getMeasureResult(spec: Int): Int {
    var mode = MeasureSpec.getMode(spec)
    val size = MeasureSpec.getSize(spec)
    when (mode) {
      MeasureSpec.AT_MOST -> return size
      MeasureSpec.EXACTLY -> return size
      MeasureSpec.UNSPECIFIED -> return 100
      else -> return 100
    }
  }

}

inline fun ViewManager.passwordStrengthView(theme: Int = 0) = passwordStrengthView(theme) {}
inline fun ViewManager.passwordStrengthView(theme: Int = 0, init: PasswordStrengthView.() -> Unit) = ankoView(::PasswordStrengthView, theme, init)
