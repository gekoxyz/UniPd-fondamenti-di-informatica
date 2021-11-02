import java.util.Locale;
import java.util.Scanner;

/*
Scrivere un programma che

    acquisisca tre numeri in virgola mobile da standard input
    stampi a standard output i tre numeri e la loro somma.

Esempio: se si introduce: 1.0 2.0 3.0

il programma produce la seguente stampa:

1.0 + 2.0 + 3.0 = 6.0

Attenzione : se state lavorando su un sistema operativo che usa la lingua italiana, 
e usate il metodo nextDouble di Scanner per leggere i numeri in virgola mobile da standard input,
i numeri vanno inseriti usando la virgola come carattere di separazione fra parte intera e parte
frazionaria. Il programma invia a standard output numeri in virgola mobile in cui il carattere di 
separazione fra parte intera e frazionaria e` il punto. Usate Locale come visto a lezione se volete 
inserire i numeri in virgola mobile usando il punto come separatore.
*/
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        double num1 = 0, num2 = 0, num3 = 0;
        System.out.println("Inserisci num1: ");
        num1 = scan.nextDouble();
        System.out.println("Inserisci num2: ");
        num2 = scan.nextDouble();
        System.out.println("Inserisci num3: ");
        num3 = scan.nextDouble();
        scan.close();
        System.out.println("Somma: " + (num1 + num2 + num3));
    }
}
