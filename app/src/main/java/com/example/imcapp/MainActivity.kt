package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //!! se chama double-bang
        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)

        buttonEntrar.setOnClickListener {
            val abrirDashboard = Intent(this, DashBoardActivity::class.java)
            startActivity(abrirDashboard)
        }

    }
}