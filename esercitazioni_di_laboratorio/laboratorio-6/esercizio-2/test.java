import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int numbers[] = new int[10];
        String temp = "1 23 456";
        int index = 0;
        String buf = "";
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isWhitespace(temp.charAt(i))) {
                numbers[index] = Integer.parseInt(buf);
                index++;
                buf = "";
            } else {
                buf += temp.charAt(i);
                System.out.println(buf);
            }
        }
        numbers[index] = Integer.parseInt(buf);
        System.out.println(Arrays.toString(numbers));
    }
}
