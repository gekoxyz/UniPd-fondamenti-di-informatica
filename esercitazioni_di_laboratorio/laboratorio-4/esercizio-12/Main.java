import java.util.Scanner;

/*
Progettare il programma StandardDeviation che chieda all'utente di inserire una sequenza di numeri e ne visualizzi la deviazione standard.

La deviazione standard D si calcola con la formula seguente:


D = Math.sqrt((A - B*B/n)/(n-1))

dove n è il numero di valori, B è la somma di tutti i valori e A è la somma dei quadrati di tutti i valori. La formula è valida soltanto per 
n > 1 (per n = 1 la deviazione standard vale 0, per definizione).


Il programma non può far uso di sentinelle né può chiedere all'utente quanto sarà lunga la sequenza: deve continuare a leggere numeri fino a 
quando non viene chiuso il flusso di ingresso.

Il programma deve visualizzare un messaggio d'errore (e niente altro) se il flusso viene chiuso prima che siano stati introdotti almeno due numeri.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci dei numeri");
        double values = 0; // number of values
        double sum = 0; // sum of all values
        double sumPow = 0; // sum of pow of all values
        while (scan.hasNext()) {
            double num = scan.nextDouble();
            values++;
            sum += num;
            sumPow += num * num;
        }
        scan.close();
        double deviation = Math.sqrt((sumPow - ((sum * sum) / values)) / (values - 1));
        if (values < 2) {
            System.out.println("Deviazione: 0 per definizione");
        } else {
            System.out.println("Deviazione: " + deviation);
        }
    }
}