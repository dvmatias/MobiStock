package com.samuraicmdv.data.datasource.retrofit

import com.samuraicmdv.data.api.HomeApi
import com.samuraicmdv.data.datasource.HomeDataSource
import javax.inject.Inject

class HomeDataSourceRetrofitImpl @Inject constructor(
    val homeApi: HomeApi
): HomeDataSource {
    override fun getUserProfile(userId: Int) {
        TODO("Not yet implemented")
    }
}