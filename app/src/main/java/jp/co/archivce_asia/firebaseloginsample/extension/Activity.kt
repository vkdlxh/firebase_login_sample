package jp.co.archivce_asia.firebaseloginsample.extension

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Activity.getContentView(): View = findViewById(android.R.id.content)

fun Activity.showSnackBar(message: String) = Snackbar.make(getContentView(), message, Snackbar.LENGTH_SHORT).show()