package ss3_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so phan tu cua mang");
        int n=Integer.parseInt(sc.nextLine());
        int [] arr=new int[n];
        System.out.println(Arrays.toString(inputArray(n,arr)));
        System.out.println("Phan tu nho nhat trong mang la: "+ findMin(arr));



    }

    public static int[] inputArray(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        return arr;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}