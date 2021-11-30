package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashBoardActivity : AppCompatActivity() {
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var buttonPesar: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        tvNome = findViewById(R.id.tv_nome_dash)
        tvProfissao = findViewById(R.id.tv_profissao_dash)
        tvAltura = findViewById(R.id.tv_altura_dash)

        preencherDashboard()

        supportActionBar!! .hide()

        buttonPesar = findViewById(R.id.button_pesar_agora)

        buttonPesar.setOnClickListener {
            val abrirTelaPeso = Intent(this, NovoPesoActivity::class.java)
            startActivity(abrirTelaPeso)
        }
    }

    private fun preencherDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
    }

}