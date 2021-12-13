package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.imcapp.utils.converteDataParaPortuguesBrasil
import java.time.LocalDate

class NovoPeso2Activity : AppCompatActivity() {

    lateinit var  tvDataPessagem: TextView
    lateinit var  buttonRegistarPeso: Button
    lateinit var  editNovoPeso: EditText
    lateinit var  spinnerAtividades: Spinner



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_peso2)

        //!! se chama double-bang
        supportActionBar!!.hide()

        tvDataPessagem = findViewById(R.id.novo_peso_campo_data_pesagem)

        tvDataPessagem.text = converteDataParaPortuguesBrasil(LocalDate.now())

        buttonRegistarPeso = findViewById(R.id.novo_peso_button_registrar)

        editNovoPeso = findViewById(R.id.novo_peso_campo_novo_peso)

        spinnerAtividades = findViewById(R.id.novo_peso_campo_array)

        buttonRegistarPeso.setOnClickListener {

            gravarPeso()

        }
    }

    private fun gravarPeso() {

        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        val peso = arquivo.getString("peso", "")
        val dataPessagem = arquivo.getString("data_pesagem", "")

        editor.putString("data_pesagem", "$dataPessagem;${LocalDate.now()}")
        editor.putString("peso", "${peso};${editNovoPeso.text.toString()}")
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)

        editor.commit()

    }
}