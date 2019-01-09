import java.util.*;

public class StringToInt{
    public static void main(String[] args) {

        System.out.println("Please enter a number to be converted to an integer:");
        Scanner scnr = new Scanner(System.in);
        String input = scnr.next();
        int result = 0;
        int temp = 0;

        for (int i = 0; i < input.length(); i++) {
            //PT -- try this: temp = input.charAt(i) - '0';
            temp = input.charAt(i) - 48;
            result += temp * (int)Math.pow(10, (input.length() - 1) - i);
        }

        System.out.printf("result = %d", result);
}
}
