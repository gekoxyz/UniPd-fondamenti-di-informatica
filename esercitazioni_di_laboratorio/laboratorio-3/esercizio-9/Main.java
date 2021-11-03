import java.util.Scanner;

/*

Scrivere il programma PrintTimeInterval.java che legga dall'input standard due orari nel formato "24 ore",
ciascuno di quattro cifre (ad esempio, 0900 oppure 1730), con il secondo orario successivo al primo 
visualizzi sull'output standard il numero di ore e di minuti (separatamente) che intercorrono fra i 
due orari secondo il seguente esempio

Inserire il primo orario: 0900
Inserire il secondo orario: 1730
Tempo trascorso: 8 ore e 30 minuti
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String time1 = "", time2 = "";
        System.out.println("Inserisci il primo orario: ");
        time1 = scan.next();
        System.out.println("Inserisci il secondo orario: ");
        time2 = scan.next();
        scan.close();
        int time1Hours = 0, time1Minutes = 0, time2Hours = 0, time2Minutes = 0;
        try {
            time1Hours = Integer.parseInt(time1.substring(0, 2));
            time1Minutes = Integer.parseInt(time1.substring(2, 4));
            time2Hours = Integer.parseInt(time2.substring(0, 2));
            time2Minutes = Integer.parseInt(time2.substring(2, 4));
        } catch (NumberFormatException e) {
            System.out.println("Hai inserito uno degli orari in modo sbagliato");
        }
        int hoursDifference = time2Hours - time1Hours;
        int minutesDifference = 0;
        if (time2Minutes < time1Minutes) {
            hoursDifference--;
            minutesDifference = time2Minutes + 60 - time1Minutes;
        } else {
            minutesDifference = time2Minutes - time1Minutes;
        }
        System.out.println("Tempo trascorso: " + hoursDifference + " ore e " + minutesDifference + " minuti");
    }
}