
// Matteo Galiazzo 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class RubricaTester {
    public static void main(String[] args) {
        if (args.length == 2) {
            Rubrica rubrica1 = new Rubrica();
            Rubrica rubrica2 = new Rubrica();
            FileReader fileReader = null;
            PrintWriter printWriter = null;
            try {
                fileReader = new FileReader(args[0]);
                printWriter = new PrintWriter(args[1]);
            } catch (FileNotFoundException e) {
                System.out.println("FILE NON TROVATO " + e);
            }
            // fill rubrica1
            Scanner fileInputScanner = new Scanner(fileReader);
            while (fileInputScanner.hasNext()) {
                Scanner rowScanner = new Scanner(fileInputScanner.nextLine());
                String name = rowScanner.next();
                rowScanner.next(); // don't copy the :
                long number = Long.parseLong(rowScanner.next());
                rubrica1.insert(name, number);
                System.out.println("Inserito " + name + " : " + number + " in rubrica1");
            }
            System.out.println(rubrica1.toString());
            fileInputScanner.close();
            // ricerca/rimozione libera
            boolean active = true;
            Scanner userInput = new Scanner(System.in);
            while (active) {
                System.out.println(rubrica1.toString());
                System.out.println(rubrica2.toString());
                System.out.println("Che numero vuoi portare nella rubrica 2?");
                String input = userInput.next();
                if (input.equalsIgnoreCase("Q")) {
                    active = false;
                    break;
                } else {
                    long num = (long) rubrica1.find(input);
                    rubrica2.insert(input, num);
                    System.out.println("Inserito " + input + " : " + num + " in rubrica2");
                    rubrica1.remove(input);
                }
            }
            // scrittura su file
            printWriter.write(rubrica2.toString());
            userInput.close();
            printWriter.close();
        } else {
            System.out.println("esegui il programma come RubricaTester file1 file2");
        }
    }
}

class Rubrica implements Map {
    private Pair pair[];
    private int size;

    public Rubrica() {
        size = 0;
        pair = new Pair[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        size = 0;
    }

    public void insert(Comparable key, Object value) {
        if (key == null || !(value instanceof Long))
            throw new IllegalArgumentException();
        int pos = binarySearch(key, size, pair);
        if (pos == -1) {
            int i = size;
            while (i > 0 && ((pair[i - 1].getName()).compareTo((String) key) > 0)) {
                pair[i] = pair[i - 1];
                i--;
            }
            pair[i] = new Pair((String) key, (Long) value);
            size++;
            System.out.println(toString());
        } else {
            pair[pos] = new Pair(pair[pos].getName(), (Long) value);
        }
    }

    public void remove(Comparable key) {
        int pos = binarySearch(key, size, pair);
        if (pos != -1) {
            for (int i = pos; i < size; i++)
                pair[i] = pair[i + 1];
            size--;
        }
    }

    public Object find(Comparable key) {
        int pos = binarySearch(key, size, pair);
        if (pos == -1)
            throw new MapItemNotFoundException();
        return pair[pos].getPhone();
    }

    private static int binarySearch(Comparable key, int size, Pair pair[]) {
        if (key == null)
            throw new IllegalArgumentException();
        int first = 0;
        int last = size - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (((Comparable) pair[mid].getName()).compareTo(key) < 0) {
                first = mid + 1;
            } else if (((Comparable) pair[mid].getName()).compareTo(key) > 0) {
                last = mid - 1;
            } else {
                System.out.println("POSIZIONE " + mid);
                return mid;
            }
        }
        System.out.println("POSIZIONE -1");
        return -1;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += pair[i].toString() + "\n";
        }
        return str;
    }

    // classe privata Pair: non modificare!!
    private class Pair {
        public Pair(String aName, long aPhone) {
            name = aName;
            phone = aPhone;
        }

        public String getName() {
            return name;
        }

        public long getPhone() {
            return phone;
        }

        /*
         * Restituisce una stringa contenente
         * - la nome, "name"
         * - un carattere di separazione ( : )
         * - il numero telefonico, "phone"
         */
        public String toString() {
            return name + " : " + phone;
        }

        // campi di esemplare
        private String name;
        private long phone;
    }
}

interface Map {
    /*
     * verifica se la mappa contiene almeno una coppia chiave/valore
     */
    boolean isEmpty();

    /*
     * Map
     * svuota la mappa
     */
    void makeEmpty();

    /*
     * Inserisce un elemento nella mappa. L'inserimento va sempre a buon fine.
     * Se la chiave non esiste la coppia key/value viene aggiunta alla mappa;
     * se la chiave esiste gia' il valore ad essa associato viene sovrascritto
     * con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
     */
    void insert(Comparable key, Object value);

    /*
     * Rimuove dalla mappa l'elemento specificato dalla chiave key
     * Se la chiave non esiste viene lanciata MapItemNotFoundException
     */
    void remove(Comparable key);

    /*
     * Cerca nella mappa l'elemento specificato dalla chiave key
     * La ricerca per chiave restituisce soltanto il valore ad essa associato
     * Se la chiave non esiste viene lanciata MapItemNotFoundException
     */
    Object find(Comparable key);
}

class MapItemNotFoundException extends RuntimeException {
}
