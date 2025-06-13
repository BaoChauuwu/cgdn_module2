package ss13.bai2;

import java.util.Arrays;
import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        String result = "";
        for (char c : charArray) {
            if (!result.contains(String.valueOf(c))) {
                result += c;
            }
        }
        System.out.println("Sorted string: " + result);
    }
}
