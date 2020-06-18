import java.util.LinkedList;
import java.util.Queue;

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

public class BinarySearchTree {

	private Node root = null;
	
	public Node getRoot() {
		return this.root;
	}

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
		if (getRoot() == null) {
			root = new Node(val);
			return true;
		}else {
			Node p = null;
			Node temp = getRoot();
			while (temp != null) {
				p = temp;
				if (temp.val == val) return false;
				else if (temp.val < val) {
					temp = temp.right;
					if (temp == null) {
						p.right = new Node(val);
						return true;
					}
				}else {
					temp = temp.left;
					if (temp == null) {
						p.left = new Node(val);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void print_preOrder(Node root) {
		if (root != null) {
			System.out.print(root.val + "\t");
			print_preOrder(root.left);
			print_preOrder(root.right);
		}
	}
	
	public void print_inOrder(Node root) {
		if (root != null) {
			print_inOrder(root.left);
			System.out.print(root.val + "\t");
			print_inOrder(root.right);
		}
	}
	
	public void print_postOrder(Node root) {
		if (root != null) {
			print_postOrder(root.left);
			print_postOrder(root.right);
			System.out.print(root.val + "\t");
		}
	}
	
	public void print_level_order(Node root) {
		if (root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				System.out.print(temp.val + "\t");
				if (temp.left != null) queue.add(temp.left);
				if (temp.right != null) queue.add(temp.right);
			}
		}
	}
	
	public void delete(int val) {
		root = delete(getRoot(), val);
	}
	
	private Node delete(Node root, int val) {
		if (root == null) return null;
		if (val < root.val) {
			root.left = delete(root.left, val);
		}
		else if (val > root.val) {
			root.right = delete(root.right, val);
		}else {
			if (root.right == null) return root.left;
			if (root.left == null) return root.right;
			Node temp = root.right;
			while (temp.left != null) temp = temp.left;
			root.val = temp.val;
			root.right = delete(root.right, temp.val);
		}
		return root;
	}

}
