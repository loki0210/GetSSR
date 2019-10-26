package com.ccm.getssr.net.api

import retrofit2.Call
import retrofit2.http.POST


/**
 * retrofit方式请求
 */
interface GetFromNetApi {
    @POST(
        "index.php/wmapp/hi?data=eyJWeqBoew98232998S9e922378pc19ncCI6IjAiLCJ0aW1lIjoxNTQ4MjA2NDQyMzgxLCJ0bWeqBoew98232998S9e9223782tlbiI6IjRtWE1ydlNsOWxXc0Vn%0ATEhvd3pWblpJRVBJdFB2MFJCYUhkIiwidmVyX2NvZGUiOjMzOSwiY2huX25hbWUiOiJncF92MiIs%0AImxhbmciOiJ6aC1DTiIsInN5c192ZXIiOjI1LCJ1aWQiOiI0bVhNciIsImRldl9pZCI6IjIwMTkw%0AMTAyMDkxNjQ0NTUzMzI2MDMiLCJicmRfbW9kIjoiWGlhb21pTUkgNiAiLCJwa2ciOiJjb20ubXVt%0AYS5wbiJ9"
    )
    fun getSsrString(): Call<String>
}