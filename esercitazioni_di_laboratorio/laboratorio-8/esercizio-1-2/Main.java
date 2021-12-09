import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(array));
        // selection sort
        long selectionSortStartTime = System.currentTimeMillis();
        int selectionSorted[] = ArrayAlgs.selectionSort(array);
        long selectionSortEndTime = System.currentTimeMillis();
        long selectionSortExecTime = selectionSortEndTime - selectionSortStartTime;
        System.out.println("Selection sort\t\texecution time: " + selectionSortExecTime + " ms");
        System.out.println(Arrays.toString(selectionSorted));
        // insertion sort
        long insertionSortStartTime = System.currentTimeMillis();
        int insertionSorted[] = ArrayAlgs.insertionSort(array);
        long insertionSortEndTime = System.currentTimeMillis();
        long insertionSortExecTime = insertionSortEndTime - insertionSortStartTime;
        System.out.println("Insertion sort\t\texecution time: " + insertionSortExecTime + " ms");
        System.out.println(Arrays.toString(insertionSorted));
        // merge sort
        long recursiveMergesortStartTime = System.currentTimeMillis();
        int recursiveMergeSorted[] = ArrayAlgs.insertionSort(array);
        long recursiveMergeSortEndTime = System.currentTimeMillis();
        long recursiveMergeSortExecTime = recursiveMergeSortEndTime - recursiveMergesortStartTime;
        System.out.println("Recursive merge sort\texecution time: " + recursiveMergeSortExecTime + " ms");
        System.out.println(Arrays.toString(recursiveMergeSorted));
    }
}