package com.API.library.Dto;

import com.API.library.Entity.Livro;
import com.API.library.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;

public record DadosCadastroLivro(String nome) {
    public DadosCadastroLivro {
    }
}
