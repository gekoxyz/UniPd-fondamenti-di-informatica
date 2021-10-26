/*
Esercizio 9

Scrivere un programma di collaudo Bonifico.java per la classe BankAccount (di cui dovreste gia' disporre del bytecode, altrimenti lo trovate nella cartella "File utili e soluzioni degli esercizi" oppure potete produrlo compilando una classe BankAccount che potete realizzare voi stessi, come visto a lezione) in cui:

    Creare due conti bancari (account1 e account2).
    Depositare in account1 1000 euro
    Depositare in account2 100 euro
    Stampare a video il valore del saldo di ciascun conto
    Prelevare da account1 400 euro e depositare la stessa quantita' in account2.
    Stampare a video il valore del saldo di ciascun conto. 

Abbiamo simulato un bonifico dal primo conto al secondo!*/
public class Bonifico {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.deposit(1000);
        account2.deposit(100);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());
        account1.withdraw(400);
        account2.deposit(400);
        System.out.println("account1 balance: " + account1.getBalance());
        System.out.println("account2 balance: " + account2.getBalance());
    }
}
