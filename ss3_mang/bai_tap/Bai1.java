package ss3_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap so phan tu cua mang thu " + (i + 1) + " cua mang la: ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("mang ban dau la : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("nhap phan tu can xoa trong mang la: ");
        int x = Integer.parseInt(sc.nextLine());
        int viTri = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                viTri = i;
                break;
            }
        }
        if (viTri == 0) {
            System.out.println("Khong tim thay phan tu can xoa trong mang");
        } else {
            for (int i = viTri; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            for (int i =0; i < arr.length - 1; i++) {
                System.out.println("Mang sau xoa la: "+  arr[i]);
            }
        }
    }
}
