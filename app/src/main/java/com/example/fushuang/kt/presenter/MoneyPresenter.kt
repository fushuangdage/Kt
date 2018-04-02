package com.example.fushuang.kt.presenter

import com.example.fushuang.kt.module.MoneyChangeResponse
import com.example.fushuang.kt.net.RetrofitHelper
import com.example.fushuang.kt.net.RxScheduler
import com.example.fushuang.kt.view.activity.MoneyActivity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.toast

/**
 * @author fushuang
 * @date 2018-04-02 下午4:52:13
 * @description
 */
class MoneyPresenter {

  fun getData(inCountry: String, outCountry: String, moneyActivity: MoneyActivity) {
    RetrofitHelper.getApiWithUid()
      .getMoneyChange(inCountry, outCountry)
      .compose(RxScheduler.defaultScheduler())
      .subscribe(object : Observer<MoneyChangeResponse> {
        override fun onError(e: Throwable) {
          moneyActivity.toast("出错拉")
        }

        override fun onComplete() {
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: MoneyChangeResponse) {
//          moneyActivity.resultShow.setText(t.toString())   //哇擦，这样写为啥会有问题？还不报错！！！！
          moneyActivity.toast(t.toString())
        }

      })
  }

}
