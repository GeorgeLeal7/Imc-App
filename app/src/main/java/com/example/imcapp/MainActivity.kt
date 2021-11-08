package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //!! se chama double-bang
        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val buttonCriar = findViewById<Button>(R.id.button_criar)
        val editEmail = findViewById<EditText>(R.id.edit_email_login)
        val editSenha = findViewById<EditText>(R.id.edit_senha_login)

        buttonEntrar.setOnClickListener {

            //Abrimos o arquivo
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            //Recuperamos o email e a senha de dentro do arquivo
            val email = arquivo.getString("email", "")
            val senha = arquivo.getString("senha", "")


            //Verificar se o email e a senha guardados no arquivo
            if(email == editEmail.text.toString() && senha == editSenha.text.toString()) {
                val abrirDashboard = Intent(this, DashBoardActivity::class.java)
                startActivity(abrirDashboard)
            }
            else{
                Toast.makeText(this, "Email ou Senha incorreta", Toast.LENGTH_SHORT).show()
            }



        }

        buttonCriar.setOnClickListener {
            val abrirCadastro = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirCadastro)
        }


    }

}