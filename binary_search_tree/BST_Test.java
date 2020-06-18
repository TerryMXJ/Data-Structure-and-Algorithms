/**
 * 
 * test binary search tree
 * 
 * @author terry 
 * test case: 
 *           5 
 *          /  \ 
 *         3    8 
 *        / \  / \ 
 *       1  4  6  9
 *       		   \
 *       		    11
 *       		    /
 *       		   10
 * 
 */

public class BST_Test {

	public static void main(String[] args) {
		// construct tree
		BinarySearchTree bst = new BinarySearchTree(5);
		bst.getRoot().left = new Node(3);
		bst.getRoot().right = new Node(8);
		bst.getRoot().left.left = new Node(1);
		bst.getRoot().left.right = new Node(4);
		bst.getRoot().right.right = new Node(9);
		bst.getRoot().right.left = new Node(6);
		bst.getRoot().right.right.right = new Node(11);
		bst.getRoot().right.right.right.left = new Node(10);

		// test find method
//		 System.out.println(bst.find_recursive(8, bst.getRoot()).val);
//		 System.out.println(bst.find_recursive(2, bst.getRoot()) == null);
//		
//		 System.out.println(bst.find_unrecursive(10, bst.getRoot()) == null);
//		 System.out.println(bst.find_unrecursive(1, bst.getRoot()).val);
//		 System.out.println(bst.find_unrecursive(9, bst.getRoot()).val);

		// test insert method
//		System.out.println(bst.insert(3));
//		System.out.println(bst.insert(2));
//		System.err.println(bst.insert(10));
//		System.out.println(bst.find_recursive(2, bst.getRoot()).val);
		
		//test traversal method
//		System.out.println("preorder traversal: ");
//		bst.print_preOrder(bst.getRoot());
//		System.out.println();
//		System.out.println("inorder traversal: ");
//		bst.print_inOrder(bst.getRoot());
//		System.out.println();
//		System.out.println("postorder traversal: ");
//		bst.print_postOrder(bst.getRoot());
//		System.out.println();
		
//		System.out.println("level order traversal: ");
//		bst.print_level_order(bst.getRoot());
//		System.out.println();
		
		//test delete method
//		bst.delete(8);
//		bst.delete(11);
//		bst.delete(3);
//		bst.delete(5);
//		System.out.println("level order traversal: ");
//		bst.print_level_order(bst.getRoot());
//		System.out.println();
		
		
	}

}
