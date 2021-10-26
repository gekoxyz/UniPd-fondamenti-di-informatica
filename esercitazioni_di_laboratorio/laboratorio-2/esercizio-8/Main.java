import java.util.Scanner;

/*
Esercizio 8
Obiettivo: esercitarsi con operazioni divisione e modulo fra interi
Scrivere un programma che converta un numero decimale in una base qualsiasi b > 1.
Si scelga il numero da convertire nell'intervallo chiuso [0, b^3-1] in modo che sia esprimibile con tre cifre nella nuova base.
La base b e il numero da convertire vanno dichiarati come variabili intere nel codice, dove potete assegnare loro un valore.

Esempio se la base scelta e' 7, si scelga il numero fra 0 e 342 (7^3 = 343). Suggerimento per l'algoritmo da usare:algoritmo di 
conversione da base decimale a base generica b (invece che dividere per 2, come visto in classe per il caso binario, si divide per b).

Dopo aver provato con valori di variabili assegnati direttamente nel codice sorgente, modificare il programma in modo che la base e il 
valore decimale da convertire vengano specificati dall'utente e non fissati nel codice.
*/
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci la base ");
        int base = scan.nextInt();
        System.out.println("Inserisci il numero da convertire (compreso fra 0 e " + (int) (Math.pow(base, 3) - 1) + ")");
        int numberToConvert = scan.nextInt();
        scan.close();
        int position3 = numberToConvert % base;
        numberToConvert = numberToConvert / base;
        int position2 = numberToConvert % base;
        numberToConvert = numberToConvert / base;
        int position1 = numberToConvert % base;
        System.out.println("Il numero " + numberToConvert + " in base " + base + " e` " + position1 + position2 + position3);
    }
}
