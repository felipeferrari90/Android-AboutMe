package br.com.fiap.aboutme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //ACTIVITY = tela, nesse caso main activity é a tela principal

    //mainActivity herda de AppCompatActivity que herda o metodo oncreate que é
    //mais ou menos equivalente ao metodo Build do Flutter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //R = pasta Res de Resources

        //armazenos elementos em variaveis do tipo do elemento

        //deve-se sempre colocar o tipo do elemento no var se nao da erro
        val button:Button = findViewById(R.id.buttonProfissao)
        val textViewProfissao:TextView = findViewById(R.id.textViewProfissao)
        val editTextProfissao:EditText = findViewById(R.id.editProfissao)
        val botaoEditar:Button = findViewById(R.id.buttonEditar)

        //ao clicar no botao algo vai acontecer
        button.setOnClickListener {

            //no momento que clicar o botão vai pegar tudo o que ta digitado no
            //EditText naquele momento e salvar na variavel profissao
            val profissao = editTextProfissao.text.toString()

            //se ao fazer o clique a variavel nao estiver vazia mesmo algo sera feito
            //isNotEmpty - aparentemente um metodo do Object ou de alguma classe nativa
            if(profissao.isNotEmpty()) {

                //que sera a troca do textView da profissao
                textViewProfissao.text = profissao

                //GONE = elemento nao esta na tela mais
                //invisible = elemento esta na tela porem invisivel

                button.visibility = View.GONE
                editTextProfissao.visibility = View.GONE

            }else {
                //caso nada seja digitado isso acontece (um toast avisando o erro e um .error)
                //que provavelmente indica uma mensagem em vermelho de erro
                editTextProfissao.error = "Digite sua profissão"
                toast("Digite sua profissão")
            }

        }

        //do jeito que ta ao vc mudar o campo corretamente o botao e o capo some, entao
        //criaremos um evento de clique somente na profisao pra caso ele queria editar denovo
        //o campo e o botao reapareça
        textViewProfissao.setOnClickListener {
            button.visibility = View.VISIBLE
            editTextProfissao.visibility = View.VISIBLE
        }

        botaoEditar.setOnClickListener {
            //ao clicar abre outra tela (editActivity)

            //Intent - recebe um contexto e a classe (em java) por isso o class.java
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent);
        }

    }
}
