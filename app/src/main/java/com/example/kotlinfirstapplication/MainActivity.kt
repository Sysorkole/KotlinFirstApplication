package com.example.kotlinfirstapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btRegistrar = registrarBotao // Botão de Registrar Pessoa
        var mensagem = mensagem // Mensagem que notifica ao usuário

        btRegistrar.setOnClickListener {
            val nome = nome.text.toString() // A variavel recebe o que está dentro do campo nome
            val sobrenome = sobrenome.text.toString() // A variavel recebe o que está dentro do campo nome
            val endereco = endereco.text.toString() // A variavel recebe o que está dentro do campo nome
            val idadeBotao: Int
            val nascimento: Int

            if (idade.text.toString() == "") { // Tratamento caso a Idade não tenha sido preenchida
                mensagem.text = "Idade não preenchida"
                mensagem.setTextColor(Color.RED)
            }else{
                idadeBotao = Integer.parseInt(idade.text.toString()) // Converte o valor do campo para um int
                nascimento = 2020 - idadeBotao // Faz o calculo do ano de nascimento da pessoa(com base em não ter feito aniversario em 2021 ainda)
                if (nome == "" || sobrenome == "" || endereco == "") { // Tratamento de Erro caso algum campo não tenha sido preenchido
                    mensagem.text = "Um ou mais campos acima está vazio"
                    mensagem.setTextColor(Color.RED)
                } else {
                    mensagem.text = "Usuário Registrado com Sucesso!\nBem vindo(a) $nome $sobrenome!" +
                            "\nAno de Nascimento: $nascimento\nReside em: $endereco"
                    mensagem.setTextColor(Color.BLUE)
                }
            }
        }
    }
}