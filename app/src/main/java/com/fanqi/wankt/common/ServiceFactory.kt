package com.fanqi.wankt.common

import android.util.Log
import com.fanqi.wankt.constant.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by fanqi on 2019-12-19.
 * Description:
 */

class ServiceFactory {

    private constructor() {}

    companion object {
        const val TAG = "ServiceFactory"
        val INSTANCE = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = ServiceFactory()
    }

    private fun <T> getService(url: String, service: Class<T>): T = getRetrofit(url).create(service)

    private fun getRetrofit(url: String): Retrofit {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)

        val okHttpClient = builder.build()

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val wanService:WanService=getService(Constant.BASE_URL,WanService::class.java)
}

