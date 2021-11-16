import java.util.Random;
import java.util.Scanner;

/*
Scrivere un programma che riceve da standard input la data di compleanno dell'utente (in formato giorno mese), e visualizza a 
standard output l'oroscopo corrispondente. Il programma deve gestire correttamente anche il caso in cui l'input non corrisponda 
al formato prescritto.
Esempio: Se viene inserito l'input "26 7" (ovvero, 26 luglio), il programma potra` visualizzare la seguente stringa 

LEONE 
Amore:    4/5
Amicizia: 3/5
Lavoro:   3/5

Se invece l'input inserito non e` interpretabile come una data in formato giorno mese (ad esempio, l'input "43 21", oppure 
l'input "32 1", oppure l'input "30 2"), il programma dovra` visualizzare la stringa

L'input inserito non e` una data.

Suggerimenti: le associazioni tra date di nascita e segni zodiacali possono essere reperite in rete. Le stringhe
contenenti gli oroscopi di ciascun segno possono venire inventate a vostro piacimento (come si fa solitamente con gli oroscopi...), 
l'unico requisito è che ciascuna di esse deve contenere il nome del segno corrispondente. 
*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Inserisci la tua data di nascita nel formato giorno mese (es. \"20 11\")");
        String birthDate = scan.nextLine();
        scan.close();
        int day = Integer.parseInt(birthDate.substring(0, 2));
        int month = Integer.parseInt(birthDate.substring(3));
        if (day > 0 && day < 30 && month > 0 && day < 30) {
            if ((month == 3 && day >= 20) || (month == 4 && day <= 20)) {
                System.out.println("Ariete");
            } else if ((month == 4 && day >= 21) || (month == 5 && day <= 20)) {
                System.out.println("Toro");
            } else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) {
                System.out.println("Gemelli");
            } else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
                System.out.println("Cancro");
            } else if ((month == 7 && day >= 23) || (month == 8 && day <= 23)) {
                System.out.println("Leone");
            } else if ((month == 8 && day >= 24) || (month == 9 && day <= 22)) {
                System.out.println("Vergine");
            } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
                System.out.println("Bilancia");
            } else if ((month == 10 && day >= 23) || (month == 11 && day <= 22)) {
                System.out.println("Scorpione");
            } else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) {
                System.out.println("Saggitario");
            } else if ((month == 12 && day >= 22) || (month == 1 && day <= 20)) {
                System.out.println("Capricorno");
            } else if ((month == 1 && day >= 21) || (month == 2 && day <= 19)) {
                System.out.println("Acquario");
            } else if ((month == 2 && day >= 20) || (month == 3 && day <= 19)) {
                System.out.println("Pesci");
            }
            int amore = rand.nextInt(11);
            int amicizia = rand.nextInt(11);
            int lavoro = rand.nextInt(11);
            System.out.println("Amore: " + amore + "/10");
            System.out.println("Amicizia: " + amicizia + "/10");
            System.out.println("Lavoro: " + lavoro + "/10");
        } else {
            System.out.println("L'input inserito non e` una data");
        }
    }
}