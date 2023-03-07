package com.API.library.dto;

import com.API.library.entity.Status;

public record DadosCadastroLivro(String nome, String autor, Status status) {

    public DadosCadastroLivro(String nome, String autor, Status status) {
     this.status = Status.DISPONIVEL;
        this.nome = nome;
        this.autor = autor;
    }
}
