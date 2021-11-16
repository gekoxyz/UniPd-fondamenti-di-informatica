import java.util.Scanner;
/*
Leggere da standard input una riga di testo. Inviare a standard output una corrispondente riga in cui i caratteri sono disposti in ordine inverso.

Esempio:
input:  uno due tre
output: ert eud onu
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String toReverse = scan.nextLine();
        scan.close();
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            System.out.print(toReverse.charAt(i));
        }
    }
}