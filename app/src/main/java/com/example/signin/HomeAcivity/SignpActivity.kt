package com.example.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signp)

        val myname = findViewById<EditText>(R.id.tv_myname)
        val nidText = findViewById<EditText>(R.id.tv_myid)
        val npwText = findViewById<EditText>(R.id.tv_mypw)
        val nsigninButton = findViewById<Button>(R.id.bt_nsignup)


        nsigninButton.setOnClickListener {

            when{
                myname.text.isEmpty() -> {
                    Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                }
                nidText.text.isEmpty() -> {
                    Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                }
                npwText.text.isEmpty() -> {
                    Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this,"회원가입 완료", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Signin::class.java)
                    intent.putExtra("nidText", nidText.text.toString())
                    intent.putExtra("npwText", npwText.text.toString())
                    intent.putExtra("myname", myname.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()

                }

            }

        }
    }
}