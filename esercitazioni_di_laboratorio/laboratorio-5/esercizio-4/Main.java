import java.util.Scanner;

/*
Leggere un numero arbitrario di interi da standard input e riportarli in uscita in ordine inverso di inserimento.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayUtil arrayUtil = new ArrayUtil();
        int size = 0;
        int numbers[] = new int[0];
        while (scan.hasNextInt()) {
            int number = scan.nextInt();
            size++;
            int tempArr[] = new int[size];
            tempArr = arrayUtil.resize(numbers, size);
            tempArr[size - 1] = number;
            numbers = tempArr;
        }
        scan.close();
        if (size > 0) {
            System.out.println("Array:");
            for (int i = numbers.length - 1; i >= 0; i--) {
                System.out.println(numbers[i]);
            }
        } else {
            System.out.println("Non hai inserito abbastanza numeri");
        }
    }
}