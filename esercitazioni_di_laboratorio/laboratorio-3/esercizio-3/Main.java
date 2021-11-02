import java.util.Scanner;

/*
Scrivere un programma che

    acquisisca da standard input una riga contenente tre parole o token (ovvero tre stringhe
    separate da un carattere di spaziatura)
    stampi le tre parole a standard output, una per riga nell'ordine in cui sono state acquisite

Esempio: se si introduce la stringa uno due tre, l'esecuzione della classe produce le seguenti stampe:

uno
due
tre
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci tre parole separate da uno spazio: ");
        String words = scan.nextLine();
        scan.close();
        int wordsIndex = 0;
        while (wordsIndex < words.length()) {
            if (words.charAt(wordsIndex) == ' ') {
                System.out.print('\n');
                wordsIndex++;
                continue;
            }
            System.out.print(words.charAt(wordsIndex));
            wordsIndex++;
        }
    }
}
