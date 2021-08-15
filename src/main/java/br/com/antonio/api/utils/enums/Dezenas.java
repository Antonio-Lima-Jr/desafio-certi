package br.com.antonio.api.utils.enums;

/**
 * Enum das dezenas.
 *
 * @author Antônio Lima Jr
 */
public enum Dezenas {
  DEZ("dez"), VINTE("vinte"), TRINTA("trinta"),
  QUARENTA("quarenta"), CINQUENTA("cinquenta"),
  SESSENTA("sessenta"), SETENTA("setenta"),
  OITENTA("oitenta"), NOVENTA("noventa");

  private final String numToString;

  Dezenas(String valor) {
    this.numToString = valor;
  }

  public String getNumToString() {
    return numToString;
  }
}
