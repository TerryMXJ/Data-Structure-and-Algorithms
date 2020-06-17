package binary_tree;

/**
 * binary search tree implementation
 * 
 * @author terry
 *
 */

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

public class BinartSearchTree {

	Node root = null;

	public BinartSearchTree(int val) {
		this.root = new Node(val);
	}

	public Node find_unrecursive(int i, Node root) {
		while (root != null) {
			if (root.val == i)
				return root;
			else if (root.val > i)
				root = root.left;
			else
				root = root.right;
		}
		return null;
	}

	public Node find_recursive(int i, Node root) {
		if (root == null)
			return null;
		else if (root.val == i)
			return root;
		else if (root.val > i)
			return find_recursive(i, root.left);
		else
			return find_recursive(i, root.right);
	}
	
	public boolean insert(int val) {
		if (this.root == null) {
			root = new Node(val);
			return true;
		}else {
			Node p = null;
			Node temp = this.root;
			while (temp != null) {
				p = temp;
				if (temp.val == val) return false;
				else if (temp.val < val) {
					temp = temp.left;
					if (temp == null) {
						p.left = new Node(val);
						return true;
					}
				}else {
					temp = temp.right;
					if (temp == null) {
						p.right = new Node(val);
						return true;
					}
				}
			}
		}
		return false;
	}

}
