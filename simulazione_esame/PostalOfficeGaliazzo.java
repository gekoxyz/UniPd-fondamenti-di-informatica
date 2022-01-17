
// Matteo Galiazzo
import java.util.Random;

public class PostalOfficeGaliazzo {
    public static void main(String[] args) {
        int time = Integer.parseInt(args[0]);
        Random random = new Random(123);
        Sportello sportelli[] = new Sportello[5];
        for (int i = 0; i < sportelli.length; i++) {
            sportelli[i] = new Sportello();
        }
        for (int i = 0; i < time; i++) {
            int waitTime = random.nextInt(14) + 1;
            int insertionIndex = minSizeQueue(sportelli);
            sportelli[insertionIndex].enqueue(waitTime);
            System.out.println("Nuovo cliente con pratica " + waitTime + " minuti inserito in coda allo sportello "
                    + insertionIndex);
            for (int j = 0; j < sportelli.length; j++) {
                if (!sportelli[j].isEmpty())
                    sportelli[j].dequeue();
                System.out.println(sportelli[j].toString());
            }
        }
    }

    public static int minSizeQueue(Sportello[] p) {
        int min = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[min].getSize() > p[i].getSize()) {
                min = i;
            }
        }
        return min;
    }
}
