package br.com.antonio.api.utils.enums;

/**
 * Enum das unidades.
 *
 * @author Antônio Lima Jr
 */
public enum Unidades {
  UM("um"), DOIS("dois"), TRES("três"), QUATRO("quatro"),
  CINCO("cinco"), SEIS("seis"), SETE("sete"), OITO("oito"),
  NOVE("nove");

  private final String numToString;

  Unidades(String valor) {
    this.numToString = valor;
  }

  public String getNumToString() {
    return numToString;
  }
}
