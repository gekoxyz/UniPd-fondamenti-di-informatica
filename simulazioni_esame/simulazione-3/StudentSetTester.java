
// Matteo Galiazzo 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentSetTester {
    public static void main(String[] args) {
        String filename = args[0];
        StudentSet matricole = new StudentSet();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
        Scanner fileScanner = new Scanner(fileReader);
        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            String surname = lineScanner.next();
            String name = lineScanner.next();
            lineScanner.next(); // skip :
            int id = Integer.parseInt(lineScanner.next());
            matricole.add(new Student(surname, name, id));
        }
        fileScanner.close();
        System.out.println(matricole.toString());
        boolean active = true;
        Scanner scanner = new Scanner(System.in);
        while (active) {
            System.out.println("Inserisci una riga di input composta da stringa1 e stringa2");
            String userInput = null;
            try {
                userInput = scanner.nextLine();
            } catch (NoSuchElementException e) {
                active = false;
                break;
            }
            Scanner splitUserInput = new Scanner(userInput);
            Student fromStudent = new Student(splitUserInput.next(), "", 0);
            Student toStudent = new Student(splitUserInput.next(), "", 0);
            SortedSet subSet = matricole.subSet(fromStudent, toStudent);
            splitUserInput.close();
            System.out.println(subSet);
        }
        scanner.close();

    }
}

class StudentSet implements SortedSet {
    private int size;
    private Student students[];

    public StudentSet() {
        size = 0;
        students = new Student[50];
    }

    // verifica se l'insieme contiene almeno un elemento
    public boolean isEmpty() {
        return size == 0;
    }

    // svuota l'insieme
    public void makeEmpty() {
        size = 0;
    }

    // restituisce il numero di elementi nell'insieme
    public int size() {
        return size;
    }

    /*
     * Inserisce l'oggetto comparabile obj nell'insieme se non e` gia`
     * presente, altrimenti fallisce silenziosamente.
     */
    public void add(Comparable obj) {
        if (!(obj instanceof Student))
            throw new IllegalArgumentException();
        if (contains(obj))
            return;
        // Inserisco in ordine
        int i = size;
        Comparable comparableStudents[] = toArray();
        while (i > 0 && obj.compareTo(comparableStudents[i - 1]) < 0) {
            students[i + 1] = students[i];
            i--;
        }
        students[i] = (Student) obj;
        size++;
        System.out.println("INSERITO " + ((Student) obj).toString());
    }

