package com.cmdv.network.retrofit

import com.cmdv.network.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Login interceptor - Retrofit. This class provides logging capabilities for Retrofit service calls actions.
 */
object RetrofitLoggingInterceptor {

    /**
     * Interceptor. Only allows logging on "development" environments.
     */
    val interceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().also {
            when (BuildConfig.FLAVOR) {
                "qa" -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }

}