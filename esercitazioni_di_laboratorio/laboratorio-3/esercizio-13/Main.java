/*
Progettare il programma EvenNumber che:

• chieda all'utente di fornire un numero pari (ovviamente intero...)

• se il numero fornito è dispari, chieda di nuovo all'utente di fornire un numero pari, dopo aver 
visualizzato una segnalazione d'errore

• se il numero fornito (al primo o secondo tentativo) è pari, scriva un messaggio di congratulazioni 
all'utente, riportando anche il numero fornito (es. "Bravo! Il numero 26 è pari")

• se, invece, neanche il secondo numero fornito è pari, scriva un messaggio di disappunto Attenzione: 
se il primo numero fornito è pari, il programma NON deve chiedere un secondo numero. 
*/
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
    	Scanner scan = new Scanner(System.in);
	int flag = 0;
	for(int i = 0; i<2; i++){
	    System.out.println("inserisci un numero intero pari");
	    int num = scan.nextInt();
	    if (num % 2 == 0){
	    	System.out.println("Bravo! Il numero " + num + " e` pari");
		break;
	    } else {
	    	flag++;
	    }
	}
	if (flag == 2){
	    System.out.println("Attenzione: se il primo numero fornito e` pari, il programma NON deve chiedere un secondo numero.");
	}
    }
}
