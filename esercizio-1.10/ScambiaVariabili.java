// Scrivere un programma per scambiare il contenuto di due variabili, ma...
// scambiare i valori di a e b senza usare una variabile temporanea per memorizzare uno dei due valori 

// NB: potete usare solo assegnazioni e le operazioni che abbiamo visto finora 
// (somma/sottrazione/moltiplicazione/divisione/modulo, non potete utilizzare operazioni bit-a-bit, 
// operatori booleani, o altro che non sia stato spiegato a lezione), quindi tutti possono risolvere 
// il quesito, ma non e' banale. 

public class ScambiaVariabili {
    public static void main(String[] args) {
        int x = 5;
        int y = 2;
        System.out.println("Prima dello scambio:\nx: " + x + "\ty: " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("Dopo lo scambio\nx: " + x + "\ty: " + y);

    }
}
