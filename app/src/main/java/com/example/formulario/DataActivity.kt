package com.example.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {
    lateinit var nameData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setup()
        // Receiving data from MainActivity
        val data: Bundle? = intent.extras
        val name: String? = data?.getString(constants.NAME)
        textViewNameDataId.text = name
    }

    private fun setup() {
        nameData = textViewNameDataId
    }

    fun goBack(v: View) {
        finish()
    }
}