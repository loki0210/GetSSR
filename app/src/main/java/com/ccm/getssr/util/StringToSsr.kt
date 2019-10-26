package com.ccm.getssr.util

import android.util.Base64
import com.ccm.getssr.bean.SsrBaseEntity
import com.google.gson.Gson


//数据转换
fun getSsrBean(string: String): ArrayList<String> {
    val gson = Gson()
    val ssrBeanList: ArrayList<String> = ArrayList()
    val ssrBaseEntity: SsrBaseEntity = gson.fromJson(string, SsrBaseEntity::class.java)
    val ssrBaseEntitySize = ssrBaseEntity.d?.gp?.size
    for (ss in 0 until ssrBaseEntitySize!!) {
        val inside = ssrBaseEntity.d!!.gp!![ss].list?.size
        for (ssj in 0 until inside!!) {
            val ssrBean = ssrBaseEntity.d!!.gp!![ss].list!![ssj]
            val ssrString: String =
                ssrBean.ip + ":" + ssrBean.plt!![0] + ":origin:aes-256-cfb:plain:" + Base64.encodeToString(
                    ssrBean.pd!!.toByteArray(),
                    Base64.DEFAULT
                ).trim() + "/?obfsparam=&remarks=" + Base64.encodeToString(
                    ssrBean.ip!!.toByteArray(),
                    Base64.DEFAULT
                ) + "&group=d3VtYQ"
            ssrBeanList.add(
                "ssr://" + Base64.encodeToString(
                    ssrString.toByteArray(),
                    Base64.DEFAULT
                )
            )
        }
    }
    return ssrBeanList
}
