import java.util.Scanner;

/*
Scrivere il programma IsMagicSquare che verifichi se un quadrato di numeri è un "quadrato magico".
Una disposizione bidimensionale di numeri con dimensione n x n è un quadrato magico se contiene i numeri interi da 1 a n^2 e se la somma degli elementi 
di ogni riga, di ogni colonna e delle due diagonali principali ha lo stesso valore. Esempi di quadrati magici, con n=4 e n=5:

16      3     2    13
  5    10   11      8
  9      6     7    12
  4    15   14      1

11    18    25     2      9
10    12    19    21     3
 4      6    13    20    22
23      5      7    14    16
17    24      1      8    15

L'utente introduce i numeri del (presunto) quadrato in sequenza, uno o più numeri per riga, senza alcuna relazione con il numero di righe del quadrato:
quando l'utente ha introdotto tutti i numeri e ha chiuso lo standard input, il programma deve intraprendere le azioni seguenti:
verifica che il numero di valori introdotti sia il quadrato di un numero intero n: in caso contrario, il programma termina segnalando un fallimento;
verifica che la sequenza di valori introdotta contenga tutti (e soli) i numeri da 1 a n^2, senza ripetizioni: in caso contrario, il programma termina 
segnalando un fallimento (pensate bene a come implementare questo controllo, si puo' fare, anzi si deve fare, solo con quanto visto finora);
dispone i valori all'interno di un array bidimensionale, riempito per righe seguendo l'ordine con cui sono stati forniti i valori: il primo valore prende 
posto nell'angolo in alto a sinistra, il secondo nella seconda posizione da sinistra della prima riga e così via, riempiendo righe successive del quadrato;
verifica la validità delle regole del quadrato magico, interrompendo la verifica con la segnalazione di fallimento non appena una regola non sia rispettata;
segnala il successo della verifica.
Esempio di input per il primo quadrato:

16 3 2 13 5 10
11 8 9 6 7 12 4
15
14 1
*/
public class Main {
    public static boolean checkMagicSquareValues(int magicSquare[][], int number) {
        for (int row = 0; row < magicSquare.length; row++) {
            for (int column = 0; column < magicSquare[row].length; column++) {
                if (number == magicSquare[row][column]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkMagicSquareRules(int magicSquare[][]) {
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = 0;
        int[] values = new int[0];
        // getting input from user
        // if user inserts a number i enlarge the array and insert that number in the
        // array
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            inputs++;
            values = ArrayUtil.resize(values, inputs);
            values[inputs - 1] = n;
        }
        // checking if user inserted a square number of items in the array
        // if the number is not square quitting the program
        double sq = Math.sqrt((double) inputs);
        if ((Math.floor(sq) - sq) == 0) {
            // rows and columns are the same because they MUST be the same
            int rows = (int) sq;
            int cols = rows;
            // filling magic square with contents of values
            int magicSquare[][] = new int[rows][cols];
            // TODO: redo with 3 for
            int cont = 0;
            for (int i = 0; i < magicSquare.length; i++) {
                for (int j = 0; j < magicSquare[i].length; j++) {
                    magicSquare[i][j] = values[cont];
                    cont++;
                }
            }
            // printing magic square
            for (int i = 0; i < magicSquare.length; i++) {
                System.out.print("[ ");
                for (int j = 0; j < magicSquare[i].length; j++) {
                    System.out.print(magicSquare[i][j] + " ");
                }
                System.out.println("]");
            }
            // checking for each number from 1 to n^2
            boolean flagNumbersNotCorrect = false;
            for (int i = 1; i < inputs; i++) {
                if (checkMagicSquareValues(magicSquare, i) == false) {
                    flagNumbersNotCorrect = true;
                }
            }
            // check if numbers have been inserted correctly
            if (flagNumbersNotCorrect) {
                System.out.println("Non hai inserito correttamente i numeri nel quadrato");
                System.exit(1);
            }
            // check magic square rules
            checkMagicSquareRules(magicSquare);
            // output
        } else {
            System.out.println("Non hai formato un quadrato con i valori inseriti");
        }
    }
}