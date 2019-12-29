package com.fanqi.wankt.ui

import androidx.lifecycle.ViewModel
import com.fanqi.wankt.common.ServiceFactory
import com.fanqi.wankt.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author:范启
 * Created on 2019-12-29.
 * Description:
 */
class LoginViewModel : ViewModel() {

    fun login(username: String, password: String) {
        val call = ServiceFactory.INSTANCE.wanService.login(username, password)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Logger.e(t.toString())
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {

            }
        })
    }

}