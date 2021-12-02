import java.util.Scanner;

/*
Scrivere una classe eseguibile Risiko.java che effettua le seguenti operazioni:
- acquisisce da standard input il nome del primo giocatore 
- acquisisce da standard input il nome del secondo giocatore
- definisce un oggetto di classe Player per ciascuno dei due giocatori
- lancia tre volte il dado per ciascun giocatore (si usa il metodo turno())
- stampare i risultati di ciascun giocatore (stampare implicitamente con
  toString())
- dichiari un riferimento ad un array di interi e gli assegni il risultato
  dell'invocazione del metodo sortDice() per il primo giocatore
- stampare i valori ordinati dei lanci seguite dal nome del giocatore
- ripetere le due operazioni precedenti per il secondo giocatore
- confrontore i risultati ottenuti nei lanci dai due giocatori assegnando un punto (chiamata al metodo addScore()) al giocatore che vince ciascun confronto
-verificare chi sia il vincitore e stampare in uscita il nome e i punteggi
- invia a standard output il risultato dei lanci
- calcola il vincitore e invia il risultato a standard output (metodo String vincitore(...)).

In esecuzione la classe Risiko dovra' produrre un risultato simile al seguente:

$ java Risiko
Giocatore n. 1? Pippo
Giocatore n. 2? Pluto
lanci di Pippo: 2 3 1
lanci di Pluto: 6 6 2
lanci ordinati
1 2 3  Pippo
2 6 6  Pluto
Pluto vince 3 a 0
*/
public class Risiko {
    public static String arrayToString(int array[]) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + " ";
        }
        return str;
    }

    public static String winner(int pointsPlayer1, String player1Name, int pointsPlayer2, String player2Name) {
        if (pointsPlayer1 > pointsPlayer2) {
            return player1Name + " vince " + pointsPlayer1 + " a " + pointsPlayer2;
        } else {
            return player2Name + " vince " + pointsPlayer2 + " a " + pointsPlayer1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il nome del primo giocatore: (senza spazi)");
        String player1Name = scan.next();
        System.out.println("Inserisci il nome del secondo giocatore: (senza spazi)");
        String player2Name = scan.next();
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        // lanciare 3 volte il dado per ogni giocatore usando turno();
        player1.turn();
        player2.turn();
        // stampare i risultati con toString
        System.out.println(player1Name + " ha lanciato: " + player1.toString());
        System.out.println(player2Name + " ha lanciato: " + player2.toString());
        // dichiarazione array di interi e assegnazione del sortDice
        int player1Throws[] = player1.sortDice();
        // stampare i valori ordinati dei lanci seguite dal nome del giocatore
        System.out.println(player1Name + " " + arrayToString(player1Throws));
        // dichiarazione array di interi e assegnazione del sortDice
        int player2Throws[] = player2.sortDice();
        // stampare i valori ordinati dei lanci seguite dal nome del giocatore
        System.out.println(player2Name + " " + arrayToString(player2Throws));
        // confrontare i risultati ottenuti nei lanci dai due giocatori assegnando un
        // punto usando il metodo addScore al giocatore che vince ciascun confronto
        for (int i = 0; i < player2Throws.length; i++) {
            if (player1Throws[i] > player2Throws[i]) {
                player1.addPoint();
            } else {
                player2.addPoint();
            }
        }
        // verificare il vincitore e stampare in uscita il nome e i punteggi
        System.out.println(winner(player1.getScore(), player1Name, player2.getScore(), player2Name));
    }
}