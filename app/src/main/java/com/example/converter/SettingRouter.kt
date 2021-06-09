package com.example.converter

import android.content.Context
import android.content.Intent
import android.widget.EditText

class SettingRouter {
    fun createIntent(context: Context, editText: Any):
            Intent = Intent(context,MainActivity::class.java).apply {
            putExtra(SHARED_SAVE, editText.toString())
    }
}