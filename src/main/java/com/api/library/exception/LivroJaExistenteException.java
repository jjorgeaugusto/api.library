package com.api.library.exception;

public class LivroJaExistenteException extends RuntimeException{
    public LivroJaExistenteException(String mensagem){
        super(mensagem);
    }
}
