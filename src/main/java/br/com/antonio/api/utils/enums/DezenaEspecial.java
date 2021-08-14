package br.com.antonio.api.utils.enums;

/**
 * Enum da DezenaEspecial.
 *
 * @author Antônio Lima Jr
 */
public enum DezenaEspecial {
  DEZ("dez"), ONZE("onze"), DOZE("doze"), TREZE("treze"),
  QUATORZE("quatorze"), QUINZE("quinze"), DEZESSEIS("dezesseis"),
  DEZESSETE("dezessete"), DEZOITO("dezoito"), DEZENOVE("dezenove");

  private final String numToString;

  DezenaEspecial(String valor) {
    this.numToString = valor;
  }

  public String getNumToString() {
    return numToString;
  }
}
