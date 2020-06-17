package binary_tree;

/**
 * 
 * test binary search tree
 * 
 * @author terry test case: 5 / \ 3 8 / \ / \ 1 4 6 9
 * 
 */

public class BST_Test {

	public static void main(String[] args) {
		// construct tree
		BinartSearchTree bst = new BinartSearchTree(5);
		bst.root.left = new Node(3);
		bst.root.right = new Node(8);
		bst.root.left.left = new Node(1);
		bst.root.left.right = new Node(4);
		bst.root.right.right = new Node(9);
		bst.root.right.left = new Node(6);

		// test find method
		// System.out.println(bst.find_recursive(8, bst.root).val);
		// System.out.println(bst.find_recursive(2, bst.root) == null);
		//
		// System.out.println(bst.find_unrecursive(10, bst.root) == null);
		// System.out.println(bst.find_unrecursive(1, bst.root).val);
		// System.out.println(bst.find_unrecursive(9, bst.root).val);

		// test insert method
		System.out.println(bst.insert(3));
		System.out.println(bst.insert(2));
		System.err.println(bst.insert(10));
		System.out.println(bst.find_recursive(10, bst.root).val);
	}

}
