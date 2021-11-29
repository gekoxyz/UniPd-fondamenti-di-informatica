/*
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
*/
public class Interruttore {
    private boolean interruttore;

    public Interruttore() {
        this.interruttore = false;
    }

    public static boolean isBulbOn(Interruttore interruttore1, Interruttore interruttore2) {
        if ((!interruttore1.getStatusInterruttore() && !interruttore2.getStatusInterruttore())
                || (interruttore1.getStatusInterruttore() && interruttore2.getStatusInterruttore())) {
            return false;
        }
        return true;
    }

    public boolean getStatusInterruttore() {
        return interruttore;
    }

    public void changeStatus() {
        if (interruttore) {
            interruttore = false;
        } else {
            interruttore = true;
        }
    }

    public String printStatus() {
        if (interruttore) {
            return "lampadina accesa";
        } else {
            return "lampadina spenta";
        }
    }
}
