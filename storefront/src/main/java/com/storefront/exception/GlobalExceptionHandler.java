package com.storefront.exception;

import feign.FeignException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Map<String, Object>> handleFeighException(FeignException ex){
        Map<String, Object> erro = new HashMap<>();
        erro.put("status", ex.status());
        erro.put("message", "Erro ao comunicar com o serviço de Warehouse: " + ex.getMessage());
        return ResponseEntity.status(ex.status()).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.BAD_REQUEST.value());
        error.put("message", "Violação de integridade dos dados. Verifique os campos enviados.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException ex){
        Map<String, Object> erro = new HashMap<>();
        erro.put("status", HttpStatus.BAD_REQUEST.value());
        erro.put("message", "Erro de validação nos campos enviados.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handRuntime(RuntimeException ex){
        Map<String, Object> erro = new HashMap<>();
        erro.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        erro.put("message", "Erro de validação nos campos enviados.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

}
