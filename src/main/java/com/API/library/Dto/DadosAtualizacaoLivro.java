package com.API.library.Dto;

import com.API.library.Entity.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(@NotNull Long id, String nome, String autor, Status status) {

}