    /*
     * Restituisce true se e solo se l'oggetto comparabile obj appartiene
     * all'insieme. Verranno considerate ottime le soluzioni per cui questo
     * metodo ha prestazioni O(log n)
     */
    public boolean contains(Comparable obj) {
        int min = 0;
        int max = size - 1;
        Comparable comparableStudents[] = toArray();
        while (min <= max) {
            int mid = (min + max) / 2;
            // maggiore se viene dopo in ordine alfabetico
            // c compareTo a > 0
            // a compareTo c < 0
            // b equals b ???
            if (obj.equals(comparableStudents[mid])) {
                return true;
            } else if (obj.compareTo(comparableStudents[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    /*
     * Restituisce un array di oggetti comparabili contenente i riferimenti a
     * tutti gli elementi presenti nell'insieme
     */
    public Comparable[] toArray() {
        Comparable[] comparables = new Comparable[size];
        for (int i = 0; i < size; i++) {
            comparables[i] = (Comparable) students[i];
        }
        return comparables;
    }

    /*
     * Riceve due riferimenti ad oggetti comparabili e restituisce un
     * riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
     * dell'insieme di partenza (cioe` il parametro implicito del metodo)
     * compresi tra fromObj (incluso) e toObj (escluso).
     * Se fromObj non appartiene all'insieme di partenza, il primo elemento
     * del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
     * nell'insieme di partenza.
     * Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
     * il nuovo insieme sara` vuoto
     */
    public SortedSet subSet(Comparable fromObj, Comparable toObj) {
        if (!(fromObj instanceof Student) || !(toObj instanceof Student))
            throw new IllegalArgumentException();
        StudentSet studentSet = new StudentSet();
        for (int i = 0; i < size; i++) {
            if (students[i].compareTo(fromObj) >= 0 && students[i].compareTo(toObj) < 0) {
                studentSet.students[studentSet.size++] = students[i];
            }
        }
        return studentSet;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].toString() + "\n";
        }
        return str;
    }

}

class Student implements Comparable // non modificare!!
{
    public Student(String c, String n, int m) {
        cognome = c;
        nome = n;
        matricola = m;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricola() {
        return matricola;
    }

    /*
     * I dati dello studente vengono stampati nel formato
     * "cognome        nome          : n.matricola"
     * Per il campo cognome e per il campo nome vengono allocati maxlength=15
     * caratteri
     */
    public String toString() {
        int maxlength = 15;
        String sep1 = "";
        for (int i = 0; i < maxlength - cognome.length(); i++)
            sep1 += " ";
        String sep2 = "";
        for (int i = 0; i < maxlength - nome.length(); i++)
            sep2 += " ";
        return cognome + sep1 + nome + sep2 + ": " + matricola;
    }

    /*
     * Lo studente x e` "maggiore" dello studente y se il cognome di x segue
     * quello di y secondo l'ordinamento lessicografico. Se i due cognomi sono
     * uguali, allora x e` "maggiore" di y se il nome di x segue quello di y
     * secondo l'ordinamento lessicografico. Se anche i nomi sono uguali
     * (due studenti omonimi) allora x e` "maggiore" di y se la sua matricola
     * e` piu` grande di quella di y.
     * Esempio1:
     * (DeMorgan Augustus : 511123) e` maggiore di (Babbage Charles : 599987)
     * Esempio2:
     * (Bernoulli Nicolaus : 577789) e` maggiore di (Bernoulli Jacob : 500098)
     * Esempio3:
     * (Bernoulli Nicolaus : 588890) e` maggiore di (Bernoulli Nicolaus : 577789)
     * 
     */
    public int compareTo(Object other) {
        Student aStudent = (Student) other;
        int comp = cognome.compareTo(((Student) other).cognome);
        if (comp == 0)
            comp = nome.compareTo(((Student) other).nome);
        if (comp == 0)
            comp = matricola - ((Student) other).matricola;
        return comp;
    }

    /*
     * Due studenti x e y sono "uguali" solo se hanno lo stesso cognome e lo
     * stesso nome e lo stesso numero di matricola.
     * Esempio:
     * (Babbage Charles : 599987) e` uguale a (Babbage Charles : 599987)
     * 
     */
    public boolean equals(Object other) {
        return this.compareTo(other) == 0;
    }

    private String cognome;
    private String nome;
    private int matricola;
}

interface SortedSet // non modificare!!
{ // verifica se l'insieme contiene almeno un elemento
    boolean isEmpty();

    // svuota l'insieme
    void makeEmpty();

    // restituisce il numero di elementi nell'insieme
    int size();

    /*
     * Inserisce l'oggetto comparabile obj nell'insieme se non e` gia`
     * presente, altrimenti fallisce silenziosamente.
     */
    void add(Comparable obj);

    /*
     * Restituisce true se e solo se l'oggetto comparabile obj appartiene
     * all'insieme. Verranno considerate ottime le soluzioni per cui questo
     * metodo ha prestazioni O(log n)
     */
    boolean contains(Comparable obj);

    /*
     * Restituisce un array di oggetti comparabili contenente i riferimenti a
     * tutti gli elementi presenti nell'insieme
     */
    Comparable[] toArray();

    /*
     * Riceve due riferimenti ad oggetti comparabili e restituisce un
     * riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
     * dell'insieme di partenza (cioe` il parametro implicito del metodo)
     * compresi tra fromObj (incluso) e toObj (escluso).
     * Se fromObj non appartiene all'insieme di partenza, il primo elemento
     * del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
     * nell'insieme di partenza.
     * Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
     * il nuovo insieme sara` vuoto
     */
    SortedSet subSet(Comparable fromObj, Comparable toObj);

}
