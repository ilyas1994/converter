package com.example.converter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_setting.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edit_text_current_amount: EditText

    // Вылатет и почему то приходит null, вытащил в глобальную переменную
    // private var getCurrentCurrency = intent.getStringExtra(SHARED_SAVE) по причине что
    // override fun onClick(view: View) находится за пределами onCreate и не видит переменную
    // getCurrentCurrency, как сделать так чтобы метод onClick который находится за пределами onCreate
    // смог увидеть что в есть в методе onCreate
    private var getCurrentCurrency = intent.getStringExtra(SHARED_SAVE)

   private fun count_up() {
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

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_result.setOnClickListener(this)
        button_save_setting_activity.setOnClickListener(this)

        edit_text_current_amount = findViewById(R.id.edit_text_current_amount)
//        val getCurrentCurrency = intent.getStringExtra(SHARED_SAVE)

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

//        button_result.setOnClickListener {
//            count_up()
//        }

        image_button_setting.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Intent(this@MainActivity, SettingActivity::class.java).also { intent = it }
                startActivity(intent)
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putString("KEY", textview_exhange_usd.text.toString())
            putString("KEY2", textview_result.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textview_exhange_usd.text = savedInstanceState.getString("KEY")
        textview_result.text = savedInstanceState.getString("KEY2")
    }

    override fun onClick(view: View){

        when(view.id){
            R.id.button_result -> count_up()

        }
    }
}