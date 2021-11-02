import java.util.Scanner;

/*
Dopo averne osservato il codice, compilare la classe Numeric.java e Apprx.java. 
Eseguire quest'ultima e riflettere sui risultati.

Scrivere un programma che
    •    legga due numeri in virgola mobile
    •    visualizzi un messaggio che dice se i due numeri sono o meno approssimativamente uguali

*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il primo numero");
        double num1 = scan.nextDouble();
        System.out.println("Inserisci il secondo numero");
        double num2 = scan.nextDouble();
        scan.close();
        if (Numeric.approxEqual(num1, num2)) {
            System.out.println("I numeri sono circa uguali");
        } else {
            System.out.println("I numeri non sono uguali");
        }
    }
}
