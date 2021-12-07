import java.util.Scanner;

/*
Scrivere una classe eseguibile RecFib.java il cui metodo main
    riceva un numero intero dalla riga di comando, oppure (nel caso in cui non vengano forniti 
    argomenti sulla riga di comando) chieda all'utente un numero intero n
    visualizzi l'n-esimo numero di Fibonacci, calcolato usando un algoritmo ricorsivo

Scrivere una classe eseguibile IterFib.java il cui metodo main 
    riceva un numero intero dalla riga di comando, oppure (nel caso in cui non vengano forniti 
    argomenti sulla riga di comando) chieda all'utente un numero intero n
    visualizzi l'n-esimo numero di Fibonacci, calcolato usando un algoritmo iterativo

Si consiglia di scrivere due metodi ausiliari statici, recursiveFib e iterativeFib, invocati da ciascun 
metodo main della rispettiva classe per realizzare il comportamento sopra indicato. Entrambi i metodi 
ricevono un parametro n di tipo int e (dopo aver verificato la pre-condizione che n non sia negativo) 
restituiscono un valore di tipo long che rappresenta l'n-esimo numero Fib(n) nella sequenza di Fibonacci.

    Il metodo recursiveFib calcola il valore da restituire usando la ricorsione doppia, implementando 
    direttamente la definizione della serie
    Il metodo iterativeFib deve calcolare il valore da restituire senza usare la ricorsione e senza usare 
    strutture dati di memorizzazione (ossia senza array, ma usando soltanto variabili semplici).

Nei metodi main invocare System.currentTimeMillis() prima e dopo la chiamata al metodo statico e riportare 
il tempo di esecuzione. Se i tempi non dovessero essere rilevabili in termini di millisecondi potete utilizzare 
il metodo System.nanoTime()

Provare a lanciare i due programmi piu' volte (giusto per vedere che i tempi sono simili ma non necessariamente 
uguali per uno stesso algoritmo e uno stesso n, specie al crescere di n) su input crescente.

Verificare la differenza nell'andamento dei tempi di esecuzione tra i due algoritmi.
*/
public class Main {
    public static long recursiveFibonacci(int n) {
        if (n < 2)
            return n;
        return recursiveFibonacci(n - 2) + recursiveFibonacci(n - 1);
    }

    public static long iterativeFibonacci(int n) {
        long f1 = 0L;
        long f2 = 1L;
        for (int i = 0; i < n - 1; i++) {
            long f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci un numero: ");
            n = scanner.nextInt();
            scanner.close();
        }
        long iterativeFibonacci = iterativeFibonacci(n);
        long recursiveFibonacci = recursiveFibonacci(n);
        System.out.println("Successione di fibonacci di " + n + ": " + iterativeFibonacci + " (iterativa)");
        System.out.println("Successione di fibonacci di " + n + ": " + recursiveFibonacci + " (ricorsiva)");
    }
}