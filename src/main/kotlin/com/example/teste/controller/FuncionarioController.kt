package com.example.teste.controller

import com.example.teste.model.Funcionario
import com.example.teste.repository.FuncionarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/funcionarios")
class FuncionarioController(private val funcionarioRepository: FuncionarioRepository){

    @PostMapping
    fun cadastrarFuncionario(@RequestBody funcionario: Funcionario):Any{
        funcionarioRepository.save(funcionario)
        return ResponseEntity.ok().body(funcionario)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long):ResponseEntity<Any>{

        val funcionarioBuscado = funcionarioRepository.findById(id).orElse(null)

        if(funcionarioBuscado != null){
            return ResponseEntity.ok().body(funcionarioBuscado)
        }
        return ResponseEntity.notFound().build()
    }

    //This method should delete a specific Funcionario by id
    @DeleteMapping("/{id}")
    fun deletarFuncionario(@PathVariable id: Long):ResponseEntity<Any>{

        val funcionarioBuscado = funcionarioRepository.findById(id).orElse(null)

        if(funcionarioBuscado != null){
            funcionarioRepository.delete(funcionarioBuscado)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }

    //This method should return all Funcionarios
    @GetMapping
    fun listarFuncionarios():ResponseEntity<Any>{

        val funcionarios = funcionarioRepository.findAll()

        if(funcionarios.isNotEmpty()){
            return ResponseEntity.ok().body(funcionarios)
        }
        return ResponseEntity.notFound().build()
    }

}