package com.API.library.dto;

import com.API.library.entity.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(@NotNull Long id, String nome, String autor, Status status) {

}
