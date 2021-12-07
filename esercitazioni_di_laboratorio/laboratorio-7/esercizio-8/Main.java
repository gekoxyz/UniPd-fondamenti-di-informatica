import java.util.Scanner;

/*
Scrivere una classe eseguibile che verifica se una stringa, fornita come parametro 
sulla riga di comando, e` palindroma. La verifica che una stringa sia o meno una 
palindroma deve essere realizzata con un algoritmo ricorsivo.
Si ricordi che una stringa e` una palindrome se e` composta da una sequenza di caratteri 
(anche non alfabetici) che possa essere letta allo stesso identico modo anche al contrario 
(es. "radar", "anna", "inni", "xyz%u%zyx").
*/
public class Main {
    public static String recursiveReverse(String toReverse) {
        if (toReverse.length() < 2)
            return toReverse;
        return recursiveReverse(toReverse.substring(1)) + toReverse.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toCheck = scanner.nextLine();
        scanner.close();
        System.out.println(recursiveReverse(toCheck));
        if (toCheck.equals(recursiveReverse(toCheck))) {
            System.out.println("palindroma :)");
        } else {
            System.out.println("non palindroma :(");
        }
    }
}