package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton

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
        editSenha = findViewById(R.id.edit_email)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editdata = findViewById(R.id.edit_data)
        radioFeminino = findViewById(R.id.edit_sexo_feminino)
        radioMasculino = findViewById(R.id.edit_sexo_masculino)

    }

    // Método para criar o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(validarCampos()) {
            //gravar os dados
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

        if (editProfissao.text.isEmpty()) {
            editProfissao.error = "Profissão é obrigatório!"
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

        if (radioFeminino.text.isEmpty()) {
            radioFeminino.error = "Seleção de sexo é obrigatório!"
            valido = false
        }

        if (radioMasculino.text.isEmpty()) {
            radioMasculino.error = "Seleção de sexo é obrigatório!"
            valido = false
        }

        return valido
    }
}