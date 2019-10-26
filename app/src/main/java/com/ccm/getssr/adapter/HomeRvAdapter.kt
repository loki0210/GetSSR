package com.ccm.getssr.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ccm.getssr.R
import org.jetbrains.anko.find

class HomeRvAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_SELLER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TITLE
        } else TYPE_SELLER
    }

    private var homeData: ArrayList<String> = ArrayList()

    fun setData(data: ArrayList<String>) {
        this.homeData = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = homeData.size + 1
    /**
     * 根据viewtype判断显示的类型
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_TITLE -> TitleHolder(View.inflate(context, R.layout.item_view, null))
            TYPE_SELLER -> SellerHolder(View.inflate(context, R.layout.item_view, null))
            else -> TitleHolder(View.inflate(context, R.layout.item_view, null))
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TITLE -> (holder as TitleHolder).bindData("复制到shadowsocksR连接")
            TYPE_SELLER -> (holder as SellerHolder).bindData(homeData[position - 1])
            else -> (holder as TitleHolder).bindData("获取出错了")
        }
    }

    inner class SellerHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val textView: TextView = item.find(R.id.tv)

        fun bindData(s: String) {
            textView.text = s
        }
    }

    inner class TitleHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val textView: TextView = item.find(R.id.tv)

        fun bindData(s: String) {
            textView.text = s
        }
    }
}