/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

/**
 * Menu do Programa
 * @author Bruno
 */
public class MenuMatrizes {

  /**
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Operacoes operacoes = new Operacoes(); //para poder usar a classe operações aqui na main
    do {
      System.out.println("Operações Disponíveis:");
      System.out.println("1-Soma");
      System.out.println("2-Subtração");
      System.out.println("3-Multiplicação por Escalar");
      System.out.println("4-Multiplicação de Matrizes");
      System.out.println("5-Determinante (1x1, 2x2 ou 3x3)");
      System.out.println("\nQual operação deseja realizar?");
    } while(operacoes.operacoes()==true);
  }
}
