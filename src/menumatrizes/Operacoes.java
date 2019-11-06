/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

import java.util.Scanner;

/**
 * Depois do Menu, o método operacoes() pergunta ao usuário qual operação realizar
 * @author bruno.191196
 */
public class Operacoes {
  Scanner scan = new Scanner(System.in);
  Leitura leitura;                //
  Adicao adicao;                  //
  Subtracao subtracao;            //pra poder usar essas
  Escalar escalar;                //classes aqui em operações
  Determinante determinante;      //
  Multiplicacao multiplicacao;    //
  private int op, continuar;

  /**
   *
   * @return o resultado de continua()
   */
  public boolean operacoes() {
    leitura = new Leitura();//pra resetar todos os valores armazenados
    op = scan.nextInt();
    if (op<1 || op>5) { //entrada inválida
      System.out.println("\nSó há operações de 1 até 5, tente novamente.\n");
      return true;
    } 
    else {
      if (op==1) { //Adição
        adicao = new Adicao(); 
        System.out.println("\nLembre-se que as matrizes devem ter tamanhos iguais.");
        leitura.leitura(2);
        adicao.adicao(leitura);
        return continua();
      }
      else {
        if (op==2) { //Subtração
          subtracao = new Subtracao(); 
          System.out.println("\nLembre-se que as matrizes devem ter tamanhos iguais.");
          leitura.leitura(2);
          subtracao.subtracao(leitura);
          return continua();
        }
        else {
          if (op==3) { //Escalar
            escalar = new Escalar(); 
            System.out.println("\nA matriz pode ter qualquer tamanho neste caso.");
            leitura.leitura(1);
            escalar.escalar(leitura);
            return continua();
          }
          else {
            if (op==4) { //Multiplicação
              multiplicacao = new Multiplicacao();
              System.out.println("\nLembre-se que o número de colunas da primeira matriz deve ser igual ao de linhas da segunda.");
              leitura.leitura(2);
              multiplicacao.multiplicacao(leitura);
              return continua();
            }
            else { //Determinantes
              determinante = new Determinante();
              System.out.println("\nLembre-se que somente matrizes quadradas são permitidas.");
              leitura.leitura(1);
              determinante.determinante(leitura);
              return continua();
            }
          }
        }
      }
    }
  }
  
  /**
   *
   * @return verdadeiro se o usuário digitar 1
   */
  public boolean continua() { //retorna verdadeiro se o usuário quer continuar a executar o programa
    System.out.println("\nDigite 1 para continuar realizando operações");
    continuar = scan.nextInt();
    System.out.println();
    if (continuar==1) {
      return true;
    }
    else {
      return false;
    }
  }
}
