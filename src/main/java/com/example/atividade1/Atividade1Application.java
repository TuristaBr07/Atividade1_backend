package com.example.atividade1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade1.models.Aluno;
import com.example.atividade1.models.Curso;
import com.example.atividade1.repositories.AlunoRepository;
import com.example.atividade1.repositories.CursoRepository;

@SpringBootApplication
public class Atividade1Application {

    @Bean
    public CommandLineRunner init(
            @Autowired CursoRepository cursoRepository,
            @Autowired AlunoRepository alunoRepository) {
        return args -> {
            
            // 1. Inserir 2 cursos
            Curso curso1 = cursoRepository.inserir(new Curso(null, "Engenharia de Software"));
            Curso curso2 = cursoRepository.inserir(new Curso(null, "Ciência de Dados"));

            // 2. Inserir 2 alunos, vinculando-os aos cursos
            alunoRepository.inserir(new Aluno(null, "João Silva", 2026, curso1));
            alunoRepository.inserir(new Aluno(null, "Maria Oliveira", 2026, curso2));

            // 3. Exibir todos os cursos
            System.out.println("--- CURSOS INSERIDOS ---");
            List<Curso> cursos = cursoRepository.selecionarTodos();
            cursos.forEach(System.out::println);

            // 4. Exibir todos os alunos
            System.out.println("--- ALUNOS INSERIDOS ---");
            List<Aluno> alunos = alunoRepository.selecionarTodos();
            alunos.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Atividade1Application.class, args);
    }
}