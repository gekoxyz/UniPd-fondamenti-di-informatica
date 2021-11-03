import java.util.Scanner;

/*
Scrivere un programma che

- riceva in ingresso una stringa rappresentante un aggettivo qualificativo maschile o femminile 
    (terminante con il carattere 'o' o con il carattere 'a')
- stampi a standard output l'aggettivo inserito, con solo il primo carattere maiuscolo,
- stampi a standard output la forma diminutiva (-ino / -ina) dell'aggettivo inserito
- stampi a standard output il grado superlativo assoluto (-issimo / -issima) dell'aggettivo inserito
Ad esempio, se viene inserita la stringa "bello", il programma visualizzera` l'output
Aggettivo inserito:    Bello
Forma diminutiva:      Bellino
Superlativo assoluto:  Bellissimo
Se invece viene inserita la stringa "cara", il programma visualizzera` l'output
Aggettivo inserito:    Cara
Forma diminutiva:      Carina
Superlativo assoluto:  Carissima
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstCharUp, diminutive, superlative;
        System.out.println("Inserisci un aggettivo");
        String adjective = scan.next();
        scan.close();
        int penultimateCharIndex = adjective.length() - 1;
        firstCharUp = adjective.substring(0, 1).toUpperCase() + adjective.substring(1);
        if (adjective.charAt(adjective.length() - 1) == 'o') {
            diminutive = firstCharUp.substring(0, penultimateCharIndex) + "ino";
            superlative = firstCharUp.substring(0, penultimateCharIndex) + "issimo";
        } else {
            diminutive = firstCharUp.substring(0, penultimateCharIndex) + "ina";
            superlative = firstCharUp.substring(0, penultimateCharIndex) + "issima";
        }
        System.out.println("Aggettivo: " + adjective);
        System.out.println("Con prima lettera maiuscola: " + firstCharUp);
        System.out.println("Diminutivo: " + diminutive);
        System.out.println("Superlativo: " + superlative);
    }
}