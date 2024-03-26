package com.example.signin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userid = intent.getStringExtra("idText")
        val username = intent.getStringExtra("myname")
        val exitButton = findViewById<Button>(R.id.bt_exit)
        val tv_userid = findViewById<TextView>(R.id.tv_userid)
        val tv_username = findViewById<TextView>(R.id.tv_username)
        tv_userid.text = "아이디: $userid"
        tv_username.text = "이름: $username"


        exitButton.setOnClickListener {
            finish()
        }


    }
}