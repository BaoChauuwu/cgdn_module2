package ss2_loop.bai_tap;

import java.util.Scanner;

public class NguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so phan tu nguyen to can in");
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        int num = 2;

        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println("So nguyen to la: " + num);
                count++;
            }
            num++;
        }
    }
}
