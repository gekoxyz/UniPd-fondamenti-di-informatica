import java.util.Scanner;

public class Main {

    public static void printSquares(Square square1, Square square2) {
        System.out.println(square1.toString());
        System.out.println(square2.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci x");
        int x1 = scanner.nextInt();
        System.out.println("Inserisci y");
        int y1 = scanner.nextInt();
        System.out.println("Inserisci la dimensione del lato del quadrato");
        int side1 = scanner.nextInt();
        Square square1 = new Square(x1, y1, side1);
        System.out.println("Inserisci x");
        int x2 = scanner.nextInt();
        System.out.println("Inserisci y");
        int y2 = scanner.nextInt();
        System.out.println("Inserisci la dimensione del lato del quadrato");
        int side2 = scanner.nextInt();
        Square square2 = new Square(x2, y2, side2);
        if (side1 < side2)
            printSquares(square1, square2);
        else
            printSquares(square2, square1);
        Scanner parseString;
        // flush the scanner buffer
        scanner.nextLine();
        System.out.println("Inserisci la nuova dimensione del primo quadrato");
        String newSide1 = scanner.nextLine();
        parseString = new Scanner(newSide1);
        int newWidth1 = Integer.parseInt(parseString.next());
        int newHeight1 = Integer.parseInt(parseString.next());
        parseString.close();
        square1.setSize(newWidth1, newHeight1);
        System.out.println("Inserisci la nuova dimensione del secondo quadrato");
        String newSide2 = scanner.nextLine();
        parseString = new Scanner(newSide2);
        int newWidth2 = Integer.parseInt(parseString.next());
        int newHeight2 = Integer.parseInt(parseString.next());
        parseString.close();
        square2.setSize(newWidth2, newHeight2);
        if (newWidth1 < newWidth2)
            printSquares(square1, square2);
        else
            printSquares(square2, square1);
    }
}
