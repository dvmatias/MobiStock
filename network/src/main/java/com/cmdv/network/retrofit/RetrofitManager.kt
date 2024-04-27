package com.cmdv.network.retrofit

import com.cmdv.network.BuildConfig
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val GSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"

/**
 * Manager - Retrofit.
 */
class RetrofitManager {
    /**
     * Creates and returns an Retrofit instance.
     */
    fun getInstance(): Retrofit {
        val gson = GsonBuilder()
            .setDateFormat(GSON_DATE_FORMAT)
            .create()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(RetrofitClient.client)
            .build()
    }
}