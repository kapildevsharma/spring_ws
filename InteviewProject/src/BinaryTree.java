
class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {
	
	Node root;
	
	int maxDepth(Node node) {
		if(node == null) {
			return 0;
		}else {
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			System.out.println(leftDepth+" and "+rightDepth);
			if(leftDepth>rightDepth) {
				return leftDepth + 1;
			}else {
				return rightDepth+1;
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		int height = tree.maxDepth(tree.root);
		System.out.println("Tree height is "+height);
	}
	
}
