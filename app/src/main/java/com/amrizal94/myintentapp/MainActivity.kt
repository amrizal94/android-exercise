package com.amrizal94.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity = findViewById<Button>(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData = findViewById<Button>(R.id.btn_move_activity_with_data)
        btnMoveActivityWithData.setOnClickListener(this)

        val btnMoveActivityWithObject:Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveActivityWithObject.setOnClickListener(this)

        val btnDialNumber:Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
                val moveActivty = Intent(this, MoveActivity::class.java)
                startActivity(moveActivty)
            }

            R.id.btn_move_activity_with_data ->{
                val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Emon")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_with_object ->{
                val person = Person(
                    "Bhum Bhum",
                    5,
                    "bhum@bhum.com",
                    "Kediri"
                )

                val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number ->{
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}