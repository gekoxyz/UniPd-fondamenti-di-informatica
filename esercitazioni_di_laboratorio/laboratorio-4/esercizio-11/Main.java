import java.util.Scanner;

/*
Progettare il programma SomeNumbers che chieda all'utente di inserire una sequenza di numeri e ne visualizzi:

la somma
la somma dei valori assoluti
il prodotto
il valore medio

Il programma non può far uso di sentinelle né può chiedere all'utente quanto sarà lunga la sequenza: deve continuare a leggere numeri fino a quando non viene chiuso il flusso di ingresso.
Il programma deve visualizzare un messaggio d'errore (e niente altro) se il flusso viene chiuso prima che siano stati introdotti almeno due numeri.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci dei numeri");
        int sum = 0, absSum = 0, product = 1, avg = 0;
        int insertions = 0;
        while (scan.hasNext()) {
            double num = scan.nextDouble();
            insertions++;
            sum += num;
            absSum += Math.abs(num);
            product *= num;
        }
        avg = sum / insertions;
        if (insertions < 2) {
            System.out.println("Hai inserito meno di due numeri");
        } else {
            System.out.println("Somma: " + sum);
            System.out.println("Somma valori assoluti: " + absSum);
            System.out.println("Prodotto: " + product);
            System.out.println("Media: " + avg);
        }
    }
}