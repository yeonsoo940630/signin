package com.example.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val idText = findViewById<EditText>(R.id.tv_sid)
        val pwText = findViewById<EditText>(R.id.tv_spw)
        val signinButton = findViewById<Button>(R.id.bt_signin)
        val signupButton = findViewById<Button>(R.id.bt_signup)

        val nid = intent.getStringExtra("nidText")
        val npw = intent.getStringExtra("npwText")
        val myname = intent.getStringExtra("myname")
        idText.setText(nid)
        pwText.setText(npw)



        signinButton.setOnClickListener {

            when{
                idText.text.isEmpty() && pwText.text.isEmpty() -> {
                    Toast.makeText(this,"아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                idText.text.isEmpty() -> {
                    Toast.makeText(this,"아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                pwText.text.isEmpty() -> {
                    Toast.makeText(this,"비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("idText",idText.text.toString())
                    intent.putExtra("myname", myname)
                    startActivity(intent)

                }

            }

        }

        signupButton.setOnClickListener {

            val intent = Intent(this, SignpActivity::class.java)
            startActivity(intent)
        }
    }
}


