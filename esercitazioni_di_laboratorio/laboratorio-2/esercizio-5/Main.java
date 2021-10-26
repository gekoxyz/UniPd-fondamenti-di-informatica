/*
Esercizio 5
Obiettivo: esercitarsi nella definizione e utilizzo di variabili numeriche e stampa di risultati.

 Scrivere un programma che:

- definisca una variabile per memorizzare il valore del raggio di un cilindro pari a 10.12;

- definisca una variabile per memorizzare il valore dell'altezza di un cilindro pari a 10.87

- definisca una costante per rappresentare pi-greco come nell'esercizio precedente

- calcoli il valore dell'area della base del cilindro e lo memorizzi in un'apposita variabile

- memorizzi il valore del volume del cilindro in una nuova variabile

- invii a standard output il seguente messaggio:   "***Il volume del cilindro di raggio ... e altezza ... e' pari a ...***"   dove al posto dei caratteri ... ci siano i valori del raggio, dell'altezza e del volume del cilindro.

NB: Quando sia necessario usare la costante π, non la si definisca come nell'esercizio precedente, ma si usi la costante Math.PI definita nella classe java.lang.Math */
public class Main {
    public static void main(String[] args) {
        double radius = 10.12;
        double height = 10.87;
        final double PI = Math.PI;
        double baseArea = radius * radius * PI;
        double volume = baseArea * height;
        System.out.println(
                "Il volume del cilindro di raggio " + radius + " e altezza " + height + " e` pari a " + volume);
    }
}
