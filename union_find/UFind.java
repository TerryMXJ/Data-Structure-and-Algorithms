package union_find;

public class UFind {

    int[] parent;

    // 让小的作为大的父节点
    private void union(int a, int b) {
        if (isConnected(a, b)) return;
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private boolean isConnected(int a, int b) {
        return find(a)==find(b);
    }

    private int find(int i) {
        while (parent[i]!=-1) {
            i = parent[i];
        }
        return i;
    }

    private void isolated(int i) {
        parent[i] = -1;
    }
}
