package com.example.teste.model

class FuncionarioSimplificadoDTO {
    lateinit var nome: String

    fun retornaNome(funcionario: Funcionario){
        this.nome = funcionario.nome
    }

}