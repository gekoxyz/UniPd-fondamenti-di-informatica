import java.util.Scanner;

/*
Scrivere un programma che saluti voi stessi. Chiedere all'utente di inserire il proprio nome. 
Leggere da standard input il nome inserito e stampare una stringa di saluto in output. 
Ad esempio, nel mio caso devo stampare "Hello, Cinzia".
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome: ");
        String nome = scan.next();
        scan.close();
        System.out.println("Ciao " + nome);
    }
}
