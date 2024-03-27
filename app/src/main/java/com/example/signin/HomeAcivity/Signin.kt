package com.example.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity





class Signin : AppCompatActivity() {
    lateinit var idText: EditText
    lateinit var pwText: EditText
    var myname: String? = null

    private var resultLanuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val nid =result.data?.getStringExtra("nidText")
            val npw = result.data?.getStringExtra("npwText")
            myname = result.data?.getStringExtra("myname").toString()


            idText.setText(nid)
            pwText.setText(npw)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idText = findViewById(R.id.tv_sid)
        pwText = findViewById(R.id.tv_spw)
        val signinButton = findViewById<Button>(R.id.bt_signin)
        val signupButton = findViewById<Button>(R.id.bt_signup)



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
            resultLanuncher.launch(intent)
        }
    }
}


