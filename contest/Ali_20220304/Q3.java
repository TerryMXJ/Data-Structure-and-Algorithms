package contest.Ali_20220304;

import java.util.*;
import java.io.*;

/*
.121
....
....
....
....
 */

public class Q3 {

    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<int[]> list = new ArrayList<>();
            char[][] g = new char[4][4];
            int val = 0;
            for (int i = 0; i < 4; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < 4; j++) {
                    g[i][j] = tmp.charAt(j);
                    if (tmp.charAt(j)!='.') {
                        list.add(new int[]{i, j, val});
                    }
                    val++;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < (1<<16); i++) {
                // 有数字周围的数量要一致
                boolean flag = false;
                for (int[] arr : list) {
                    if ((1<<arr[2]&i) != 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                int[][] now_g = new int[4][4];
                int tmp = 0;
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        now_g[j][k] = (i & (1<<tmp))!=0? 1 : 0;
                        tmp++;
                    }
                }
                flag = true;
                for (int[] arr : list) {
                    if (count(now_g, arr)!=g[arr[0]][arr[1]]-'0') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(i);
                }

            }
            val = (1<<16)-1;
            for (int i : res) {
                val &= i;
            }
            int tmp = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (g[i][j]=='.') {
                        if ((1<<tmp & val)!=0) {
                            g[i][j] = 'X';
                        }else {
                            g[i][j] = 'O';
                        }
                    }
                    tmp++;
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
        }
    }
    static int[][] move = new int[][]{
            {1, 0},
            {1, 1},
            {1, -1},
            {0, 1},
            {0, -1},
            {-1, 0},
            {-1, 1},
            {-1, -1}
    };
    private static int count(int[][] g, int[] arr) {
        int count = 0;
        int r = arr[0], c = arr[1];
        for (int i = 0; i < move.length; i++) {
            if (valid(r+move[i][0], c+move[i][1]) && g[r+move[i][0]][c+move[i][1]]==1) {
                count++;
            }
        }
        return count;
    }
    private static boolean valid(int r, int c) {
        if (r >= 4 || r < 0 || c >= 4 || c < 0) return false;
        return true;
    }
}
