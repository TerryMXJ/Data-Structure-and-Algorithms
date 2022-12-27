package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int m = l + (h-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);
            merge(arr, l, m+1, h);
        }
    }

    private static void merge(int[] arr, int l, int m, int h) {
        System.out.println("merge " + l + " " + h);
        int[] old = Arrays.copyOf(arr, arr.length);
        for (int i = l; i <= h; i++) {
            if (m <= h && old[l] > old[m]) arr[i] = old[m++];
            else arr[i] = old[l++];
        }
    }

}
