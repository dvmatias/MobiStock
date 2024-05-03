package com.samuraicmdv.common.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat

/**
 * Extension function - Used for starting activities.
 *
 * @param data (Optional) Bundle to send in the launching Activity Intent.
 * @param finish (Required) Set to 'true' if the calling activity must be finished.
 * @param A Calling Activity.
 */
inline fun <reified A : Activity> Activity.navigate(data: Bundle? = null, finish: Boolean) {
    Intent(this, A::class.java).also { intent ->
        data?.let { bundle -> intent.putExtras(bundle) }
        overridePendingTransition(0, 0)
        ActivityCompat.startActivity(this, intent, null)
        if (finish) this.finish()
    }
}