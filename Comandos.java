import java.util.Arrays;
import java.util.Scanner;

public class Comandos{
    public int[] vetorA = new int[5];
    public int[] vetorB = new int[5];
    public int opcaoVetor;
    public static Scanner teclado = new Scanner(System.in);
    public void insertValues(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Insira o valor:");
            array[i] = teclado.nextInt();
        }
    }

    public void setVetor(int[] array){
        switch (this.opcaoVetor) {
            case 1 -> vetorA = array;
            case 2 -> vetorB = array;
        }
    }

    public void deleteSpecificIndex(int[] array,int ...index){
        for (int i : index){
            if(array.length <= i || i < 0){
                throw new RuntimeException("Valor de index "+ i  + " é invalido");
            }
            int[] novoArray = new int[array.length-1];
            for (int newIndex = 0; newIndex < novoArray.length; newIndex++) {
                if(newIndex < i){
                    novoArray[newIndex] = array[newIndex];
                } else if (i <= newIndex){
                    novoArray[newIndex] = array[newIndex+1];
                }
            }
            setVetor(novoArray);
        }
    }

    public int[] searchValueArrayInSequencialOrder(int[] array, int valueSearch){
        if(valueSearch == -1){
            System.out.println("Insira o valor a ser buscado : ");
            valueSearch = teclado.nextInt();
        }

            int numbersFound = 0;
            int[] indexFounds = new int[0];
            int i = 0;
            for (int valor:
                    array) {
                if(valueSearch == valor){
                    numbersFound++;
                    indexFounds = insertAnotherValue(indexFounds, i);
                }
                i++;
            }
            System.out.println("Total de numeros encontrados: "+ numbersFound);
            System.out.println("Indices dos valores correspondentes encontrados :" +
                    escreveArray(indexFounds));
            return indexFounds;
    }

    public String escreveArray(int[] array){
        return Arrays.toString(array);
    }

    public int[] insertAnotherValue(int[] array, int value){
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i == array.length){
                newArray[i] = value;
            } else{
                newArray[i] = array[i];
            }
        }
        if(Arrays.equals(array, vetorA) || Arrays.equals(array, vetorB)){
            setVetor(newArray);
            return null;
        }
        return newArray;
    }

    public void insertSpecificIndex(int[] array){
        System.out.println("Insira o indice para inserir no array");
        int index = teclado.nextInt();
        if(array.length < index || index < 0){
            throw new RuntimeException("Valor de index invalido");
        }
        int[] novoArray = new int[array.length+1];
        System.out.println("Novo valor :");
        int value = teclado.nextInt();
        for (int i = 0; i < novoArray.length; i++) {
            if(i == index){
                novoArray[i] = value;
            } else if(i > index){
                novoArray[i] = array[i - 1];
            } else if (i < index){
                novoArray[i] = array[i];
            }
        }
        setVetor(novoArray);
    }

    public void deleteByValue(int[] array){
        int[] indecesNumero = searchValueArrayInSequencialOrder(array, -1);
        System.out.println("Deseja deletar todos os indeces deste numero ?");
        System.out.println("SIM = Digite -> S");
        System.out.println("NAO = Digite -> N");
        char flag = teclado.next().charAt(0);
        if(flag == 'S'){
            deleteSpecificIndex(array, indecesNumero);
        } else if (flag == 'N'){
            int[] op = new int[0];
            String option;
            while (op.length < indecesNumero.length || teclado.next().isEmpty()){
                System.out.println("Indice desejado :");
                System.out.println("Aperte S para sair do looping");
                option = teclado.next();
                if(option.equals("S")) break;
                op = insertAnotherValue(op, Integer.parseInt(option));
            }
            if(!compareArrays(indecesNumero, op)){
                return;
            }
            deleteSpecificIndex(array, op);
        }
    }

    public boolean compareArrays(int[]A, int[]B){
        for (int b:
             B) {
            if (Arrays.binarySearch(A, b) < 0) {
                return false;
            }
        }
        return true;
    }

    public int[] retornaArray(){
        System.out.println("Informa o Array desejado:");
        System.out.println("1- Vetor A");
        System.out.println("2- Vetor B");
        this.opcaoVetor = teclado.nextInt();
        switch (this.opcaoVetor){
            case 1 -> {
                return vetorA;
            }
            case 2 -> {
                return vetorB;
            }
            default -> retornaArray();
        }
        return null;
    }
}
