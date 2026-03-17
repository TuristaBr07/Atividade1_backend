package com.example.atividade1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// @Entity avisa o Spring/JPA que essa classe vai virar uma tabela no banco
@Entity
@Table(name = "tbl_cursos")
public class Curso {

    // @Id define que este campo é a chave primária (PK)
    @Id
    // @GeneratedValue diz pro banco de dados gerar o ID automaticamente (auto incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @Column define características da coluna. O diagrama pede varchar(100)
    @Column(length = 100)
    private String nome;

    // Navegabilidade Cruzada: Um curso tem Vários alunos (1:N).
    // mappedBy = "curso" aponta para o nome do atributo lá na classe Aluno, garantindo a ligação.
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    // Construtor vazio 
    public Curso() {
    }

    // Construtor com parâmetros para facilitar nossos testes depois
    public Curso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + "]";
    }
}