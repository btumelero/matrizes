/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

/**
 * Depois de lida as matrizes, o método multiplicacao() faz a multiplicação das matrizes se o método multiplicacao(que checa se as matrizes possuem o tamanho correto para realizar a operação) retornar verdadeiro
 * @author Bruno
 */
public class Multiplicacao {
  
  /**
   *
   * @param leitura classe leitura
   */
  public void multiplicacao(Leitura leitura) {
    boolean terminou=false;
    do {
      if (leitura.multiplicacao()==true) { //se em A[m][p] e B[p][n] p==p então é possível realizar
        int i, j, k;                       //a operação e a matriz resultante será C[m][n]
        i=leitura.getMatriz1().size();       //m
        j=leitura.getMatriz2().get(0).size();//n
        k=leitura.getMatriz1().get(0).size();//p
        double[][] matriz3 = new double[i][j];
        System.out.println("Matriz Resultante:");
        for (int m=0; m<i; m++) {     //controla a linha
          for (int c=0; c<j; c++) {   //controla a coluna
            for (int l=0; l<k; l++) { //controla aonde está sendo feita as multiplicações
              matriz3[m][c] = matriz3[m][c] + (leitura.getMatriz1().get(m).get(l) * leitura.getMatriz2().get(m).get(c));
            }
            System.out.print(matriz3[m][c] + " ");
          }
          System.out.println();
        }
        terminou=true;
      }
      else {
        while (leitura.multiplicacao()==false){ //se não for possível multiplicar
          System.out.println("O número de colunas da primeira matriz deve ser igual ao de linhas da segunda para que possa ser possível fazer essa operação, por favor tente novamente.");
          leitura = new Leitura();
          leitura.leitura(2);
        }
      }
    } while (terminou==false);
  }
}
