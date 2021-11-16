package com.example.imcapp.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento: String): Int {

    //Obter a data atual
    //LocalDate.now() - mostra a data que ta no celular do usuario
    val hoje = LocalDate.now()

    //Converter a data nascimento que é string em LocalDate
    val data = dataNascimento.split("/")

    val nascimento = LocalDate.of(
        data.get(2).toInt(),
        data.get(1).toInt(),
        data.get(0).toInt())

    //Calcular o intervalo entre a data atual (hoje)
    //e a data de nascimento
    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())

    return 0
}