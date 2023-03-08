package com.api.library.dto;

import com.api.library.entity.Status;

public record DadosCadastroLivro(String nome, String autor, Status status) {

    public DadosCadastroLivro(String nome, String autor, Status status) {
     this.status = Status.DISPONIVEL;
        this.nome = nome;
        this.autor = autor;
    }
}
