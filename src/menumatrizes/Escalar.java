/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

import java.util.Scanner;

/**
 * Depois de lida as matrizes, o método escalar() pede ao usuário o escalar, verifica se ele é válido e faz a multiplicação da matriz por ele
 * @author Bruno
 */
public class Escalar {
  Scanner scan = new Scanner(System.in);
  
  /**
   *
   * @param leitura classe leitura
   */
  public void escalar(Leitura leitura) {
    boolean entradaInvalida, terminou=false;
    String entrada;
    double escalar=0;
    int i, j;
    i=leitura.getMatriz1().size();
    j=leitura.getMatriz1().get(0).size();
    double[][] matriz3 = new double[i][j];
    
    while (terminou==false) {
      System.out.println("Insira o número que deseja usar para multiplicar os elementos da matriz:");
      entrada = scan.next();
      entradaInvalida=false;
      for (int e = 0; e < entrada.length() && entradaInvalida==false; e++) {
        if (Character.isDigit(entrada.charAt(e))==false) { //não é um numero, entrada inválida
          System.out.println("\nApenas números são entradas válidas. Por favor tente novamente.\n");
          entradaInvalida=true;
        }
      }
      if (entradaInvalida==false) { //converte em double
        escalar=Double.parseDouble(entrada);
        terminou=true;
      }
    }
    System.out.println("\nMatriz Resultante:");
    for (int l=0; l<i; l++){
      for (int c=0; c<j; c++){
        matriz3[l][c]= escalar * leitura.getMatriz1().get(l).get(c);
        System.out.print(matriz3[l][c] + " ");
      }
      System.out.println();
    }
  }
}
