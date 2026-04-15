package com.thesposito.my_first_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    Com isso, qualquer recurso não encontrado ou exceção genérica vai ser capturada automaticamente, e retornado com
    um Json amigável e status code adequado.

    O uso de @ControllerAdvice permite tratar exceções de toda a aplicação em um único lugar ao invés de
    repetir try catch em todo canto
*/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException e) {
        Map<String, Object> bodyMap = new LinkedHashMap<>();

        bodyMap.put("timestamp", LocalDateTime.now());
        bodyMap.put("status", HttpStatus.NOT_FOUND.value());
        bodyMap.put("error", "Recurso não encontrado");
        bodyMap.put("message", e.getMessage());

        return new ResponseEntity<>(bodyMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(RecursoNaoEncontradoException e) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Erro interno do servidor");
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
