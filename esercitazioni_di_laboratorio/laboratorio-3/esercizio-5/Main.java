import java.util.Scanner;

/*
Progettare il programma TwoNumbers che chieda all'utente di inserire due numeri 
e ne visualizzi (senza usare la classe Math):

    la somma
    il prodotto
    il valore medio
    il valore massimo
    il valore minimo
    il valore assoluto della differenza
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max, min;
        int num1 = 0, num2 = 0;
        int absDiff = 0;
        System.out.println("inserisci num1: ");
        num1 = scan.nextInt();
        System.out.println("inserisci num2: ");
        num2 = scan.nextInt();
        scan.close();
        System.out.println("numeri : [" + num1 + ", " + num2 + "]");
        System.out.println("somma: " + (num1 + num2));
        System.out.println("prodotto: " + (num1 * num2));
        if (num1 > num2) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        System.out.println("massimo: " + max);
        System.out.println("minimo: " + min);
        if ((num1 - num2) > 0) {
            absDiff = num1 - num2;
        } else {
            absDiff = (num1 - num2) * -1;
        }
        System.out.println("valore assoluto della differenza: " + absDiff);
    }
}