import java.util.Scanner;

/*
Progettare il programma PrintSelectedMonth che chieda all'utente un numero intero compreso 
tra 1 e 12 e visualizzi il nome del mese corrispondente, come in questo esempio di funzionamento:

Inserisci il numero del mese (1-12): 5
Maggio

Non potete utilizzare ne' l'enunciato IF, ne' gli array (che non abbiamo ancora visto). 
Il problema cosi' è abbastanza difficile, ma provateci! 
*/
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci il numero di un mese");
		int monthNumber = scan.nextInt();
		String c1 = "GFMAMGLASOND";
		String c2 = "eeapaiugetoi";
		String c3 = "nbrrgugottvc";
		String c4 = "nbzigglstoee";
		String c5 = "arolinitebmm";
		String c6 = "ia eoooomrbb";
		String c7 = "oi      berr";
		String c8 = " o      r ee";
		String c9 = "        e   ";
		System.out.println("Mese: " + c1.charAt(monthNumber) + c2.charAt(monthNumber) + c3.charAt(monthNumber)
				+ c4.charAt(monthNumber) + c5.charAt(monthNumber) + c6.charAt(monthNumber) + c7.charAt(monthNumber)
				+ c8.charAt(monthNumber) + c9.charAt(monthNumber));

	}
}
