package com.example.atividade1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_alunos") 
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nome;

    private Integer anoIngresso;

    // Relacionamento N:1 (Vários alunos pertencem a Um curso)
    @ManyToOne
    // @JoinColumn cria a coluna de chave estrangeira (FK) no banco. 
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, Integer anoIngresso, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.curso = curso;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(Integer anoIngresso) { this.anoIngresso = anoIngresso; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    @Override
    public String toString() {
        
        return "Aluno [id=" + id + ", nome=" + nome + ", anoIngresso=" + anoIngresso + 
               ", curso=" + (curso != null ? curso.getNome() : "Nenhum") + "]";
    }
}