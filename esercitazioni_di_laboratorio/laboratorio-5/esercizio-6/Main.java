import java.util.Scanner;

/*
Scrivere il programma EuclideMCD che calcoli il massimo comun divisore (MCD) di due numeri interi positivi 
m e n acquisiti da standard input e lo visualizzi sul flusso di uscita standard.
Si usi il noto Algoritmo di Euclide per il calcolo del MCD di due numeri interi positivi m ed n (con m > n):
Finchè il resto della divisione di m per n è diverso da zero
    il nuovo valore di m è uguale al precedente valore di n
    il nuovo valore di n è uguale al resto della divisione del precedente valore di m per il precedente valore di n
Il MCD è l'attuale valore di n
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il primo numero ");
        int m = scan.nextInt();
        System.out.println("Inserisci il secondo numero ");
        int n = scan.nextInt();
        scan.close();
        while (n > 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        System.out.println(m + " e` il MCD");
    }
}