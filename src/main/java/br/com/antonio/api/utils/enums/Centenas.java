package br.com.antonio.api.utils.enums;

/**
 * Enum das centenas.
 *
 * @author Antônio Lima Jr
 */
public enum Centenas {
  CENTO("cento"), DUZENTOS("duzentos"), TREZENTOS("trezentos"),
  QUATROCENTOS("quatrocentos"), QUINHENTOS("quinhentos"),
  SEISCENTOS("seiscentos"), SETECENTOS("setecentos"),
  OITOCENTOS("oitocentos"), NOVECENTOS("novecentos");

  private final String numToString;

  Centenas(String valor) {
    this.numToString = valor;
  }

  public String getNumToString() {
    return numToString;
  }
}
