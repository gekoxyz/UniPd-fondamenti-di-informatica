import java.util.Scanner;

/*
Scrivere un programma SimpleTriangleTester, che riceve da standard input tre numeri interi positivi 
che rappresentano le lunghezze dei lati di un triangolo e che invia a standard output una stringa 
contenente le seguenti informazioni:
- relativamente ai lati: equilatero, isoscele, scaleno
- relativamente agli angoli: acutangolo, rettangolo, ottusangolo
Esempi
- se vengono inseriti i numeri "3 4 5", il programma visualizzera` la stringa "triangolo scaleno rettangolo".
- se vengono inseriti i numeri "5 7 7", il programma visualizzera` la stringa "triangolo isoscele acutangolo".
- se vengono inseriti i numeri "5 3 3", il programma visualizzera` la stringa "triangolo isoscele ottusangolo".
- se vengono inseriti i numeri "3 3 3", il programma visualizzera` la stringa "triangolo equilatero" (non serve l'informazione relativa agli angoli perche' i triangoli equilateri sono sempre acutangoli avendo tre angoli uguali pari a pigreco / 3).
- se vengono inseriti i numeri "3 4 8", il programma visualizzera` la stringa "non è un triangolo" (non sempre tre lati rappresentano un triangolo).
*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleTriangleTester simpleTriangleTester = new SimpleTriangleTester();
        System.out.println("Inserisci le dimensioni di 3 lati di un triangolo");
        System.out.println("Lato 1:");
        int n1 = scan.nextInt();
        System.out.println("Lato 2:");
        int n2 = scan.nextInt();
        System.out.println("Lato 3:");
        int n3 = scan.nextInt();
        scan.close();
        simpleTriangleTester.checkTriangle(n1, n2, n3);
    }
}