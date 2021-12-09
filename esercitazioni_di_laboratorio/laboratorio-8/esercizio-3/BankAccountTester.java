import java.util.Scanner;

/*
Modificare la classe BankAccount vista a lezione, con le seguenti diverse specifiche:
    i metodi deposit e withdraw restituiscono un valore di tipo logico, true se e solo se l'operazione 
    è ammissibile e va a buon fine, ma non devono visualizzare nessun messaggio d'errore nel caso in cui 
    non vada a buon fine (semplicemente, restituiscono false);
    se l'operazione non è ammissibile, il saldo del conto non deve essere modificato;
    un versamento va a buon fine se e solo se l'importo che viene versato è maggiore di zero;
    un prelievo va a buon fine se e solo se l'importo che viene prelevato è maggiore di zero e minore o 
    uguale al saldo del conto.
Scrivere il programma BankAccountTester che crea un conto bancario (esemplare della classe appena progettata) 
e accetta ripetutamente comandi dall'utente, introdotti da tastiera, finché non viene introdotto il comando Q 
di terminazione del programma.
I comandi disponibili sono:
Q 	Quit: termina il programma
B 	Balance: visualizza il saldo del conto
D x 	Deposit: versa nel conto la somma x
W x 	Withdraw: preleva dal conto la somma x
A x 	Add interest: accredita sul conto gli interessi, calcolati in base alla percentuale x del saldo attuale (x deve essere positivo)
*/
public class BankAccountTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount();
        boolean active = true;
        double amount;
        while (active) {
            String input = scanner.nextLine();
            switch (input.charAt(0)) {
                case 'Q':
                    active = false;
                    break;
                case 'B':
                    System.out.println("Balance: " + bankAccount.getBalance());
                    break;
                case 'D':
                    amount = Double.parseDouble(input.substring(2));
                    bankAccount.deposit(amount);
                    break;
                case 'W':
                    amount = Double.parseDouble(input.substring(2));
                    bankAccount.withdraw(amount);
                    break;
                case 'A':
                    amount = Double.parseDouble(input.substring(2));
                    bankAccount.addInterest(amount);
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}