/**************************************************
Name: Breadth First Search for Binary Tree
Info: http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
Note: Using a queue to manage FIFO BFS machanism


**************************************************/

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BFS_BT {

	public void levelOrderQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		BFS_BT i = new BFS_BT();
		System.out.println("Breadth First Search : ");
		i.levelOrderQueue(root);
	}
}


/**************************************************
Name: Depth First Search for Binary Tree
Info: http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
Note: Using a stack data structure as a buffer to manage BFS mechanism


**************************************************/

public class DFS_BT {
	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" " + x.data);
		}
	}
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		DFS_BT b = new DFS_BT();
		System.out.println("Depth-First-Search : ");
		b.DFS(root);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

