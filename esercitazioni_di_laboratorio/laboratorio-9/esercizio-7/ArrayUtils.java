public class ArrayUtils {

    public static String[] resize(String[] arr) {
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    public static String toString(String[] arr) {
        String str = "";
        str += "[ ";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + ", ";
        }
        str += "]";
        return str;
    }

    public static String toString(int[] arr) {
        String str = "";
        str += "[ ";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + ", ";
        }
        str += "]";
        return str;
    }
}
