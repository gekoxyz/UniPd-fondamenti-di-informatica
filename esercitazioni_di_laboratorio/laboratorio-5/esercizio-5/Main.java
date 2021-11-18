import java.util.Scanner;

/*
Chiedere all'utente di inserire un numero intero. Leggere due serie di numeri in virgola mobile di lunghezza pari all'intero specificato. 
Ciacun numero della serie deve essere specificato in una riga di input (= premere invio dopo ogni numero inserito). 
Restituire in uscita la somma di ciascuna componente corrispondente e la somma totale. Ad esempio:

Quanti elementi?
4

Inserisci gli elementi del primo array, uno per riga:
1.2
2.3
3.4
4.5

Inserisci gli elementi del secondo array, uno per riga:
1.1
0
2.2
2.2

In output:
2.3 2.3 5.6 6.7
16.9
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la dimensione degli array: ");
        int length = scan.nextInt();
        double arr1[] = new double[length];
        System.out.println("Inserisci gli elementi del primo array, uno per riga:");
        for (int i = 0; i < length; i++) {
            arr1[i] = scan.nextDouble();
        }
        System.out.println("Inserisci gli elementi del secondo arrya, uno per riga:");
        double arr2[] = new double[length];
        for (int i = 0; i < length; i++) {
            arr2[i] = scan.nextDouble();
        }
        scan.close();
        System.out.println("Somme:");
        double totalSum = 0;
        for (int i = 0; i < length; i++) {
            double partialSum = arr1[i] + arr2[i];
            System.out.println(partialSum);
            totalSum += partialSum;
        }
        System.out.println("Totale: " + totalSum);
    }
}