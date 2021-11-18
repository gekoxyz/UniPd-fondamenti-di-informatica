import java.util.Scanner;

import javax.swing.plaf.synth.SynthProgressBarUI;

/*
Progettare due programmi eseguibili EncodeCeasar.java e DecodeCeasar.java che codifichino e decodifichino un messaggio.

Il programma EncodeCeasar dovra' leggere in ingresso una stringa, trasformarla tutta in lettere maiuscole (per semplicita') 
e leggere un numero intero compreso tra 1 e 25. Il programma dovra' stampare in output la stringa codificata secondo il cifrario 
di Cesare (dovranno essere convertite solo le lettere e si assume che il cifrario si ciclico, ovvero se devo codificare la lettera Z 
con scorrimento 4 il risultato sara' la lettera D.

Il programma DecodeCeasar dovra' leggere in ingresso una stringa codificata con il Cifrario di Cesare e un numero che indichi lo scorrimento 
e stampare in uscita il messaggio originale.
*/
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in); 
        EncodeCaesar encodeCaesar = new EncodeCaesar();
        DecodeCaesar decodeCaesar = new DecodeCaesar();

        System.out.println("Inserisci la Stringa da cifrare");
        String toEncrypt = scan.nextLine();
        System.out.println("Inserisci lo shift compreso tra 1 e 25");
        int shift = scan.nextInt();
        scan.close();
        String encrypted = encodeCaesar.encrypt(toEncrypt, shift);
        System.out.println("Your String: " + toEncrypt);
        System.out.println("Encrypted String: " + encrypted);
        String decrypted = decodeCaesar.decrypt(encrypted, shift);
        System.out.println("Decrypted String: " + decrypted);
    }
}
