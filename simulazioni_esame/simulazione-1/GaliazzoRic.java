
// Matteo Galiazzo
import java.util.Scanner;

public class GaliazzoRic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa con lettere e numeri");
        String userInput = scanner.next();
        // metodo statico ricorsivo che calcola la somma dei caratteri che corrispondono
        // a cifre
        // USARE SOLO CLASSE STRING E CHARACTER
        int total = recursiveSum(userInput);
        System.out.println(total);
    }

    public static int recursiveSum(String userInput) {
        if (userInput.length() == 0)
            return 0;
        char last = userInput.charAt(userInput.length() - 1);
        if (Character.isDigit(last))
            return Character.getNumericValue(last) + recursiveSum(userInput.substring(0, userInput.length() - 1));
        return recursiveSum(userInput.substring(0, userInput.length() - 1));
    }
}