package heap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5,3,6,2,4,8,1};
        build_max_heap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n");
    }

    private static void build_max_heap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            bubble_up(arr, i);
        }
        /*
        for (int i = arr.length-1; i >= 0; i--) {
            bubble_down(arr, i);
        }
        */
    }

    private static void bubble_up(int[] arr, int i) {
        int temp = arr[i];
        int j = (i-1)/2;
        while (j>0 && arr[j] < temp) {
            arr[i] = arr[j];
            i = j;
            j = (j-1)/2;
        }
        arr[i] = temp;
    }

}
