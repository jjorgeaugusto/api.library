package com.api.library.dto;

import com.api.library.entity.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(@NotNull Long id, String nome, String autor, Status status) {

}
