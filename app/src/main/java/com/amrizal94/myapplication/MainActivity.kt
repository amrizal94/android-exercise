package com.amrizal94.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var hasil: TextView
    companion object {
        const val STATE_RESULT = "state_result"
    }

    private fun perkalianList(vararg numbers: Int ):Int{
        return numbers.reduce { acc, i -> acc * i }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val length = findViewById<EditText>(R.id.edt_length)
        val width = findViewById<EditText>(R.id.edt_width)
        val height = findViewById<EditText>(R.id.edt_height)
        val hitung = findViewById<Button>(R.id.btn_luas)
        hasil = findViewById(R.id.tv_result)

        hitung.setOnClickListener {
            val valLength = length.text.toString()
            val valWidth= width.text.toString()
            val valHeight = height.text.toString()

            if (valLength.isEmpty()) length.error = "Field ini tidak boleh kosong"
            if (valWidth.isEmpty()) width.error = "Field ini tidak boleh kosong"
            if (valHeight.isEmpty()) height.error = "Field ini tidak boleh kosong"

            val res = perkalianList(valLength.toIntOrNull()?:0,valWidth.toIntOrNull()?:0,valHeight.toIntOrNull()?:0)
            if (res != 0) hasil.text = res.toString()
        }

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            hasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, hasil.text.toString())
    }
}