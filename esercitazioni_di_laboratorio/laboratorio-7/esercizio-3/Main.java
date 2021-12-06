import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
Scrivere il programma Leggi3.java modificando il programma precedente in modo che 
i segni di punteggiature (virgola e punto di domanda) vengano considerati come 
separatori. Per far cio' sara' necessario invocare il metodo useDelimiter passando 
come parametro la stringa "[,?\\s]+". Il contenuto della stringa viene chiamato 
"espressione regolare". In sostanza stiamo dicendo di considerare come separatori 
la virgola, il punto di domanda e tutti gli spazi (\\s) ripetuti almento una volta 
(il + dopo la parentesi quadra). Le espressioni regolari sono un argomento avanzato 
che esula dal programma del corso.
Pero' possiamo facilmente creare dei separatori, ad esempio provate a definire come 
separatore la sola lettera "o" e vedere come si separa la frase.
*/
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
        scanner.useDelimiter("[,?\\s]+");
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
