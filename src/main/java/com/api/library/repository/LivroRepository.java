package com.api.library.repository;

import com.api.library.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByNome(String nome);

    boolean existsByNome(String nome);
}
