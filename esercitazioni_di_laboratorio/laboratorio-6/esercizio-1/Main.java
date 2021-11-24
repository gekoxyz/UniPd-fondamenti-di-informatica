import java.util.Scanner;

/*
Testare gli algoritmi scrivendo una classe di collaudo ArrayUtilTester che
riceva da standard input la dimensione e l'intervallo di variabilità di un array di numeri interi casuali
Stampi il contenuto dell'array generato
Collaudi gli algoritmi visualizzando dopo ogni operazione il contenuto dell'array attraverso la sequenza di richieste:
Chiedere all'utente un valore e una posizione in cui inserirlo
Chiedere all'utente di indicare la posizione di un elemento da eliminare (senza considerare rilevante l'ordine)
Chiedere all'utente di indicare la posizione di un elemento da eliminare (considerando rilevante l'ordine)
Chiedere all'utente un valore da cercare
Visualizzi minimo e massimo del contenuto dell'array
Ricordarsi di modificare la taglia di vSize se le operazioni che la modificano vanno a buon fine.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la dimensione dell'array: ");
        int vSize = scan.nextInt();
        System.out.println("Inserisci il numero massimo per la generazione casuale: ");
        int maxElement = scan.nextInt();
        int vector[] = ArrayUtil.randomIntArray(vSize, maxElement);
        ArrayUtil.printArray(vector, vSize);
        System.out.println("Inserisci un valore da inserire nell'array: ");
        int valueToInsert = scan.nextInt();
        System.out.println("In che posizione vuoi inserire il valore?");
        int positionToInsert = scan.nextInt();
        ArrayUtil.insert(vector, vSize, positionToInsert, valueToInsert);
        vSize++;
        ArrayUtil.printArray(vector, vSize);
        System.out.println("Inserisci la posizione di un elemento da eliminare: ");
        int positionToDelete = scan.nextInt();
        ArrayUtil.remove(vector, vSize, positionToDelete);
        vSize--;
        ArrayUtil.printArray(vector, vSize);
        System.out.println("Inserisci la posizione di un elemento da eliminare (mantiene l'ordine degli elementi): ");
        positionToDelete = scan.nextInt();
        ArrayUtil.removeSorted(vector, vSize, positionToDelete);
        vSize--;
        ArrayUtil.printArray(vector, vSize);
        System.out.println("Inserisci un valore da ricercare: ");
        int toSearch = scan.nextInt();
        boolean found = ArrayUtil.find(vector, vSize, toSearch);
        if (found) {
            System.out.println("Elemento trovato");
        } else {
            System.out.println("Elemento non presente nell'array");
        }
        int min = ArrayUtil.findMin(vector, vSize);
        int max = ArrayUtil.findMax(vector, vSize);
        System.out.println("Valore minimo:\t" + min);
        System.out.println("Valore massimo:\t" + max);
    }
}
