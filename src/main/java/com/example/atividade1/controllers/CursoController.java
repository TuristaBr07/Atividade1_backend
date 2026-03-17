package com.example.atividade1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.atividade1.models.Curso;
import com.example.atividade1.repositories.CursoRepository;

// @RestController diz que esta classe atende requisições web (HTTP)
@RestController
public class CursoController {

    // Injetamos o repositório para podermos acessar o banco
    @Autowired
    private CursoRepository cursoRepository;

    // Mapeia o verbo POST para a rota "/cursos". O @RequestBody transforma o JSON recebido em um objeto Java
    @PostMapping("/cursos")
    public Curso inserir(@RequestBody Curso curso) {
        return cursoRepository.inserir(curso);
    }

    // Mapeia o verbo GET para a rota "/cursos"
    @GetMapping("/cursos")
    public List<Curso> mostrarTodos() {
        return cursoRepository.selecionarTodos();
    }
}