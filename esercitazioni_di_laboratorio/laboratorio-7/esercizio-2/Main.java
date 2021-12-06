import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = null;
        Scanner scanner = null;
        try {
            fileReader = new FileReader("./input.txt");
            scanner = new Scanner(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}