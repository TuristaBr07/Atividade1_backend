package com.example.atividade1.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.atividade1.models.Curso;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

// @Repository indica ao Spring que esta classe gerencia dados
@Repository
public class CursoRepository {

    // @Autowired injeta a dependência do EntityManager automaticamente
    @Autowired
    private EntityManager entityManager;

    // @Transactional é obrigatório para métodos que alteram o banco (inserir, editar, excluir)
    @Transactional
    public Curso inserir(Curso curso) {
        // O método merge insere ou atualiza o registro
        return entityManager.merge(curso);
    }

    @Transactional
    public Curso editar(Curso curso) {
        return entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Integer id) {

        Curso curso = selecionarPorId(id);
        if (curso != null) {
            entityManager.remove(curso);
        }
    }

    public List<Curso> selecionarTodos() {
        // Consulta JPQL buscando todos os cursos
        return entityManager.createQuery("FROM Curso", Curso.class).getResultList();
    }

    public Curso selecionarPorId(Integer id) {
        // O método find busca a entidade exata pela Chave Primária
        return entityManager.find(Curso.class, id);
    }
}