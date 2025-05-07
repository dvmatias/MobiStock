package com.samuraicmdv.featurelogin.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.samuraicmdv.common.ERROR_LOGIN_INCORRECT_PASSWORD
import com.samuraicmdv.common.ERROR_LOGIN_PASSWORD_EMPTY
import com.samuraicmdv.common.ERROR_LOGIN_UNKNOWN
import com.samuraicmdv.common.ERROR_LOGIN_USER_EMPTY
import com.samuraicmdv.common.ERROR_LOGIN_USER_NOT_FOUND
import com.samuraicmdv.featurelogin.R

@Composable
fun getLoginError(errorCode: Int?): String? =
    when (errorCode) {
        ERROR_LOGIN_UNKNOWN -> null
        ERROR_LOGIN_USER_EMPTY -> stringResource(id = R.string.username_empty_error_message)
        ERROR_LOGIN_PASSWORD_EMPTY -> stringResource(id = R.string.password_empty_error_message)
        ERROR_LOGIN_USER_NOT_FOUND -> stringResource(id = R.string.user_not_found_error_message)
        ERROR_LOGIN_INCORRECT_PASSWORD -> stringResource(id = R.string.incorrect_password_error_message)
        else -> null
    }