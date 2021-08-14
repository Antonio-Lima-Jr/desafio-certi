package br.com.antonio.api.services;

import br.com.antonio.api.dtos.Extenso;
import br.com.antonio.api.services.exceptions.NumOutOfRangeException;
import org.springframework.stereotype.Service;

/**
 * Service utilizado para verificar erros e chamar a lógica de conversão.
 *
 * @author Antônio Lima Jr
 */
@Service
public class NumberToString {
  public Extenso conversionNumber(Integer num) {
    if (num > 99999 || num < -99999) {
      throw new NumOutOfRangeException("O numero deve estar entre -99999 e 99999 mas recebemos o valor " + num);
    }
    return new Extenso("numPorExtenso");
  }
}
