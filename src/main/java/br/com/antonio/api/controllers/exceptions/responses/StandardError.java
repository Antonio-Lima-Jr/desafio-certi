package br.com.antonio.api.controllers.exceptions.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * Padrão de resposta quando for capturada uma exceção.
 *
 * @author Antônio Lima Jr
 */
@Getter
@Setter
@NoArgsConstructor
public class StandardError implements Serializable {
  private static final long serialVersionUID = 1L;

  private Instant timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;
}
