import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Scrivere una classe eseguibile che 
    riceve da riga di comando due numeri interi dim e n;
    crea un array di dimensione dim, contenente numeri interi casuali compresi tra 1 e n, 
    e lo visualizza a standard output;
    cerca il valore minimo tra quelli contenuti nell'array, tramite un algoritmo ricorsivo.
*/
public class Main {

    public static int findMin(int arr[], int min, int cont) {
        if (cont == arr.length)
            return min;
        if (arr[cont] < min)
            min = arr[cont];
        return findMin(arr, min, ++cont);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci la dimensione dell'array: ");
        int dim = scanner.nextInt();
        System.out.println("inserisci il numero casuale massimo: ");
        int n = scanner.nextInt();
        scanner.close();
        int arr[] = new int[dim];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(n + 1);
        }
        System.out.println(Arrays.toString(arr));
        int min = findMin(arr, arr[1], 1);
        System.out.println("L' elemento minimo e` " + min);
    }
}