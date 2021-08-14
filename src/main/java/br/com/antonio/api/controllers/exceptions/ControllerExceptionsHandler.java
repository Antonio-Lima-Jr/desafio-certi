package br.com.antonio.api.controllers.exceptions;

import br.com.antonio.api.controllers.exceptions.responses.StandardError;
import br.com.antonio.api.services.exceptions.NumOutOfRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Recebe captura os erros do sistema e retorna uma resposta personalizada.
 *
 * @author Antônio Lima Jr
 */
@ControllerAdvice
public class ControllerExceptionsHandler {
  @ExceptionHandler(NumOutOfRangeException.class)
  public ResponseEntity<StandardError> entityNotFound(NumOutOfRangeException e, HttpServletRequest request) {
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setError("Número recebido fora do conjunto aceito");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
}