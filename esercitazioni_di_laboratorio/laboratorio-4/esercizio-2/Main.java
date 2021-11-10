import java.util.Scanner;

/*
Progettare il programma IsLeapYear che segnali all'utente se il numero intero positivo che ha 
introdotto corrisponde a un anno bisestile oppure no.
Ricordare che un anno è bisestile se è divisibile per 4. Fanno eccezione gli anni divisibili per 100,
che non sono bisestili, e gli anni divisibili per 400, che invece sono bisestili 
(pur essendo divisibili anche per 100): tali eccezioni esistono però solo dopo l'adozione del
 calendario gregoriano, che avvenne nel 1582.
Il programma NON dovrà accettare il dato in ingresso (visualizzando, quindi, un messaggio d'errore)
quando è un numero intero non positivo.

Provare a risolvere l'esercizio prima senza usare gli operatori booleani (&&, || e !) e poi
invece utilizzandoli. Suggerisco di disegnare un diagramma di flusso con le varie diramazioni 
per chiarirsi le idee prima di scrivere il codice!

*/
public class Main {
    public static void main(String[] args) {
        IsLeapYear isLeapYear = new IsLeapYear();
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci un anno per sapere se e` stato o sara` bisestile");
        int year = scan.nextInt();
        scan.close();
        if (isLeapYear.isLeapYear(year) == 1) {
            System.out.println("L'anno " + year + " e` bisestile");
        } else {
            System.out.println("L'anno " + year + " non e` bisestile");
        }
    }
}