/*
Scrivere una classe eseguibile avente il funzionamento seguente:
    se sulla linea di comando vengono forniti due o piu' parametri, oppure nessun parametro, 
    il programma termina con una segnalazione di errore
    altrimenti 
    se il parametro fornito non è un numero intero positivo, il programma termina con una 
    segnalazione di errore
    se il parametro ricevuto e' un numero intero positivo, il programma visualizza 
    sull'uscita la somma dei primi n numeri interi calcolata con un algoritmo ricorsivo. 
*/
public class Main {

    public static int sumPositiveInteger(int sum) {
        if (sum == 1)
            return sum;
        return sum + sumPositiveInteger(--sum);
    }

    public static void main(String args[]) {
        if (args.length == 1) {
            if (Double.parseDouble(args[0]) == Integer.parseInt(args[0]) && Integer.parseInt(args[0]) >= 0) {
                int totalSum = sumPositiveInteger(Integer.parseInt(args[0]));
                System.out.println("La somma dei primi " + args[0] + " numeri naturali e`: " + totalSum);
            } else {
                System.out.println("Il parametro deve essere un numero intero positivo");
            }
        } else {
            System.out.println("Devi inserire un parametro");
        }
    }
}