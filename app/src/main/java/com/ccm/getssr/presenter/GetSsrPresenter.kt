package com.ccm.getssr.presenter

import android.util.Base64
import com.ccm.getssr.contract.GetSsrContract
import com.ccm.getssr.model.GetSsrModel
import com.ccm.getssr.util.getSsrBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetSsrPresenter(val view: GetSsrContract.View) : GetSsrContract.Presenter {
    private val getSsrModel by lazy { GetSsrModel() }

    override fun getSsr() {
        this.getSsrModel.getSsrString(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                view.onGetSuccess()
                view.onGetResult(
                    getSsrBean(
                        String(
                            Base64.decode(
                                response.body().toString(),
                                Base64.DEFAULT
                            )
                        )
                    )
                )
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                view.onGetFailed()
            }
        })
    }


}