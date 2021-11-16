package array;

/**
 *  二分查找模板
 */

public class BinarySearch {

    public static void main(String[] args) {

    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

}
