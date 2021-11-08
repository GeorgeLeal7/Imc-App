package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    // Late = tarde      init = iniciar
    //O lateinit seria uma inicialização atrasada de uma variavel
    //Nessecaso a variavel será executada depois de abrir a activity
    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editdata: EditText
    lateinit var radioFeminino: RadioButton
    lateinit var radioMasculino: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)


        editNome = findViewById(R.id.edit_nome)
        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editdata = findViewById(R.id.edit_data)
        radioFeminino = findViewById(R.id.edit_sexo_feminino)
        radioMasculino = findViewById(R.id.edit_sexo_masculino)

        supportActionBar!!.title = "Nova Conta"



        //Colocar um Listener de click no editText Data de Nascimento
        //Para abrir o calendario (DatePicker)

        editdata.setOnClickListener{

            criarDatePicker()
        }
    }

    private fun criarDatePicker() {

        //Criar um calendário
        // *** Obter a data atual (hoje)
        val calendario = Calendar.getInstance()

        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->

            var mesReal = _mes + 1
            var mesString = "$mesReal"
            var diaString = "$_dia"

            if (mesReal < 10) {
                mesString = "0$mesReal"
            }

            if (_dia < 10) {
                diaString = "0$_dia"
            }


            Log.i("xxxx", "$diaString/$mesString/$_ano")
            editdata.setText("$diaString/$mesString/$_ano")
        }, ano, mes, dia)

        datePicker.show()
    }

    // Método para criar o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(validarCampos()) {
            //gravar os dados no SharedPreferences
            // Criando um arquivo xml chamado "usuario"
            // Se o arquivo ja existir ele só vai abrir
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            val editor = arquivo.edit()

            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("nascimento", editdata.text.toString())
            editor.putString("sexo", if(radioMasculino.isChecked) "M" else "F")
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso!!", Toast.LENGTH_SHORT).show()
            finish()

        } else{
            //gravo nada
        }

        return super.onOptionsItemSelected(item)
    }

    private fun validarCampos() : Boolean {

        var valido = true

        if(editEmail.text.isEmpty()) {
            editEmail.error = "E-mail é obrigatório!"
            valido = false
        }

        if (editSenha.text.isEmpty()) {
            editSenha.error = "Senha é obrigatório!"
            valido = false
        }

        if (editNome.text.isEmpty()) {
            editNome.error = "Nome é obrigatório!"
            valido = false
        }

        if (editAltura.text.isEmpty()) {
            editAltura.error = "Altura é obrigatório!"
            valido = false
        }

        if (editdata.text.isEmpty()) {
            editdata.error = "Data de Nascimento é obrigatório!"
            valido = false
        }

        if (!radioFeminino.isChecked && !radioMasculino.isChecked) {
            radioFeminino.error = "Seleção de sexo é obrigatório!"
            valido = false
        }

        return valido
    }
}