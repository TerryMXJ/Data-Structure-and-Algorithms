package tree.traversal.recursive;

public class RecursiveTraversal {

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
//        preorderTraversal(root);
//        postorderTraversal(root);
//        inorderTraversal(root);
    }

    private void preorderTraversal(TreeNode root) {
        if (root!=null) {
            // visit root
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root!=null) {
            inorderTraversal(root.left);
            // visit root
            inorderTraversal(root.right);
        }
    }

    private void postorderTraversal(TreeNode root) {
        if (root!=null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            // visit root
        }
    }

}
