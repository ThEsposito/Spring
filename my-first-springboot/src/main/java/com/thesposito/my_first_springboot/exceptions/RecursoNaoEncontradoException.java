package com.thesposito.my_first_springboot.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }


}
