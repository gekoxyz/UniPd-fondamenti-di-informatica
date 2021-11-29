import java.util.Scanner;

/*
Scrivere la classe Interruttore i cui oggetti rappresentano degli interruttori. Ogni interruttore 
puo' assumere due stati, con il significato che l'interruttore sia su' o giu' (up/down nella descrizione 
testuale da riportare in output ma gestibile con una variabile booleana). Tutti gli interruttori sono 
collegati ad una stessa lampadina regolandone l’accensione e spegnimento. Ogni volta che un interruttore 
cambia stato, anche la lampadina cambia stato (accesa-> spenta, spenta->accesa).

La classe deve contenere: tutte le variabili d’istanza e le variabili statiche ritenute necessarie a descriverne 
lo stato e i seguenti costruttori e metodi:

// Costruttore: inizializza l'interruttore in stato "down"
// Assumiamo "down" corrisponda a false e "up" a true
public Interruttore();

// Metodo di accesso della variabile di esemplare interruttore
public boolean getStatusInterruttore();

//Metodo di accesso alla variabile statica lampadina
public boolean isBulbOn();

//Modificatore: cambia lo stato dell'interruttore 
//(e della lampadina!)
public void changeStatus();

//Stampa lo stato dell'interruttore: up/down a seconda 
// che status sia true o false

public String printStatus();

Per testare la classe, scrivere un programma TestInterruttore che crea due interruttori (oggetti della classe 
Interruttore) e poi, in maniera iterativa, offre all’utente la possibilita' di agire su uno dei due interruttori 
(visualizzando l’esito dell’operazione) a seconda che venga inserito il numero 1 o 2, o di terminare l’esecuzione 
se l'input e' 0.
*/
public class TestInterruttore {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Interruttore interruttore1 = new Interruttore();
        Interruttore interruttore2 = new Interruttore();
        boolean active = true;
        System.out.println("Inserisci 1 per usare l'interruttore 1, 2 per l'interruttore 2 e 0 per uscire");
        while (active) {
            System.out.println("Interruttore 1: " + interruttore1.printStatus());
            System.out.println("Interruttore 2: " + interruttore2.printStatus());
            if (Interruttore.isBulbOn(interruttore1, interruttore2)) {
                System.out.println("Lampadina accesa");
            } else {
                System.out.println("Lampadina spenta");
            }
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    interruttore1.changeStatus();
                    break;
                case 2:
                    interruttore2.changeStatus();
                    break;
                case 0:
                    active = false;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
