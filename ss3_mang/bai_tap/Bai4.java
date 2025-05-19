package ss3_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap so hang cua mang la : ");
        int i=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so cot cua mang la : ");
        int j=Integer.parseInt(sc.nextLine());
        int[][] arr=new int[i][j];
        // Chat bay em dung deepToString
        System.out.println(Arrays.deepToString(inputArray(i, j, arr)));
        System.out.println("Phan tu lon nhat mang la: " + finMax(arr));
    }

    public static int[][] inputArray(int i, int j , int [][] arr ){
        Scanner sc=new Scanner(System.in);
        for(int k=0;k<i;k++){
            for(int l=0;l<j;l++){
                System.out.println("Enter number thu ");
                arr[k][l]=Integer.parseInt(sc.nextLine());
            }
        }
        return arr;
    }

    public static int finMax(int [][] arr){
        int max = arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>max){
                    max=arr[i][j];
                }
            }
        }
        return max;
    }
}
