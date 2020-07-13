package jp.co.archivce_asia.firebaseloginsample.extension

import android.util.Patterns

fun CharSequence?.isEmailFormat(): Boolean {
    return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}