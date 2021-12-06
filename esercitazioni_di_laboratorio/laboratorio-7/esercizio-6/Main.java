/*
Scrivere una classe eseguibile avente il funzionamento seguente:
    - se sulla linea di comando vengono forniti più o meno di due parametri, il programma 
    termina con una segnalazione di errore
    - altrimenti
        - se uno dei due parametri ricevuti non è un numero intero positivo, il programma 
        termina con una segnalazione di errore
        - se entrambi i parametri ricevuti sono numeri interi positivi, il programma visualizza 
        sull'uscita standard il M.C.D. tra i due numeri ricevuti, calcolato con un algoritmo ricorsivo. 
Si scriva un metodo statico ausiliario, recursiveMCD, invocato dal metodo main per realizzare il 
comportamento sopra indicato. Tale metodo calcola ricorsivamente il massimo comun divisore (MCD) fra 
due numeri interi positivi m ed n (con m>n), ricevuti come parametri espliciti, usando il noto Algoritmo 
di Euclide:
    - se n è un divisore di m, allora n è il M.C.D. tra m ed n
    - altrimenti, il M.C.D. di m ed n è uguale al M.C.D. di n e del resto della divisione intera di m per n
*/
public class Main {
    public static void main(String[] args) {

    }
}