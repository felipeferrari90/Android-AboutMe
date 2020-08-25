package br.com.fiap.aboutme

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var editTextNome:EditText = findViewById(R.id.editTextName)
        var editTextProfissao:EditText = findViewById(R.id.editTextProfissao)
        var editTextBio:EditText = findViewById(R.id.editTextBio)
        var buttonSalvar:Button = findViewById(R.id.buttonSalvar)

        //shared é a persistencia onde vc passa o nome dela e o modo privado ou publico
        //o publico é esse shared ser usado por varos apps e nao só esse
        val sharedPreferences:SharedPreferences = getSharedPreferences("aboutme", Context.MODE_PRIVATE)

        //recuperar dados
        val nome = sharedPreferences.getString("nome","")
        val profissao = sharedPreferences.getString("profissao","")
        val bio = sharedPreferences.getString("bio","")

        //exibir dados
        editTextNome.setText(nome)
        editTextProfissao.setText(profissao)
        editTextBio.setText(bio)




        buttonSalvar.setOnClickListener {

            //salvar dados

            //abre arquivo pra edicao
            val editor = sharedPreferences.edit()

            //adicionar
            editor.putString("nome",editTextNome.text.toString())
            editor.putString("profissao",editTextProfissao.text.toString())
            editor.putString("bio",editTextBio.text.toString())

            //salvar
            editor.apply()
            toast("dados salvos com sucesso")




        }

        //vc pode excluir o seu sharedpreferences se excluir seu cache no android
        // nao se usa
    }
}