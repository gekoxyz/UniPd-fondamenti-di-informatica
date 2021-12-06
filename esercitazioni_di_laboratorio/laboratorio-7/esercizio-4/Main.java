import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Scrivere un programma che
    Riceva dall'input standard due nomi di file di testo, uno in lettura e uno in scrittura
    Apra in lettura il primo file e ne legga il contenuto
    Crei e apra in scrittura il secondo file
    Copi nel secondo file il contenuto del primo, opportunamente modificato in modo che tutte 
    le parole abbiano la prima lettera maiuscola e le seguenti minuscole
Provare il programma usando il file vispateresa.txt come file di input e creando (ad esempio) 
il file vispateresa2.txt in output.
Approfondimento: modificare il programma in modo che riconosca come due parole distinte anche 
quelle separate da un apostrofo. Ad esempio, se il file in lettura contiene le parole 

LA vispA teresa AVEA tra l'erBETTa

al termine dell'esecuzione il secondo file dovra` contenere il testo

La Vispa Teresa Avea Tra L'Erbetta

Suggerimento importante: studiare la documentazione di Scanner, e verificare che usando 
opportuni metodi è possibile usare un insieme di caratteri delimitatori diverso da quello 
di default.
*/

public class Main {
    public static void main(String[] args) {
        FileReader inputFile = null;
        PrintWriter outputFile = null;
        Scanner fileScanner = null;
        try {
            inputFile = new FileReader("vispateresa.txt");
            fileScanner = new Scanner(inputFile);
            outputFile = new PrintWriter("out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileScanner.useDelimiter("[ \t\n\']+");
        while (fileScanner.hasNext()) {
            String buffer = fileScanner.next();
            String toWrite;
            if (buffer.length() > 0) {
                toWrite = buffer.substring(0, 1).toUpperCase() + buffer.substring(1).toLowerCase();
            } else {
                toWrite = buffer.toUpperCase();
            }
            System.out.println(toWrite);
            outputFile.println(toWrite);
        }
        try {
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputFile.close();
    }
}
