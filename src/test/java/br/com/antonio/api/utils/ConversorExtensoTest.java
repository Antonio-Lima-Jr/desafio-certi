package br.com.antonio.api.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teste Conversor de números por extenso.
 *
 * @author Antônio Lima Jr
 */
class ConversorExtensoTest {

  @Test
  void qntCasasDecimais_TestaUnidadesDeCadaCasaDecimal() {
    int valor = 9999;
    ConversorExtenso conversorWithEnum = new ConversorExtenso();
    conversorWithEnum.convertToString(valor);
    int valorEsperado = 9;

    assertEquals(conversorWithEnum.getDezMilhar(), valorEsperado);
    assertEquals(conversorWithEnum.getCentenas(), valorEsperado);
    assertEquals(conversorWithEnum.getDezenas(), valorEsperado);
    assertEquals(conversorWithEnum.getUnidades(), valorEsperado);
  }

  @Test
  void getValueToString_TestarNumeroPorExtenso() {
    int valor1 = 99999;
    int valor2 = -8855;
    int valor3 = -15;
    String valorEsperado1 = "noventa e nove mil e novecentos e noventa e nove";
    String valorEsperado2 = "menos oito mil e oitocentos e cinquenta e cinco";
    String valorEsperado3 = "menos quinze";

    assertEquals(new ConversorExtenso().convertToString(valor1), valorEsperado1);
    assertEquals(new ConversorExtenso().convertToString(valor2), valorEsperado2);
    assertEquals(new ConversorExtenso().convertToString(valor3), valorEsperado3);
  }
}