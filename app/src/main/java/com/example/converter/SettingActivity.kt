package com.example.converter

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_setting.*

const val SHARED_PREF_KEY = "shared_pref_key"
const val SHARED_SAVE = "save_shared"

class SettingActivity : AppCompatActivity() {

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
    }

    private fun sharedpref_save() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(SHARED_SAVE, editText_usd.text.toString())
        editor.apply()
    }

    private val settingRouter = SettingRouter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val editText_usd: EditText = findViewById(R.id.editText_usd)
        val sharedpref_key = sharedPreferences.getString(SHARED_SAVE, "")
        editText_usd.setText(sharedpref_key)
        val intent = settingRouter.createIntent(this, editText_usd.text.toString())
        button_save_setting_activity.setOnClickListener {
            sharedpref_save()
            startActivity(intent)
        }
    }
}