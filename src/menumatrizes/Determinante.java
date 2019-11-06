/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

/**
 * Depois de lida as matrizes, o método determinante() faz o determinante da matriz se o método determinante(que checa se a matriz é quadrada) retornar verdadeiro
 * @author Bruno
 */
public class Determinante {
  
  /**
   *
   * @param leitura classe leitura
   */
  public void determinante(Leitura leitura) {
    double det;
    boolean terminou=false;
    do {
      int l=leitura.getMatriz1().size();
      int c=leitura.getMatriz1().get(0).size();
      if (leitura.determinante()==true && (l==1 || l==2 || l==3)) { //só é possível se for quadrada e de ordem 1, 2 ou 3
        if (l==1) {//se a matriz for 1x1
          det = leitura.getMatriz1().get(0).get(0);
          System.out.println("O determinante da matriz é: " + det);
        }
        if (l==2) {//se a matriz for de 2x2
          det = (leitura.getMatriz1().get(0).get(0) * leitura.getMatriz1().get(1).get(1));
          det = det - (leitura.getMatriz1().get(0).get(1) * leitura.getMatriz1().get(1).get(0));
          System.out.println("O determinante da matriz é: " + det);
        }
        if (l==3) {//se a matriz for de 3x3 // regra de Sarrus
          det = leitura.getMatriz1().get(0).get(0)*leitura.getMatriz1().get(1).get(1)*leitura.getMatriz1().get(2).get(2)+leitura.getMatriz1().get(0).get(1)*leitura.getMatriz1().get(1).get(2)*leitura.getMatriz1().get(2).get(0)+leitura.getMatriz1().get(0).get(2)*leitura.getMatriz1().get(1).get(0)*leitura.getMatriz1().get(2).get(1);
          det = det - (leitura.getMatriz1().get(0).get(2)*leitura.getMatriz1().get(1).get(1)*leitura.getMatriz1().get(2).get(0)+leitura.getMatriz1().get(0).get(0)*leitura.getMatriz1().get(1).get(2)*leitura.getMatriz1().get(2).get(1)+leitura.getMatriz1().get(0).get(1)*leitura.getMatriz1().get(1).get(0)*leitura.getMatriz1().get(2).get(2));
          System.out.println("O determinante da matriz é: " + det);
        }
        terminou=true;
      }
      else {
        while (leitura.determinante()==false || (l<1 || l>3) || (c<1 || c>3)) { //se não for quadrada ou de orderm 1, 2 ou 3
          System.out.println("Esta operação só está disponível para matrizes quadradas e de 1x1, 2x2 ou 3x3");
          leitura = new Leitura();
          leitura.leitura(1);
        }
      }
    } while (terminou==false);
  }
}
