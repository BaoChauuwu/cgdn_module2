package ss14.bai1;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 6};
        System.out.println("Array trước khi sort: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Array sau khi sort: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int pos, x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
    }
}
