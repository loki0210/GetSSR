package com.ccm.getssr.contract

import com.ccm.getssr.base.BasePresenter

/**
 * 契约类，清晰管理
 */
class GetSsrContract {
    interface Presenter : BasePresenter {
        fun getSsr()
    }

    interface View {
        fun onGetSuccess()
        fun onGetFailed()
        fun onGetResult(list: ArrayList<String>)
    }
}