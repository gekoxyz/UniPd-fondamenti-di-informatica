import java.util.InputMismatchException;
import java.util.Scanner;

/*
Scrivere un programma eseguibile ContaInteri.java che legga da standard input un numero arbitrario di dati
e restituisca a standard output il numero di dati letti che sono valori interi. Utilizzare il metodo nextInt() 
di Scanner per leggere i dati inseriti. Se il dato inserito e' un intero dovra' essere incrementata una variabile 
contatore precedentemente definita. Nel caso in cui non si inserisca un intero il metodo lancera' l'eccezione 
InputMismatchException che dovra' essere catturata e gestita. In particolare, al verificarsi dell'eccezione non 
si dovra' incrementare il contatore ma si dovra' liberare il flusso d'ingresso standard dal dato non valido.

Dopo aver realizzato il programma testarlo con inserimento da tasteriera.

Dopo aver visto a lezione il reindirizzamento, testare il programma reindirizzando in input il file contaInteri.txt. 
Provare poi in entrambi i modi ma reindirizzando l'output nel file numeroInteri.txt. Verificare che il contenuto del 
file sia corretto con il comando "more numeroInteri.txt" su riga di comando del terminale, oppure aprendo il file 
numeroInteri.txt con un editor.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = 0;
        while (scan.hasNext()) {
            try {
                scan.nextInt();
                inputs++;
            } catch (InputMismatchException e) {
                scan.next();
            }
        }
        scan.close();
        System.out.println("Letto " + inputs + " numeri interi");
    }
}
