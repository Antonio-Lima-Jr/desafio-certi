package br.com.antonio.api.utils;


import br.com.antonio.api.utils.enums.*;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Receber um número inteiro no construtor e construir uma ‘string’ por extenso.
 *
 * @author Antônio Lima Jr
 */
@Data
@Component
public class ConversorExtenso implements IConversorExtenso {
  private String valueToString;

  private int dezMilhar;
  private int centenas;
  private int dezenas;
  private int unidades;

  /**
   * Chama os métodos para converter em ‘string’ cada casa decimal.
   *
   * @return o numero inteiro por extenso
   */
  @Override
  public String convertToString(int valorRecebido) {
    this.qntCasasDecimais(valorRecebido);
    this.buildDezMilhar();
    this.buildCentenas();
    this.buildDezenas();
    this.buildUnidades();
    return valueToString;
  }

  /**
   * Inicializa ‘string’ com "menos" se for menor que zero
   * e chama o método qntCasas para contabilizar a quantidade
   * de dezenas de milhares, centenas, dezenas, unidades.
   *
   * @param valorRecebido valor inteiro que deve ser escrito por extenso
   */
  public void qntCasasDecimais(int valorRecebido) {
    this.valueToString = "";
    if (valorRecebido < 0) {
      valueToString += "menos ";
      valorRecebido = valorRecebido * -1;
    }
    this.qntCasas(valorRecebido);
  }

  /**
   * Faz a divisão e recupera a quantidade das dezenas de milhares, centenas, dezenas e unidades.
   *
   * @param valorRecebido número que deve ser escrito por extenso.
   */
  private void qntCasas(int valorRecebido) {
    this.dezMilhar = valorRecebido / 1000;
    valorRecebido -= this.dezMilhar * 1000;
    this.centenas = valorRecebido / 100;
    valorRecebido -= this.centenas * 100;
    this.dezenas = valorRecebido / 10;
    valorRecebido -= this.dezenas * 10;
    this.unidades = valorRecebido;
  }

  /**
   * Verifica quantas dezenas ou unidades de milhar existe no inteiro em questão
   * e recupera do enum a ‘string’ correspondente.
   */
  private void buildDezMilhar() {
    if (this.dezMilhar > 0) {
      //  Constrói a string entre mil e 9 mil
      if ((this.dezMilhar / 10) < 1) {
        if (this.dezMilhar == 1) {
          valueToString += "mil";
          valueToString += this.conjuncao(CasasDecimais.DEZMILHAR);
        } else {
          valueToString += Unidades.values()[this.dezMilhar - 1].getNumToString() + " mil";
          valueToString += this.conjuncao(CasasDecimais.DEZMILHAR);
        }
      }
      //  Constrói a string entre 10 mil e 19 mil
      else if ((this.dezMilhar / 10) < 2) {
        valueToString += DezenaEspecial.values()[(this.dezMilhar - 10)].getNumToString() + " mil";
        valueToString += this.conjuncao(CasasDecimais.DEZMILHAR);
      }
      //  Constrói a ‘string’ se a sua divisão por 10 diferir de 0, exemplos: 23, 35, 47, 59, 77, 82, 94
      else if ((this.dezMilhar % 10) != 0) {
        valueToString += Dezenas.values()[(this.dezMilhar / 10) - 1].getNumToString();
        valueToString += this.conjuncao();
        valueToString += Unidades.values()[(this.dezMilhar - (this.dezMilhar / 10 * 10)) - 1].getNumToString() + " mil";
        valueToString += this.conjuncao(CasasDecimais.DEZMILHAR);
      }
      //  Constrói a string se sua divisão por 10 for igual a 0, exemplos: 20, 30, 40, 50, 60, 70, 80, 90
      else {
        valueToString += Dezenas.values()[(this.dezMilhar / 10) - 1].getNumToString() + " mil";
        valueToString += this.conjuncao(CasasDecimais.DEZMILHAR);
      }
    }
  }

  /**
   * Constrói a ‘string’ para a casa das centenas.
   */
  private void buildCentenas() {
    if (centenas == 1 && dezenas == 0 && unidades == 0) {
      valueToString += "cem";
    } else if (centenas > 0) {
      valueToString += Centenas.values()[centenas - 1].getNumToString();
      valueToString += this.conjuncao(CasasDecimais.CENTENA);
    }
  }

  /**
   * Constrói a string para a casa das dezenas.
   */
  private void buildDezenas() {
    if (dezenas == 1) {
      valueToString += DezenaEspecial.values()[unidades].getNumToString();
    } else if (dezenas > 0) {
      valueToString += Dezenas.values()[dezenas - 1].getNumToString();
      valueToString += this.conjuncao(CasasDecimais.DEZENA);
    }
  }

  /**
   * Constrói a ‘string’ para a casa das unidades.
   */
  private void buildUnidades() {
    if (dezenas != 1) {
      if (unidades > 0) {
        valueToString += Unidades.values()[unidades - 1].getNumToString();
      } else if (unidades == 0 && dezMilhar == 0 && centenas == 0 && dezenas == 0) {
        valueToString += "zero";
      }
    }
  }

  /**
   * Verifica se existem números a ser escritos por extenso após a casa que esta sendo verificada
   *
   * @param casaAtual é a casa atual que esta chamando a conjunção.
   * @return retorna um " e " se existir casas menores que vão ser escritas por extenso,
   * caso não exista mais casas que devem ser convertidas retorna uma ‘string’ vazia.
   */
  private String conjuncao(CasasDecimais casaAtual) {
    if (casaAtual == CasasDecimais.DEZMILHAR) {
      if (this.centenas > 0 || this.dezenas > 0 || this.unidades > 0) {
        return " e ";
      }
    } else if (casaAtual == CasasDecimais.CENTENA) {
      if (this.dezenas > 0 || this.unidades > 0) {
        return " e ";
      }
    } else if (casaAtual == CasasDecimais.DEZENA) {
      if (this.unidades > 0) {
        return " e ";
      }
    }
    return "";
  }

  /**
   * @return retorna sempre a conjunção" e ".
   */
  private String conjuncao() {
    return " e ";
  }
}
