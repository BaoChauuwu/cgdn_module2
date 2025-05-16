package ss2_loop.bai_tap;

import java.util.Scanner;

public class NguyenTo100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so gioi han cua so nguyen to");
        int n = Integer.parseInt(sc.nextLine());
        int number = 2;
        while (number < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.println("So nguyen to la: " + number);

            }
            number++;

        }
    }
}
