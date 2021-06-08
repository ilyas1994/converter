package com.example.converter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  lateinit var edit_text_current_amount: EditText

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edit_text_current_amount = findViewById(R.id.edit_text_current_amount)
        val getCurrentCurrency = intent.getStringExtra("save")

        if (getCurrentCurrency != null && edit_text_current_amount.text != null) {
            edit_text_current_amount.isEnabled = true
            textview_exhange_usd.text =
                "${getString(R.string.one_usd_qually)} " +
                        "$getCurrentCurrency ${getString(R.string.currency_usd)}"
        } else {
            edit_text_current_amount.isEnabled = false
            textview_result.text = "${getString(R.string.go_to_settings)}"
        }
        

        fun count_up() {
            if (!edit_text_current_amount.text.isEmpty()) {
                var getValueFragmentSetting = getCurrentCurrency.toString().toInt()
                var calculations =
                    edit_text_current_amount.text.toString().toInt() * getValueFragmentSetting
                textview_result.text = "$calculations ${getString(R.string.tenge)}"
            } else {
                Toast.makeText(
                    this,
                    "${getString(R.string.toast_go_to_settings)}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        button_result.setOnClickListener {
            count_up()
        }
        image_button_setting.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Intent(this@MainActivity, SettingActivity::class.java).also { intent = it }
                startActivity(intent)
            }
        })
    }
}