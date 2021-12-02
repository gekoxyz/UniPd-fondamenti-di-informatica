import java.util.Random;

public class Player {
    private String name;
    private int score;
    private int[] diceThrows = new int[3];

    // costruttore: il punteggio iniziale e' 0 cosi' come
    // i valori dei tiri dei tre dadi
    public Player(String aName) {
        this.name = aName;
    }

    // metodi di accesso
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // simula un turno di lancio di dadi attribuendo a ciascun
    // lancio un valore casuale tra 1 e 6
    public void turn() {
        Random random = new Random();
        for (int i = 0; i < diceThrows.length; i++) {
            diceThrows[i] = random.nextInt(6) + 1;
        }
    }

    // restituisce un riferimento a un nuovo array di interi in
    // cui i valori ottenuti nei tre lanci sono ordinati
    public int[] sortDice() {
        int newArray[] = diceThrows;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < newArray.length - 1; i++) {
                if (diceThrows[i] > diceThrows[i + 1]) {
                    int temp = diceThrows[i];
                    diceThrows[i] = diceThrows[i + 1];
                    diceThrows[i + 1] = temp;
                    swap = true;
                }
            }
        }
        return newArray;
    }

    // aggiorna il punteggio incrementandolo di una unita'
    public void addPoint() {
        score++;
    }

    // resetta il punteggio
    public void resetScore() {
        score = 0;
    }

    // restituisce una stringa con il nome del giocatore e
    // i valori dei lanci dei dadi
    public String toString() {
        return diceThrows[0] + " " + diceThrows[1] + " " + diceThrows[2];
    }

}