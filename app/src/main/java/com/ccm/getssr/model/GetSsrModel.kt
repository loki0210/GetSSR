package com.ccm.getssr.model

import com.ccm.getssr.common.Constant
import com.ccm.getssr.net.api.GetFromNetApi
import com.ccm.getssr.net.converter.ToStringConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit


class GetSsrModel {
    fun getSsrString(callback: Callback<String>) {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.SERVER_ADDRESS) //设置网络请求的Url地址
            .addConverterFactory(ToStringConverterFactory.create()) //设置解析器
            .build()
        val getString = retrofit.create(GetFromNetApi::class.java)
        val bodyCall: Call<String> = getString.getSsrString()
        bodyCall.enqueue(callback)
    }
}