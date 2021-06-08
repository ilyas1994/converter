package com.example.converter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val editText_usd: EditText = findViewById(R.id.editText_usd)

        val sharedpref_key = sharedPreferences.getString("save_shared", "")
        editText_usd.setText(sharedpref_key)

        fun sharedpref_save() {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("save_shared", editText_usd.text.toString())
            editor.apply()
        }

        fun intent_putString() {
            intent = Intent(this, MainActivity::class.java)
            intent = intent.putExtra("save", editText_usd.text.toString())
            startActivity(intent)
        }
        button_save_setting_activity.setOnClickListener {
            sharedpref_save()
            intent_putString()
        }
    }
}