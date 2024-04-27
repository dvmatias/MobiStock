package com.cmdv.network.retrofit

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val READ_TIMEOUT = 20L
    private const val WRITE_TIMEOUT = 20L
    private const val CONNECTION_TIMEOUT = 20L
    private const val HEADER_CONTENT_TYPE = "Content-Type"
    private const val HEADER_APPLICATION_JSON = "application/json"

    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url: HttpUrl = originalHttpUrl.newBuilder()
                    .build()

                val requestBuilder: Request.Builder = original.newBuilder()
                    .header(HEADER_CONTENT_TYPE, HEADER_APPLICATION_JSON)
                    .method(original.method, original.body)
                    .url(url)

                val request = requestBuilder.build()
                chain.proceed(request)
            }
        )
        .addInterceptor(RetrofitLoggingInterceptor.interceptor)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .build()

}