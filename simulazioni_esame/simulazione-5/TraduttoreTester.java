
// Matteo Galiazzo
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.tools.ForwardingFileObject;

import java.util.Arrays;

public class TraduttoreTester {
    public static void main(String[] args) {
        if (args.length == 2) {
            FileReader file1 = null;
            PrintWriter file2 = null;
            try {
                file1 = new FileReader(args[0]);
                file2 = new PrintWriter(args[1]);
            } catch (FileNotFoundException e) {
                System.out.println("File non trovati!");
            }
            Traduttore traduttoreFile1 = new Traduttore();
            // scrivo gli elementi di file1 nel traduttore
            Scanner scannerFile1 = new Scanner(file1);
            while (scannerFile1.hasNextLine()) {
                Scanner lineScanner = new Scanner(scannerFile1.nextLine());
                String key = lineScanner.next();
                lineScanner.next();
                Scanner translationsScanner = new Scanner(lineScanner.nextLine());
                String[] translations = new String[0];
                while (translationsScanner.hasNext()) {
                    translations = resize(translations);
                    translations[translations.length - 1] = translationsScanner.next();
                }
                System.out.println("--- INSERTING ---");
                System.out.println(key + " : " + Arrays.toString(translations));
                traduttoreFile1.insert(key, translations);
                translationsScanner.close();
                lineScanner.close();
            }
            System.out.println("FINITI INSERIMENTI");
            scannerFile1.close();
            // leggo da input standard e riempio il traduttore
            Traduttore traduttoreFile2 = new Traduttore();
            Scanner scanner = new Scanner(System.in);
            System.out.println("INIZIO RICHIESTA INPUT");
            do {
                System.out.println("inserisci chiave : traduzioni[]");
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                String key = lineScanner.next();
                lineScanner.next();
                Scanner translationsScanner = new Scanner(lineScanner.nextLine());
                String[] translations = new String[0];
                while (translationsScanner.hasNext()) {
                    translations = resize(translations);
                    translations[translations.length - 1] = translationsScanner.next();
                }
                System.out.println("--- INSERTING ---");
                System.out.println(key + " : " + Arrays.toString(translations));
                traduttoreFile2.insert(key, translations);
                translationsScanner.close();
                lineScanner.close();
            } while (scanner.hasNextLine());
            scanner.close();
            // con il metodo update mettere in traduttore1 il contenuto di traduttore2
            // stampare traduttoreFile1 in file2 enllo stesso formato del toString
            System.out.println("--- AGGIORNO IL TRADUTTORE1 IN BASE AGLI INSERIMENTI ---");
            traduttoreFile1.update(traduttoreFile2);
            System.out.println("--- STAMPA DEL TRADUTTORE1 ---");
            System.out.println(traduttoreFile1.toString());
            file2.print(traduttoreFile1.toString());
            System.out.println("--- CHIUSURA DEI FILE ---");
            scanner.close();
            try {
                file1.close();
                file2.close();
            } catch (IOException e) {
                System.out.println("Problema durante la chiusura dei file");
            }
        } else {
            System.out.println("Devi inserire i nomi dei due file da riga di comando!");
        }
    }

    private static String[] resize(String[] oldArray) {
        String[] newArray = new String[oldArray.length + 1];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }
}

class Traduttore implements DictionaryUD {

    WordPair wordPair[];
    int size;

    public Traduttore() {
        wordPair = new WordPair[20];
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
        // if (key == null || !(key instanceof String) || !(value instanceof String[]))
        // throw new IllegalArgumentException();
        int toInsertIndex = binarySearchKeyPosition(key);
        if (toInsertIndex == -1) {
            int index = size;
            while (index > 0 && key.compareTo(wordPair[index - 1].getWord()) < 0) {
                wordPair[index] = wordPair[index - 1];
                index--;
            }
            wordPair[index] = new WordPair((String) key, (String[]) value);
            size++;
        } else {
            wordPair[toInsertIndex] = new WordPair((String) key, (String[]) value);
        }
    }

    @Override
    public void remove(Comparable key) {
        int index = binarySearchKeyPosition(key);
        for (int i = index; i < size; i++) {
            wordPair[i] = wordPair[i + 1];
        }
        size--;
    }

    @Override
    public Object find(Comparable key) {
        if (key == null || !(key instanceof String))
            throw new IllegalArgumentException();
        int index = binarySearchKeyPosition(key);
        if (index != -1)
            return wordPair[index].getTranslations();
        else
            throw new DictionaryItemNotFoundException();
    }

    private int binarySearchKeyPosition(Comparable key) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int med = (min + max) / 2;
            if (wordPair[med].getWord().equals(key)) {
                return med;
            } else if (key.compareTo((Comparable) wordPair[med].getWord()) > 0) {
                min = med + 1;
            } else {
                max = med - 1;
            }
        }
        return -1;
    }

    @Override
    public void update(DictionaryUD newdict) {
        // creating the new object and filling the class array with the passed object's
        // data
        WordPair mergedPair[] = ((Traduttore) newdict).wordPair;
        System.out.println("SECOND ARRAY SIZE " + ((Traduttore) newdict).size);
        for (int i = 0; i < ((Traduttore) newdict).size; i++)
            insert(mergedPair[i].getWord(), mergedPair[i].getTranslations());
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += wordPair[i].toString() + "\n";
        }
        return str;
    }

    // classe privata WordPair: non modificare!!
    private class WordPair {
        public WordPair(String word, String[] translations) {
            this.word = word;
            this.translations = translations;
        }

        public String getWord() {
            return word;
        }

        public String[] getTranslations() {
            return translations;
        }

        /*
         * Restituisce una stringa contenente
         * - la parola word
         * - un carattere di separazione ( : )
         * - gli elementi dell'array translations, separati da uno spazio
         */
        public String toString() {
            String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
                retString += " " + translations[i];
            return retString;
        }

        // campi di esemplare
        private String word;
        private String[] translations;
    }

}

interface DictionaryUD // non modificare!!
{
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
     * se la chiave esiste gia' il valore ad essa associato viene sovrascritto
     * con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
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

    /*
     * Aggiorna il contenuto del dizionario (parametro implicito del metodo) con
     * il contenuto del dizionario newdict (parametro esplicito del metodo).
     * Piu' precisamente:
     * a) se newdict contiene una chiave key non presente nel dizionario, la
     * coppia corrispondente (key value) viene scritta nel dizionario
     * b) se newdict contiene una chiave key gia' presente nel dizionario, la
     * coppia (key value) presente nel dizionario viene sovrascritta da quella
     * di newdict
     */
    void update(DictionaryUD newdict);
}

class DictionaryItemNotFoundException extends RuntimeException {
}
