import java.util.Scanner;

/*
Scrivere un programma che
    chiede all'utente di introdurre due stringhe (una per riga), s1 e s2; ciascuna stringa è costituita da 
    tutti i caratteri presenti sulla riga, compresi eventuali spazi iniziali, finali e/o intermedi
    verifica se la seconda stringa, s2, è una sottostringa di s1, ossia se esiste una coppia di numeri 
    interi, x e y, per cui s1.substring(x, y) restituisce una stringa uguale a s2 (al termine della verifica 
    viene visualizzato un messaggio opportuno)

Soluzione 1: Il programma puo' usare solo i metodi length(), substring(...) ed equals(...) della classe String.

Soluzione 2: Il programma puo' usare solo i metodi charAt() e length() della classe String.

Verificare che il programma gestisca correttamente la situazione in cui s2 è la stringa vuota 
(che, in base alla definizione precedente, è sottostringa di qualsiasi stringa).
*/
public class Main {
    public static boolean isSubstring(String string, String substring) {
        if (string.length() < substring.length()) {
            return false;
        } else if (substring.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == substring.charAt(0)) {
                    int stringPos = i;
                    int matches = 1;
                    for (int j = 0; j < substring.length(); j++) {
                        if (string.charAt(stringPos) == substring.charAt(j)) {
                            matches++;
                            if (matches == substring.length()) {
                                return true;
                            }
                            stringPos++;
                        } else {
                            matches = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la stringa");
        String string = scan.nextLine();
        System.out.println("Inserisci la sottostringa da cercare");
        String substring = scan.nextLine();
        scan.close();
        System.out.println(isSubstring(string, substring));
    }
}