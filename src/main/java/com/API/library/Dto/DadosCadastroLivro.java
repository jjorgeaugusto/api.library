package com.API.library.Dto;

import com.API.library.Entity.Status;

public record DadosCadastroLivro(String nome, String autor, Status status) {
    public DadosCadastroLivro(String nome, String autor, Status status) {
     this.status = Status.DISPONIVEL;
        this.nome = nome;
        this.autor = autor;
    }
}
