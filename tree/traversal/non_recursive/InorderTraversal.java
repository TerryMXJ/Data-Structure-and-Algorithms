package tree.traversal.non_recursive;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new LinkedList<>();
        TreeNode tmp = new TreeNode(0, null, null);
        while (!stack.isEmpty() || tmp!=null) {
            if (tmp!=null) {
                stack.push(tmp);
                tmp = tmp.left;
            }else {
                tmp = stack.pop();
                res.add(tmp);
                tmp = tmp.right;
            }
        }
    }

}
