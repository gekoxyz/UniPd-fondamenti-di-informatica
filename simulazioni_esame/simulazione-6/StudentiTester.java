
// Matteo Galiazzo  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentiTester {
    public static void main(String[] args) {
        if (args.length == 2) {
            FileReader file1 = null;
            PrintWriter file2 = null;
            try {
                file1 = new FileReader(args[0]);
                file2 = new PrintWriter(args[1]);
            } catch (FileNotFoundException e) {
                System.out.println("File non trovato " + e);
            }
            // inizio inserimento da file studenti
            Studenti studentiFile1 = new Studenti();
            Scanner scannerFile1 = new Scanner(file1);
            while (scannerFile1.hasNextLine()) {
                Scanner lineScanner = new Scanner(scannerFile1.nextLine());
                long matr = Long.parseLong(lineScanner.next());
                lineScanner.next();
                String name = lineScanner.nextLine();
                name = name.substring(1, name.length());
                System.out.println("INSERISCO " + matr + " : " + name);
                studentiFile1.insert(matr, name);
            }
            scannerFile1.close();
            try {
                file1.close();
            } catch (IOException e) {
                System.out.println("Errore durante la chiusura del file1");
            }
            System.out.println("--- STUDENTI INSERITI ---");
            System.out.println(studentiFile1.toString());
            // fine inserimento da file studenti
            Studenti studentiFile2 = new Studenti();
            Scanner scanner = new Scanner(System.in);
            boolean active = true;
            while (active) {
                String userinput = scanner.next();
                if (userinput.equalsIgnoreCase("q")) {
                    active = false;
                    break;
                }
                try {
                    long matr = Long.parseLong(userinput);
                    String name = null;
                    name = (String) studentiFile1.find(matr);
                    studentiFile2.insert(matr, name);
                    studentiFile1.remove(matr);
                } catch (NumberFormatException e) {
                    System.out.println("Non hai inserito un numero valido");
                } catch (DictionaryItemNotFoundException e) {
                    System.out.println("Hai inserito uno studente non presente");
                }
            }
            scanner.close();
            file2.println(studentiFile2.toString());
            file2.close();
        } else
            System.out.println("devi inserire due parametri");
    }
}

class Studenti implements Dictionary {

    private Pair pair[];
    private int size;

    public Studenti() {
        pair = new Pair[20];
        makeEmpty();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void makeEmpty() {
        size = 0;
    }

    @Override
    public void insert(Comparable key, Object value) {
        if (key == null || !(key instanceof Long) || !(value instanceof String))
            throw new IllegalArgumentException();
        int toInsertIndex = binarySearch(key);
        if (toInsertIndex == -1) {
            int index = size;
            while (index > 0 && (key.compareTo(pair[index - 1].getMatr()) < 0)) {
                pair[index] = pair[index - 1];
                index--;
            }
            pair[index] = new Pair((long) key, (String) value);
            size++;
        } else {
            pair[toInsertIndex] = new Pair((long) key, (String) value);
        }
    }

    @Override
    public void remove(Comparable key) {
        int toRemoveIndex = binarySearch(key);
        if (toRemoveIndex != -1) {
            for (int i = toRemoveIndex; i < size; i++)
                pair[i] = pair[i + 1];
            size--;
        } else
            throw new DictionaryItemNotFoundException();
    }

    @Override
    public Object find(Comparable key) {
        int toFindIndex = binarySearch(key);
        if (toFindIndex != -1)
            return pair[toFindIndex].getName();
        throw new DictionaryItemNotFoundException();
    }

    private int binarySearch(Comparable key) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (((Comparable) pair[mid].getMatr()).equals(key)) {
                return mid;
            } else if (key.compareTo(pair[mid].getMatr()) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
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
        public Pair(long matr, String name) {
            this.matr = matr;
            this.name = name;
        }

        public long getMatr() {
            return matr;
        }

        public String getName() {
            return name;
        }

        /*
         * Restituisce una stringa contenente
         * - il numero di matricola, (numero long contenuto in "matr")
         * - un carattere di separazione ( : )
         * - il nome (stringa di una o piu` parole contenuta in "name")
         */
        public String toString() {
            return matr + " : " + name;
        }

        // campi di esemplare
        private long matr;
        private String name;
    }

}

interface Dictionary {
    /*
     * verifica se il dizionario contiene almeno una coppia chiave/valore
     */
    boolean isEmpty();

    /*
     * svuota il dizionario
     */
    void makeEmpty();

    /*
     * Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     * Se la chiave non esiste la coppia key/value viene aggiunta al dizionario;
     * se la chiave esiste gia', il valore ad essa associato viene sovrascritto
     * col nuovo valore; se key e` null viene lanciata IllegalArgumentException
     */
    void insert(Comparable key, Object value);

    /*
     * Rimuove dal dizionario l'elemento specificato dalla chiave key
     * Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
     */
    void remove(Comparable key);

    /*
     * Cerca nel dizionario l'elemento specificato dalla chiave key
     * La ricerca per chiave restituisce soltanto il valore ad essa associato
     * Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
     */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {
}
