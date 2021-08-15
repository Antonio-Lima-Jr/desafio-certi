package br.com.antonio.api.services.exceptions;

/**
 * Exceção lançada caso um número esteja fora do limiar permitido.
 *
 * @author Antônio Lima Jr
 */
public class NumOutOfRangeException extends RuntimeException {
  public NumOutOfRangeException(String message) {
    super(message);
  }
}
