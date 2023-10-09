package com.amrizal94.latihan1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputOld = findViewById<EditText>(R.id.editTextNumber)
        val btnOld = findViewById<Button>(R.id.btn_submit_old)
        val viewTextRes =  findViewById<TextView>(R.id.txt_view_old_res)

        val resGen:(String, String) -> String = {
            s1, s2 ->  "Tahun $s1 termasuk generasi $s2"
        }

            btnOld.setOnClickListener {
            val input =  inputOld.text.toString()
            val res = when(input.toIntOrNull()?:0){
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1996 -> "Y"
                in 1997..2012 -> "Z"
                else -> "gak tau kak"
            }
                viewTextRes.text = resGen(input, res)

        }
    }
}