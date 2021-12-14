import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
Scrivere una classe eseguibile StudentManager che gestisce un elenco di studenti.
In una prima fase il programma riceve dall'input standard oppure da file (decidete liberamente)
e memorizza un elenco di dati che rappresentano 
    i nomi di un insieme di studenti
    il voto della prova scritta
    il voto della prova orale

I dati di ciascuno studente sono inseriti in una riga separati da uno spazio (prima il nome, poi il 
voto scritto, poi il voto orale). I dati sono terminati da una riga vuota.
Al termine dell'inserimento, il programma chiede all'utente di inserire un comando per identificare 
l'elaborazione da svolgere.
    se l'utente inserisce il comando Q l'esecuzione termina
    se l'utente inserisce il comando S il programma 
        chiede all'utente di inserire il cognome di uno studente
        se lo studente è presente nell'insieme, ne visualizza il voto finale (calcolato come media 
        aritmetica tra i voti della prova scritta e della prova orale), altrimenti segnala che il 
        cognome e` errato
        chiede un nuovo inserimento di comando (Q o S)
    se il comando inserito è diverso da Q o S, il programma segnala che il comando è errato e chiede 
    un nuovo inserimento di comando

Suggerimenti: 
    Scrivere una classe Student, che rappresenta il tipo di dato "studente" (specificato da nome, voto 
    scritto, e voto orale), e usare un array di oggetti Student per memorizzare l'insieme di studenti 
    nel programma.
    La parte piu` impegnativa di questo esercizio e` la scrittura della classe StudentManager. Si consiglia 
    di individuare le principali operazioni che la classe deve realizzare (ad esempio, creazione di un 
    oggetto Student, ricerca di un oggetto Student nell'array, stampa della media dei voti) e per ciascuna 
    di esse scrivere un metodo statico ausiliario invocato dal metodo main.
    Scrivere la classe in due fasi: in una prima fase realizzare le operazioni richieste senza curarsi di 
    precondizioni e situazioni inaspettate; solo in una seconda fase affrontare il problema della gestione 
    delle eccezioni (in particolare i metodi scritti potranno sia lanciare che catturare eccezioni).
*/
public class Main {
    public static void main(String[] args) {
        Student students[] = new Student[3];
        // get input from file
        FileReader fileReader = null;
        Scanner fileScanner = null;
        try {
            fileReader = new FileReader("./studenti.txt");
            fileScanner = new Scanner(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int index = 0;
        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            String name = lineScanner.next();
            int oralMark = Integer.parseInt(lineScanner.next());
            int writtenMark = Integer.parseInt(lineScanner.next());
            System.out.println("> " + name + "\t" + oralMark + " " + writtenMark);
            students[index] = new Student(name, writtenMark, oralMark);
            index++;
        }
        boolean active = true;
        Scanner scanner = new Scanner(System.in);
        while (active) {
            System.out.println("Cosa vuoi fare?");
            System.out.println("Q - esci dal programma");
            System.out.println("S - cerca uno studente");
            String input = scanner.next();
            switch (input) {
                case "S":
                    // get student name search for student and display marks
                    boolean found = false;
                    index = 0;
                    String toSearch = scanner.next();
                    for (int i = 0; i < students.length; i++) {
                        for (int j = 0; j < students[i].getName().length(); j++) {
                            if (students[i].getName().charAt(j) == toSearch.charAt(j)) {
                                index++;
                            } else {
                                break;
                            }
                            if (index == students[i].getName().length()) {
                                found = true;
                                index = i;
                                break;
                            }
                        }
                        if (found)
                            break;
                    }
                    double marksAvg = (students[index].getOralMark() + students[index].getWrittenMark()) / 2;
                    if (found)
                        System.out.println(students[index].getName() + " " + marksAvg);
                    break;
                case "Q":
                    active = false;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}