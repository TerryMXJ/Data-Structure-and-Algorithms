package array;

/**
 *  二分查找模板
 */

public class BinarySearch {
    // 1, 3, 5, 7, 8, 9, 11, 15, 18, 20
    static int[] arr = new int[]{0};
    public static void main(String[] args) {
        System.out.println(bs(2));
        System.out.println(bs(4));
        System.out.println(bs(0));
        System.out.println(bs(23));
        System.out.println(bs(-1));
    }

    private static int bs(int val) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
//            System.out.println(l + " " + mid + " " + r);
            if (arr[mid] < val ){
                l = mid+1;
            }else if (arr[mid] > val) {
                r = mid-1;
            }else {
                return mid;
            }
        }
        return l;
    }

}
