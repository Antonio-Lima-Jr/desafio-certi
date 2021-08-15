package br.com.antonio.api.services;

import br.com.antonio.api.services.exceptions.NumOutOfRangeException;
import br.com.antonio.api.utils.ConversorExtenso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teste do Serviço number to string.
 *
 * @author Antônio Lima Jr
 */
@ExtendWith(MockitoExtension.class)
class NumberToStringTest {

  @InjectMocks
  private NumberToString numberToString;

  @Mock
  private ConversorExtenso conversor;

  @Test
  void conversaoNumeroForaDaEspecificacao_TestarExcecao() {
    int num1 = 100000;
    int num2 = -100000;

    try {
      numberToString.conversionNumber(num1);
    } catch (NumOutOfRangeException ex) {
      assertEquals("O numero deve estar entre -99999 e 99999 mas recebemos o valor " + num1, ex.getMessage());
    }
    try {
      numberToString.conversionNumber(num2);
    } catch (NumOutOfRangeException ex) {
      assertEquals("O numero deve estar entre -99999 e 99999 mas recebemos o valor " + num2, ex.getMessage());
    }
  }

  @Test
  void testConversao_TestarNumeroPorExtenso() {
    int valor1 = 1954;
    String valorEsperado1 = "mil e novecentos e cinquenta e quatro";
    int valor2 = -1543;
    String valorEsperado2 = "menos mil e quinhentos e quarenta e três";

    Mockito.when(this.conversor.convertToString(valor1))
        .thenReturn(valorEsperado1);
    Mockito.when(this.conversor.convertToString(valor2))
        .thenReturn(valorEsperado2);

    assertEquals(numberToString.conversionNumber(valor1).getExtenso(), valorEsperado1);
    assertEquals(numberToString.conversionNumber(valor2).getExtenso(), valorEsperado2);
  }
}