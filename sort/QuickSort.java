package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int p = find(arr, l, r);
            sort(arr, l, p-1);
            sort(arr, p+1, r);
        }
    }

    private static int find(int[] arr, int l, int r) {
        int val = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= val) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= val) l++;
            arr[r] = arr[l];
        }
        arr[l] = val;
        return l;
    }

}
