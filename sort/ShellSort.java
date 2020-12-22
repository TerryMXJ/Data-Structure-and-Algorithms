package sort;

import java.util.Arrays;

public class ShellSort {

    static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int arr[]) {
        int size = arr.length;
        for (int gap = size/2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j-gap] > temp; j -= gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 18, 35, 1, 51, 13, 5, 88, 64, 31, 12, 8, 7, 78};
        printArray(arr);
        sort(arr);
        printArray(arr);
    }

}
