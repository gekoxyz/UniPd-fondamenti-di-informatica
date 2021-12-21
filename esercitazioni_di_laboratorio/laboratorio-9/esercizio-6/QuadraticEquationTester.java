import java.util.Scanner;

public class QuadraticEquationTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A");
        double acoeff = scanner.nextDouble();
        System.out.println("B");
        double bcoeff = scanner.nextDouble();
        System.out.println("C");
        double ccoeff = scanner.nextDouble();
        scanner.close();
        QuadraticEquation quadraticEquation = new QuadraticEquation(acoeff, bcoeff, ccoeff);
        if (quadraticEquation.hasSolutions()) {
            System.out.println("Soluzione 1: " + quadraticEquation.getSolution1());
            System.out.println("Soluzione 2: " + quadraticEquation.getSolution2());
        } else {
            System.out.println("Il delta e' negativo");
        }
    }
}
