package string_processing;

public class KMP_Algorithm {

    public static void main(String[] args) {
        String s = "aabaabaac";
        String p = "aabaac";
        System.out.println(kmp_compare(s, p));
    }

    private static int kmp_compare(String s, String p) {
        int[] next = new int[p.length()];
        getNext(next, p);
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            while (j > 0 && s.charAt(i)!=p.charAt(j))
                j = next[j-1];
            if (s.charAt(i)==p.charAt(j))
                j++;
            if (j==p.length()) return i-p.length()+1;
        }
        return -1;
    }

    private static void getNext(int[] next, String p) {
        // 初始化
        int j = 0, i = 1;
        next[j] = 0;
        for (; i < next.length; i++) {
            // 前缀末尾不相等
            while (j > 0 && p.charAt(i)!=p.charAt(j))
                j = next[j-1];
            // 前缀末尾相等
            if (p.charAt(i)==p.charAt(j))
                j++;
            // 更新next数组
            next[i] = j;
        }
    }
}
