package com.example.converter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fragment_setting.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextSum: EditText = findViewById(R.id.edit_text_summ)
        val getCurrentValuta = intent.getStringExtra("save")
        current_exhange.text = "1 USD = $getCurrentValuta KZT"


        button_result.setOnClickListener {
            if (editTextSum.text.isEmpty())
                Toast.makeText(this,"Перейдите в настройки", Toast.LENGTH_SHORT).show()
            else{
                var getValueFragmentSetting = getCurrentValuta.toString().toInt()
                var res = editTextSum.text.toString().toInt() * getValueFragmentSetting
                textview_current_exhange.text = "$res тенге"
            }

        }



        image_button_setting.setOnClickListener {
        intent = Intent(this, FragmentSetting::class.java)
            startActivity(intent)
        }
    }
}