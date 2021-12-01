import java.util.Scanner;

/*Scrivere un programma per giocare a "tris" (tic-tac-toe in inglese), il classico gioco in cui due giocatori 
dispongono alternativamente un proprio contrassegno in una casella di una scacchiera 3 x 3 finché uno dei due 
non pone tre contrassegni in una fila orizzontale, verticale o diagonale.

Risolvere il problema in due passi
    Scrivere una classe MyTris che rappresenti la scacchiera e la cui interfaccia pubblica è definita
    https://elearning.dei.unipd.it/pluginfile.php/829897/mod_book/chapter/5083/MyTris.html
    Scrivere poi una classe eseguibile che usi MyTris, e che gestisca una partita a tris tra due giocatori, 
    seguendo il comportamento descritto sopra.
*/

public class Main {

    public static int[] move(String playerName, char token) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(playerName + " dove vuoi inserire " + token + "?");
        String position = scanner.nextLine();
        int row = Character.getNumericValue(position.charAt(0));
        int column = Character.getNumericValue(position.charAt(2));
        return new int[] { row, column };
    }

    public static void checkWin(String playerName, boolean won) {
        if (won) {
            System.out.println(playerName + " ha vinto");
        }
    }

    public static void main(String[] args) {
        MyTris myTris = new MyTris();
        int move[];
        boolean won = false;
        int moves = 0;
        while (!won) {
            // printing the board for the players
            System.out.println(myTris.toString());
            // player 1 moves
            move = move("Player1", 'X');
            myTris.setCharInPosition(move[0], move[1], 'X');
            moves++;
            // check win (after 5 moves)
            if (moves > 4) {
                won = myTris.isWinning('X');
                System.out.println(myTris.toString());
                checkWin("Player1", won);
                break;
            }
            // printboard
            System.out.println(myTris.toString());
            // player 2 moves
            move = move("Player2", 'O');
            myTris.setCharInPosition(move[0], move[1], 'O');
            moves++;
            // check win (after 5 moves)
            if (moves >= 5) {
                won = myTris.isWinning('O');
                System.out.println(myTris.toString());
                checkWin("Player2", won);
            }
        }
    }
}
