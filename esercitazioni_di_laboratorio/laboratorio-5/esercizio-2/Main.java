/*
Realizzare una classe ComLine in cui si inseriscano dei parametri da linea di comando, ad esempio, in esecuzione: java ComLine 3 ciao 48

Se non vengono inseriti parametri riportare a standard output il messaggio: "Non sono stati inseriti parametri", altrimenti elencare, in 
ordine, uno sotto l'altro, i parametri inseriti.
*/

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        } else {
            System.out.println("Non sono stati inseriti paramatri");
        }
    }
}