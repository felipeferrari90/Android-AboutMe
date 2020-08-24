package br.com.fiap.aboutme

import android.app.Activity
import android.widget.Toast

//metodo criado pra gerar um toast
fun Activity.toast(msg:String) {

    //acessando o maketest - metodo estatico do Toast que gera a msg e o mostra acessando
    // o .show()
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}