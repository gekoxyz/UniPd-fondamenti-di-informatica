/*
Esercizio 6

Obiettivo: esercitarsi con operazioni divisione e modulo fra interi
In Java l'operatore / calcola il risultato della divisione, mentre l'operatore % calcola il resto di una divisione fra interi.

Scrivere un programma che:
- definisca una variabile costante inizializzandola a un valore compreso fra 0 e 999 (con massimo tre cifre decimali).
- invii a standard output le singole cifre del numero separandole con uno spazio: ad esempo il numero 123 verra' visualizzato come 1 2 3. Se il numero e' inferiore a 100, stampi sempre tre cifre, introducendo zeri nelle cifre piu' significativa: ad esempo il numero 23 verra' visualizzato come 0 2 3.

Suggerimento per l'algoritmo da usare:
Applicare la definizione di notazione posizionale in base 10 e le proprieta' delle operazioni divisione e modulo dell'aritmetica intera.
Ad esempio: 123 = 1 * 10^2 + 2 * 10^1 + 3 * 10^0

quindi: 123/100 = 1 (cifra piu' significativa) e 123 %100 = 23...

oppure

123 % 10 =  3 (cifra meno significativa) e 123 / 10 = 12 ...
*/
public class Main {
    public static void main(String[] args) {
        final int number = 123;
        System.out.print((number / 100) % 10 + " ");
        System.out.print((number / 10) % 10 + " ");
        System.out.print((number / 1) % 10);

    }
}
