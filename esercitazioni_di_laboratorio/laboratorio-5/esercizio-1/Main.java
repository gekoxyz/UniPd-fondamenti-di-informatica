/*
Realizzare una classe MyFirstArray che contenga un metodo main in cui venga creato un array di interi di dimensione 10. 
Inizializzare ciascuna posizione dell'array con il valore dell'indice corrispondente (ad esempio, a[2]=2);

Parte a)

Stampare a video la lunghezza dell'array.
Stampare a video il contenuto di ciascuna cella a partire dalla cella in posizione 0 fino ad arrivare all'ultima.
Stampare a video il contenuto di ciascuna cella a partire dalla cella in ultima posizione fino ad arrivare alla prima.

Parte b)

Realizzare un metodo ausiliario statico con firma
public static void incrementAll(int[] a)
che prenda come parametro esplicito un array di interi e che lo modifichi al suo interno incrementando il valore 
di ogni posizione di una unita'. Il tipo di dati restituito dal metodo e' void.
Dopo aver invocato il metodo dal main, passando come parametro l'array creato precedentemente , stampare a video 
il contenuto di ciascuna cella dell'array a partire dalla cella in posizione 0. Il contenuto e' stato modificato?

Parte c)

Creare nel main una variabile int e assegnarle un valore.
Realizzare un metodo ausiliario statico con firma public static void incrementVar(int value) che prenda come parametro
esplicito una variabile intera e che la modifichi al suo interno incrementando il valore di una unita'. 
Il tipo di dati restituito dal metodo e' void.

Stampare a video il contenuto della variabile prima e dopo l'invocazione dal main del metodo incrementVar() a cui venga passato 
come parametro la variabile precedentemente creata. Il contenuto e' stato modificato?
*/
public class Main {
    public static void incrementAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + 1;
        }
    }

    public static void incrementVar(int value) {
        value++;
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println("L'array e` lungo " + arr.length);
        System.out.println("Stampa delle celle dell'array in ordine: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] => " + arr[i]);
        }
        System.out.println("Stampa delle celle dell'array al rovescio:");
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println("arr[" + i + "] => " + arr[i]);
        }
        incrementAll(arr);
        System.out.println("Stampa delle celle dell'array in ordine dopo l'uso del metodo incrementAll: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] => " + arr[i]);
        }
        int value = 777;
        System.out.println("Value = " + value);
        incrementVar(value);
        System.out.println("Value = " + value);
    }
}