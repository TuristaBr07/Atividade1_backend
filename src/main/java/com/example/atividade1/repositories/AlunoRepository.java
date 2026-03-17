package com.example.atividade1.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.atividade1.models.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    @Transactional
    public Aluno editar(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    @Transactional
    public void excluir(Integer id) {
        Aluno aluno = selecionarPorId(id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }

    public List<Aluno> selecionarTodos() {
        return entityManager.createQuery("FROM Aluno", Aluno.class).getResultList();
    }

    public Aluno selecionarPorId(Integer id) {
        return entityManager.find(Aluno.class, id);
    }
}