package br.com.antonio.api.utils.enums;

/**
 * Padroniza as casas decimais.
 *
 * @author Antônio Lima Jr
 */
public enum CasasDecimais {
  DEZMILHAR(0), CENTENA(1), DEZENA(2), UNIDADE(3);


  private final int numToString;

  CasasDecimais(int valor) {
    this.numToString = valor;
  }

  public int getNumToString() {
    return numToString;
  }
}
