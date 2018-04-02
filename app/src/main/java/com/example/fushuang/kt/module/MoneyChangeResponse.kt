package com.example.fushuang.kt.module

/**
 * @author fushuang
 * @date 2018-04-02 下午2:24:50
 * @description
 */
class MoneyChangeResponse {
  var success: String? = null

  var result: Result? = null

  inner class Result {
    internal var status: String? = null
    internal var scur: String? = null
    internal var tcur: String? = null
    internal var ratenm: String? = null
    internal var update: String? = null
    internal var rate: Float = 0.toFloat()

    override fun toString(): String {
      return "Result{" +
        "status='" + status + '\'' +
        ", scur='" + scur + '\'' +
        ", tcur='" + tcur + '\'' +
        ", ratenm='" + ratenm + '\'' +
        ", update='" + update + '\'' +
        ", rate=" + rate +
        '}'
    }
  }

  override fun toString(): String {
    return "MoneyChangeResponse{" +
      "success='" + success + '\'' +
      ", result=" + result +
      '}'
  }
}
