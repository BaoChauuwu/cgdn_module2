package ss3_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
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
        System.out.println("Nhap vi tri can them phan tu cua mang: ");
        int inedx=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap gia tri can them cua phan tu: ");
        int value=Integer.parseInt(sc.nextLine());
        int []newArr= new int[n+1];
        for (int i = 0; i < n+1; i++) {
            if (i<inedx){
                newArr[i]=arr[i];
            }
            else if(i==inedx){
                newArr[i]=value;
            }
            else{
                newArr[i]=arr[i-1];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
