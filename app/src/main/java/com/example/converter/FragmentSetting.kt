package com.example.converter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_fragment_setting.*
import kotlinx.android.synthetic.main.activity_main.*

class FragmentSetting : AppCompatActivity() {

    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_setting)
        var editFragment_usd: EditText = findViewById(R.id.edit_usd)


        val sharedpref_key = sharedPreferences.getString("save_shared", "")
        editFragment_usd.setText(sharedpref_key)


        fun sharedpref_save(){
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("save_shared", editFragment_usd.text.toString())
            editor.apply()
        }



            button_send_fragment_activity_save.setOnClickListener {
            sharedpref_save()

            intent = Intent(this, MainActivity::class.java)
            intent = intent.putExtra("save", editFragment_usd.text.toString())
            startActivity(intent)

        }

    }
}