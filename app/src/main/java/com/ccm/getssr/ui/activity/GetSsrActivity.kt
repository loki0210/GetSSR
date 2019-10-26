package com.ccm.getssr.ui.activity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ccm.getssr.R
import com.ccm.getssr.adapter.HomeRvAdapter
import com.ccm.getssr.base.BaseActivity
import com.ccm.getssr.contract.GetSsrContract
import com.ccm.getssr.presenter.GetSsrPresenter
import org.jetbrains.anko.find

class GetSsrActivity : BaseActivity(), GetSsrContract.View {
    private val presenter = GetSsrPresenter(this)
    lateinit var homeRvAdapter: HomeRvAdapter
    lateinit var recyclerView: RecyclerView


    override fun init() {
        super.init()
        presenter.getSsr()
        showProgressDialog("加载中...")
        recyclerView = find(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        homeRvAdapter = HomeRvAdapter(this)
        recyclerView.adapter = homeRvAdapter

    }

    override fun onGetSuccess() {
        dismissProgressDialog()
    }

    override fun onGetFailed() {
        dismissProgressDialog()
        showMyToast("加载失败请重试")
    }

    override fun onGetResult(list: ArrayList<String>) {
        homeRvAdapter.setData(list)
    }

    override fun getLayoutResId(): Int = R.layout.activity_main


}
