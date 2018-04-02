package com.example.fushuang.kt.net

import com.example.fushuang.kt.module.MoneyChangeResponse

import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Serenade on 17/6/10.
 */

interface RetrofitApi {

  @GET("http://api.k780.com")
  fun getMoneyChange(@Query("scur") scur: String, @Query("tcur") tcur: String): Observable<MoneyChangeResponse>

}
