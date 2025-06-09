package stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so can chuyen doi");
        int number=Integer.parseInt(sc.nextLine());
        changeNumberToBinary(number);
    }

    public static void changeNumberToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

