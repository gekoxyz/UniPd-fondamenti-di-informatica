/*
Implementare gli algoritmi di ordinamento visti (selection sort, mergesort e insertionsort) 
per gli interi come metodi statici di una classe ArrayAlgs.
*/
public class ArrayAlgs {
    public static int[] selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos])
                    minPos = j;
            }
            // sawp minPos and i
            int temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
        }
        return array;
    }

    public static void recursiveMergeSort(int array[]) {
        if (array.length < 2)
            return;
        int mid = array.length / 2;
        int left[] = new int[mid];
        int right[] = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);
        recursiveMergeSort(left);
        recursiveMergeSort(right);
        // merge arrays
        int iArr = 0, iLeft = 0, iRight = 0;
        while (iLeft < left.length && iRight < right.length) {
            if (left[iLeft] < right[iRight])
                array[iArr++] = left[iLeft++];
            else
                array[iArr++] = right[iRight++];
            while (iLeft < left.length)
                array[iArr++] = left[iLeft++];
            while (iRight < right.length)
                array[iArr++] = right[iRight++];
        }
    }

    public static int[] insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    public static int[] randomSort() {
        return null;
    }
}
