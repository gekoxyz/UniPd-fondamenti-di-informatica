// Scrivere un programma ProvaVariabili che:
// - Definisca una variabile intera larghezza e la inizializzi a 20;
// - Definisca una variabile intera lunghezza e la inizializzi a 30;
// - Modifichi il valore di largezza attribuendogli il valore 40;
// - Modifichi il valore di lunghezza aggiungendo 15 al suo attuale valore
// - Stampi in output il messaggio "L'area del tavolo e' "
// - Stampi in output il prodotto dei valori delle variabili larghezza e lunghezza

public class ProvaVariabili {
    public static void main(String[] args) {
        int larghezza = 20;
        int lunghezza = 30;
        larghezza = 40;
        lunghezza += 15;
        System.out.println("L'area del tavolo e`: " + lunghezza * larghezza);
    }
}