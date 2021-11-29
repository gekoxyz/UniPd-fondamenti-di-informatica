import java.util.Scanner;

/*
Acquisire da standard input una stringa e farne una scansione con Scanner riportando 
in uscita, una sotto l'altra, tutte le parole che la compongono
*/
public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                System.out.print(input.charAt(i));
            } else {
                System.out.println();
            }
        }
    }
}
