package com.ccm.getssr.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity() {
    private val progressDialog by lazy { ProgressDialog(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        init()
    }

    abstract fun getLayoutResId(): Int
    //用以初始化
    open fun init() {}

    //显示弹窗
    fun showProgressDialog(message: String) {
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    //隐藏弹窗
    fun dismissProgressDialog() {
        progressDialog.dismiss()
    }

    //在ui线程弹出toast
    protected fun showMyToast(message: String) {
        runOnUiThread { toast(message) }
    }

}