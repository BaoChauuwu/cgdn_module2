package stack_queue;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
        System.out.println("moi ban nhap chuoi");
        String str=sc.nextLine();
        checkPalindrome(str);
    }
    public static void checkPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        while (!str.equals("")) {
            queue.add(str.charAt(0));
            str = str.substring(1,str.length());
        }
        System.out.println(Arrays.toString(str.split("")));
        if (queue.equals(str)) {
            System.out.println("la palindrome");
        }
        System.out.println("Khong phai");
    }
}
