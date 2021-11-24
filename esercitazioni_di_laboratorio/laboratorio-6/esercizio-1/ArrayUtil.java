/*
Aggiungere alla classe ArrayUtil gli algoritmi su array visti a lezione utilizzando array riempiti solo in parte.
*/
public class ArrayUtil {
    public ArrayUtil() {
    }

    public static int[] resize(int[] oldArray, int newLength) {
        int newArray[] = new int[newLength];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    public static double[] resize(double[] oldArray, int newLength) {
        double newArray[] = new double[newLength];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    /*
     * generazione di un array di interi di numeri casuali (randomIntArray); public
     * static int[] randomIntArray(int length, int n)
     */
    public static int[] randomIntArray(int length, int n) {
        int array[] = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (n * Math.random());
        }
        return array;
    }

    /*
     * stampare il contenuto di un array (printArray); public static String
     * printArray(int[] v, int vSize)
     */
    public static void printArray(int v[], int vSize) {
        System.out.print("[");
        for (int i = 0; i < vSize; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("]");
    }

    /*
     * eliminare un elemento (ordine non importante); public static void
     * remove(int[] v, int vSize, int index)
     */
    public static void remove(int v[], int vSize, int index) {
        if (vSize > 0 && index < vSize) {
            v[index] = v[vSize];
            vSize--;
        }
    }

    /*
     * eliminare un elemento (ordine importante) public static void
     * removeSorted(int[] v, int vSize, int index)
     */
    public static void removeSorted(int v[], int vSize, int index) {
        if (vSize > 0 && index < vSize) {
            for (int i = index; i < vSize - 1; i++) {
                v[i] = v[i + 1];
            }
            vSize--;
        }
    }

    /*
     * inserire un elemento public static void insert(int[] v, int vSize, int index,
     * int value)
     */
    public static void insert(int v[], int vSize, int index, int value) {
        if (index < vSize + 1) {
            for (int i = vSize; i > index; i--) {
                v[i] = v[i - 1];
            }
            v[index] = value;
            vSize++;
        }
    }

    /*
     * ricerca del minimo public static int findMin(int[] v, int vSize)
     */
    public static int findMin(int v[], int vSize) {
        if (vSize > 0) {
            int min = v[0];
            for (int i = 1; i < vSize; i++) {
                if (v[i] < min) {
                    min = v[i];
                }
            }
            return min;
        }
        return 0;
    }

    /*
     * ricerca del massimo public static int findMin(int[] v, int vSize)
     */
    public static int findMax(int v[], int vSize) {
        if (vSize > 0) {
            int max = v[0];
            for (int i = 1; i < vSize; i++) {
                if (v[i] > max) {
                    max = v[i];
                }
            }
            return 0;
        }
        return 0;
    }

    /*
     * ricerca di un valore in modo sequenziale public static int find(int[] v, int
     * vSize, int target)
     */
    public static boolean find(int v[], int vSize, int target) {
        if (vSize > 0) {
            for (int i = 0; i < vSize; i++) {
                if (v[i] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}