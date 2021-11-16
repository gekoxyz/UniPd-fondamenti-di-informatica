import java.util.Scanner;

/*
Leggere da standard input una stringa definita sull'alfabeto del DNA (A,C,G,T). Dopo aver verificato che non siano presenti altri caratteri, 
inviare a standard output una la stringa "inversa-complementare" cosi' definita: i) Ad ogni A della stringa originale corrisponde una T; 
ii) Ad ogni T della stringa originale corrisponde una A; Ad ogni C della stringa originale corrisponde una G; Ad ogni G della stringa originale 
corrisponde una C; la stringa viene invertita (l'ultimo carattere e' il primo).

Esempio:

input: ACCTGGTAC

output: GTACCAGGT
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String complementaryDna = "";
        boolean flag = false;
        System.out.println("Inserisci una stringa formata dai caratteri: A, C, G, T");
        String dna = scan.nextLine();
        scan.close();
        for (int i = dna.length() - 1; i >= 0; i--) {
            switch (dna.charAt(i)) {
            case 'A':
                complementaryDna += 'T';
                break;
            case 'C':
                complementaryDna += 'G';
                break;
            case 'G':
                complementaryDna += 'C';
                break;
            case 'T':
                complementaryDna += 'A';
                break;
            default:
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("Inversa complementare: " + complementaryDna);
        } else {
            System.out.println("hai inserito una stringa non valida");
        }
    }
}