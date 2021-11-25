import java.util.Arrays;

import javax.xml.namespace.QName;

public class test {
    public static void main(String[] args) {
        // int numbers[] = new int[10];
        // String temp = "1 23 456";
        // int index = 0;
        // String buf = "";
        // for (int i = 0; i < temp.length(); i++) {
        // if (Character.isWhitespace(temp.charAt(i))) {
        // numbers[index] = Integer.parseInt(buf);
        // index++;
        // buf = "";
        // } else {
        // buf += temp.charAt(i);
        // System.out.println(buf);
        // }
        // }
        // numbers[index] = Integer.parseInt(buf);
        // System.out.println(Arrays.toString(numbers));
        int matrix[][] = new int[3][3];
        int j = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = j;
                System.out.println("filling with: " + j);
                j++;
            }
        }
        System.out.println("printing the matrix");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[ ");
            for (int column = 0; column < matrix[row].length; column++) {
                // System.out.print(matrix[row][column] + " ");
                
            }
            System.out.println("]");
        }

    }
}
