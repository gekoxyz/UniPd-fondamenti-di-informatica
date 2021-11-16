import java.util.Scanner;

/*
Leggere da standard input un numero arbitrario di parole, una per ogni riga. Inviare a standard output una riga di testo unica 
in cui i caratteri di ciascuna parola sono disposti in ordine inverso.

Esempio:

input:

uno

due

tre

output: onu eud ert
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String reversedStrings = "";
        System.out.println("Inserisci delle parole, premi ctrl+d per uscire");
        while (scan.hasNextLine()) {
            String toReverse = scan.nextLine();
            for (int i = toReverse.length() - 1; i >= 0; i--) {
                reversedStrings += toReverse.charAt(i);
            }
            reversedStrings += " ";
        }
        scan.close();
        System.out.println(reversedStrings);
    }
}