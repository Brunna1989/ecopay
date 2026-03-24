package com.ecopay.ecopay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> tratarErroDeArgumento(IllegalArgumentException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "erro", ex.getMessage(),
                        "status", HttpStatus.BAD_REQUEST.value(),
                        "data", LocalDateTime.now()
                ));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> tratarRuntimeException(RuntimeException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "erro", ex.getMessage(),
                        "status", HttpStatus.NOT_FOUND.value(),
                        "data", LocalDateTime.now()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> tratarErroGenerico(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "erro", "Erro interno no servidor",
                        "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "data", LocalDateTime.now()
                ));
    }
}