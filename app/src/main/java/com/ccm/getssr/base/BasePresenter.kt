package com.ccm.getssr.base

import android.os.Handler
import android.os.Looper

interface BasePresenter {
    //创建伴生对象
    companion object {
        val handler by lazy { Handler(Looper.getMainLooper()) }
    }

    //子线程通知主线程
    fun uiThread(f: () -> Unit) {
        handler.post { f() }
    }
}