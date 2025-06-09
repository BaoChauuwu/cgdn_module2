package stack_queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class UseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();

        System.out.println("Moi ban nhap phan tu cua stack:");
        for (int i = 0; i < n; i++){
            stack.push(sc.nextInt());
        }
        System.out.println("Stack " + stack);
        int [] arr = new int[n];
        int index = 0;

        while (!stack.isEmpty()){
            arr[index]=stack.pop();
            index++;
        }

        System.out.println("Đảo ngược mãng: " + Arrays.toString(arr));
    }
}


