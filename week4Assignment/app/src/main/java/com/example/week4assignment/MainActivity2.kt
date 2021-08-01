package com.example.week4assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //get reference to views
        val playerImage:ImageView = findViewById(R.id.ivImage2s)
        val changeNumbers: TextView = findViewById(R.id.textView2)
        val playerName = findViewById<TextView>(R.id.textView)
        val email = findViewById<TextView>(R.id.textEmail)
        val backArrow = findViewById<ImageView>(R.id.imageView6)

        //get values from intent
        val emailFromActivity1 = intent.getStringExtra("contact")
        val image = intent.extras?.getInt("image")
        val player = intent.getStringExtra("contactList")
        val phoneNumber = intent.getStringExtra("getPhoneNumber")


        //set values gotten from activity 1 to views
        if (image != null) {
            playerImage.setImageResource(image)
        }
        changeNumbers.text = phoneNumber
        playerName.text = player
        email.text = emailFromActivity1

        backArrow.setOnClickListener {
            onBackPressed()
        }



    }
}