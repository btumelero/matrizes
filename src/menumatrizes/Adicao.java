/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

/**
 * Depois de lida as matrizes, o método adicao() faz a soma das matrizes se o método somaSubtracao(que checa se as matrizes possuem o mesmo tamanho) retornar verdadeiro
 * @author Bruno
 */
public class Adicao {

  /**
   * 
   * @param leitura classe leitura
   */
  public void adicao(Leitura leitura) {
    boolean terminou=false;
    do {
      if (leitura.somaSubtracao()==true) { //se as matrizes forem de tamanhos iguais
        int i, j;
        i=leitura.getMatriz1().size();
        j=leitura.getMatriz1().get(0).size();
        double[][] matriz3 = new double[i][j];
        
        System.out.println("Matriz Resultante:");
        for (int l=0; l<i; l++){
          for (int c=0; c<j; c++){
            matriz3[l][c]= leitura.getMatriz2().get(l).get(c) + leitura.getMatriz1().get(l).get(c);
            System.out.print(matriz3[l][c] + " ");
          }
          System.out.println();
        }
        terminou=true;
      }
      else {
        while (leitura.somaSubtracao()==false){ //se forem de tamanhos diferentes
          System.out.println("As matrizes precisam ter tamanhos iguais para que possa ser possível fazer essa operação, por favor tente novamente");
          leitura = new Leitura();
          leitura.leitura(2);
        }
      }
    } while (terminou==false);
  }
}
