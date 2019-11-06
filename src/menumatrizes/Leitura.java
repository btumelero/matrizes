/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menumatrizes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Depois do usuário escolher a operação, o método leitura() lê a quantidade de matrizes necessária de acordo com a operação escolhida
 * @author Bruno
 */
public class Leitura {
  Scanner scan = new Scanner(System.in);
  
  private ArrayList<ArrayList<Double>> matriz1 = new ArrayList<>();//Matrizes dinâmicas que serão
  private ArrayList<ArrayList<Double>> matriz2 = new ArrayList<>();//usadas nas operações
  
  /**
   *
   * @param numeroMatrizes número de matrizes necessário para realizar as operações
   */
  public void leitura(int numeroMatrizes) {
    //inicializando elas aqui porque só precisam existir aqui dentro********************************
    String entrada;
    boolean terminou, proximaLinha, entradaInvalida;
    double numero;
    int colunas, linhas, cont=0;
    //início dos códigos****************************************************************************
    System.out.println("\nÉ obrigatório pelo menos um número por linha;");
    System.out.println("Digite ';' para ir para a próxima linha(você já precisa ter digitado pelo menos um número e só é necessário quebrar a linha uma vez);");
    System.out.println("Digite '.' para parar de inserir números nesta matriz(você já precisa ter digitado pelo menos um número.)");
    System.out.println("Digite ',' para resetar o progresso da linha atual.");
    System.out.println("(Se você já tiver completado uma linha e não completar a próxima, o progresso desta linha será perdido,");
    System.out.println(" resultando em um reset na linha caso ';' ou parando de ler caso '.')\n");
    for (int m=1; m<=numeroMatrizes; m++) { //alterna a leitura entre as duas matrizes de entrada, se houver mais que uma
      ArrayList<Double> linha = new ArrayList<>();//
      terminou=false;                             //essas aqui precisam ser resetadas 
      linhas=0;                                   //depois que cada matriz é lida
      colunas=0;                                  //
      System.out.println("Você está inserindo números na " + m + "ª matriz.");
      while (terminou==false) { //termina quando o usuário digita ponto
        entradaInvalida=false;//
        proximaLinha=false;   //essas duas precisam ser resetadas a cada loop do while
        System.out.println("\nDigite o número a ser adicionado na matriz:");
        entrada = scan.next();
        if (",".equals(entrada)==true) { //reseta a linha //esse comando .equals é a mesma coisa que entrada==";"
          System.out.println("\nVocê resetou esta linha.");
          cont=0;
          linha.clear(); //esse comando .clear limpa a linha da matriz
          entradaInvalida=true;
        }
        if (".".equals(entrada)==true) { //para de ler
          if (colunas==0) {
            colunas=cont;
          }
          if (linha.isEmpty()==true && linhas==0) { //só pode parar de digitar se já tiver digitado um número //esse comando .isEmpty verifica se a linha está vazia
            System.out.println("\nVocê já precisa ter digitado um número para parar de inserir números.");
            entradaInvalida=true;
          }
          else {
            terminou=true;
            System.out.println("\nVocê interrompeu a inserção de números nesta matriz.\n");
            if (colunas==cont) { //adiciona na matriz se tiver completado a linha e para de ler
              linhas++;
              if (m==1) {
                matriz1.add(linha);  //esse comando .add adiciona a linha na matriz
              }
              else {
                matriz2.add(linha);
              }
            }
            else { //apaga a linha se não estiver completa e para de ler
              linha.clear();
            }
          }
          cont=0;
        }
        if (terminou==false && entradaInvalida==false) { //só continua a checar se o usuário não digitou alguma coisa errada ou ponto
          if (";".equals(entrada)==true) { //quebra a linha, só precisa quebrar uma vez por matriz
            if (linhas==0) {
              if (linha.isEmpty()==true && linhas==0) {//só pode parar de digitar se já tiver digitado um número
                System.out.println("\nVocê já precisa ter digitado um número para ir para a próxima linha.");
                entradaInvalida=true;
              }
              else { //adiciona na matriz se tiver completado a linha e vai pra próxima
                System.out.println("\nVocê interrompeu a inserção de números nesta linha");
                System.out.println("\n******************************ATENÇÃO******************************");
                System.out.println("NOVAS LINHAS SERÃO INICIADAS AUTOMATICAMENTE DEPOIS DO PRIMEIRO ';'");
                System.out.println("******************************ATENÇÃO******************************\n");
                colunas=cont;
                cont=0;
                linhas++;
                proximaLinha=true;
                if (m==1) {
                  matriz1.add(linha);
                }
                else {
                  matriz2.add(linha);
                }
                linha = new ArrayList<>(); //isso cria uma nova linha
              }
            }
            else {//reseta a linha se ela não estiver completa
              System.out.println("\nVocê interrompeu a inserção de números nesta linha");
              cont=0;
              linha.clear();
              proximaLinha=true;
            }
          }
          if (proximaLinha==false && entradaInvalida==false) { //só continua a checar se o usuário não digitou alguma coisa errada ou ponto e vírgula
            for (int i = 0; i < entrada.length() && entradaInvalida==false; i++) { //esse comando .lenght significa por todo o tamanho do array
              if (Character.isDigit(entrada.charAt(i))==false) { //não é um numero, entrada inválida // esse comando .isDigit verifica se é um número
                System.out.println("\nApenas números, ',', ';' ou '.' são entradas válidas. Por favor tente novamente.");
                entradaInvalida=true;
              }
            }
            if (entradaInvalida==false) { //só converte se for número
              numero=Double.parseDouble(entrada); //esse comando .parse transforma string em alguma coisa, no caso double // poderia ser Integer.parseInt por exemplo
              linha.add(numero);
              cont++;
            }
          }
        }
        if (colunas==cont && colunas!=0) { //quebra automaticamente a linha depois da primeira vez que o usuário digitou ponto e vírgula
          System.out.println("\nA inserção de números foi automaticamente direcionada para a próxima linha");
          linhas++;
          cont=0;
          if (m==1) {
            matriz1.add(linha);
          }
          else {
            matriz2.add(linha);
          }
          linha = new ArrayList<>();
        }
      }
    }
  }
  
  /**
   *
   * @return verdadeiro se as matrizes tiverem tamanhos iguais
   */
  public boolean somaSubtracao() { //retorna verdadeiro se as matrizes tiverem tamanhos iguais
    if (matriz1.size()==matriz2.size() && matriz1.get(0).size()==matriz2.get(0).size()) { 
      return true;    //esse comando .size serve pra achar o tamanho do array
    }                 //antes do && eu estou comparando a quantidade de linhas
    else {            //e depois do && aquele comando .get vai na primeira linha(primeiro array)
      return false;   //e vê a quantidade de colunas dela e compara com a outra matriz
    }
  }
  
  /**
   *
   * @return verdadeiro se a matriz for quadrada
   */
  public boolean determinante() { //retorna verdadeiro se a matriz for quadrada
    if (matriz1.size()==matriz1.get(0).size()) {
      return true;
    }
    else {
      return false;
    }
  }
    
  /**
   *
   * @return verdadeiro se é possível fazer a multiplicação entre as duas matrizes
   */
  public boolean multiplicacao() { //retorna verdadeiro se é possível fazer a multiplicação entre as duas matrizes
    if (matriz1.get(0).size()==matriz2.size()) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   *
   * @return matriz1
   */
  public ArrayList<ArrayList<Double>> getMatriz1(){
    return matriz1;
  }
  
  /**
   *
   * @return matriz2
   */
  public ArrayList<ArrayList<Double>> getMatriz2(){
    return matriz2;
  }
}
