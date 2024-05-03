package com.samuraicmdv.common.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat

inline fun <reified A: Activity> Activity.navigate(data: Bundle?, finish: Boolean) {
    Intent(this, A::class.java).also { intent ->
        data?.let { bundle -> intent.putExtras(bundle) }
        overridePendingTransition(0, 0)
        ActivityCompat.startActivity(this, intent, null)
        if (finish) this.finish()
    }
}