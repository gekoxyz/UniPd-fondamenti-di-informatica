import java.util.Scanner;

/*
Modificare il programma dell'Esercizio 3 in maniera tale che

- le tre stringhe vengano stampate a standard output nell'ordine inverso rispetto a quello in cui 
sono state inserite
- la stampa delle tre stringhe venga effettuata utilizzando una singola invocazione del metodo 
print o del metodo println
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci tre parole separate da uno spazio: ");
        String words = scan.nextLine();
        scan.close();
        int wordsIndex = 0, wordStartIndex = 0, countedWords = 0;
        String word1 = "", word2 = "", word3 = "";
        while (wordsIndex <= words.length()) {
            if (wordsIndex == words.length() || words.charAt(wordsIndex) == ' ') {
                countedWords++;
                // fatto con if perche` non possiamo ancora usare i select case
                if (countedWords == 1) {
                    word1 = words.substring(wordStartIndex, wordsIndex);
                } else if (countedWords == 2) {
                    word2 = words.substring(wordStartIndex, wordsIndex);
                } else if (countedWords == 3) {
                    word3 = words.substring(wordStartIndex, wordsIndex);
                }
                wordStartIndex = wordsIndex + 1;
            }
            wordsIndex++;
        }
        System.out.println(word3 + " " + word2 + " " + word1);
    }
}
