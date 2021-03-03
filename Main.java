//By Bruno Vicente de Carvalho

import java.util.Scanner;

public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static Comandos comandos = new Comandos();

    public static void main(String[] args) {
        String op = "I";
        while(!op.equalsIgnoreCase("S")){
            System.out.println("***Menu para formação e funções de vetores***");
            System.out.println("1- Insere valores no Vetor informado");
            System.out.println("2- Listar Vetor informado");
            System.out.println("3- Busca por valor dentro do Vetor informado");
            System.out.println("4- Deletar indice especifico do vetor informado");
            System.out.println("5- Inserir valor adicional no array");
            System.out.println("6- Inserir valor adicional com index específico");
            System.out.println("7- Deletar atraves do mesmo valor");
            System.out.println("8- Buscar um valor nos dois vetores");
            System.out.println("S- Sair do programa");
            op = teclado.next();
            switch (op) {
                case "1" -> comandos.insertValues(comandos.retornaArray());
                case "2" -> System.out.println("Vetor :" + comandos.escreveArray(comandos.retornaArray()));
                case "3" -> comandos.searchValueArrayInSequencialOrder(comandos.retornaArray(), -1);
                case "4" -> {
                    System.out.println("Indique o index para delecao");
                    int index = teclado.nextInt();
                    comandos.deleteSpecificIndex(comandos.retornaArray(), index);
                }
                case "5" -> {
                    System.out.println("Valor a ser adicionado:");
                    int value = teclado.nextInt();
                    comandos.insertAnotherValue(comandos.retornaArray(), value);
                }
                case "6" -> comandos.insertSpecificIndex(comandos.retornaArray());
                case "7" -> comandos.deleteByValue(comandos.retornaArray());
                case "8" -> {
                    System.out.println("Digite o valor para buscar nos arrays:");
                    int search = teclado.nextInt();
                    System.out.println("Indexes no vetor A:");
                    comandos.searchValueArrayInSequencialOrder(comandos.vetorA, search);
                    System.out.println("Indexes no vetor B:");
                    comandos.searchValueArrayInSequencialOrder(comandos.vetorB, search);
                }
            }
        }
    }
}
