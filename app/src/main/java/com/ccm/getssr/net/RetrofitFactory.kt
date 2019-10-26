package com.ccm.getssr.net

import com.ccm.getssr.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 单例实现
 */
class RetrofitFactory private constructor() {
    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    //Header拦截器
    private val interceptor: Interceptor

    init {
        interceptor = Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                .build()
            chain.proceed(request)
        }
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    //对外提供方法
    fun <T> create(service: Class<T>): T = retrofit.create(service)
}