package com.ccm.getssr.bean


class SsrBaseEntity {
    var d: DBean? = null

    class DBean {
        var gp: List<GpBean>? = null

        class GpBean {
            var list: List<ListBean>? = null

            class ListBean {

                var pd: String? = null
                var ip: String? = null
                var plt: List<String>? = null
            }
        }
    }
}