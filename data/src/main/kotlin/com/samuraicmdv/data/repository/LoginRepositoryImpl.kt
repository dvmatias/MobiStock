package com.samuraicmdv.data.repository

import android.util.Log
import com.samuraicmdv.common.LOG_TAG
import com.samuraicmdv.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(): LoginRepository {
    override fun loginWithCredentials() {
        Log.d(LOG_TAG, "Invoking repo")
    }
}