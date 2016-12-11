
/**************************************************
Name: Java Implementation For Binary Tree
Info: http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
Info: http://cslibrary.stanford.edu/110/BinaryTrees.html#java

**************************************************/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

class BinaryTree {
	/**************************************************
	Name: Breadth First Search for Binary Tree
	Info: http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
	Note: Using a queue to manage FIFO BFS machanism


	**************************************************/

	public void BFS(Node root) {
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

	/**************************************************
	Name: Depth First Search for Binary Tree
	Info: http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
	Note: Using a stack data structure as a buffer to manage BFS mechanism


	**************************************************/
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




	/***********************************************
	3. maxDepth() Solution (Java)
	***********************************************
	 Returns the max root-to-leaf depth of the tree. 
	 Uses a recursive helper that recurs down to find 
	 the max depth. 
	***********************************************/ 
	public int FindMaxDepth(Node root) { 
	    return maxDepth(root); 
	}

	private int maxDepth(Node node) { 
	  if (node==null) { 
	    return(0); 
	  } 
	  else { 
	    int lDepth = maxDepth(node.left); 
	    int rDepth = maxDepth(node.right);

	    // use the larger + 1 
	    return(Math.max(lDepth, rDepth) + 1); //plus this level
	  } 
	} 


	/***********************************************
	4. maxValue() Solution (Java)
	***********************************************
	 Returns the max value in a non-empty binary search tree. 
	 1> Uses a helper method that iterates to the left to find 
	 the min value. 
	 2> Usea recursive method that goes all the way down the right-most node.
	 Since Binary Search Trea is always that larger value is in the right child node.
	***********************************************/ 
	public int findMaxValue(Node root) { 
	 	return maxValue(root); 
	} 
    //iteration version
	
	private int maxValue(Node node) { 
		Node current = node;
		while(current.right != null) {
			current = current.right;
		}

		return(current.data);
	}
	
    /*
	// recursive version
	private int maxValue(Node node) { 
		if(node.right == null)
			return(node.data);
		return (maxValue(node.right));
	}
    */

    /***********************************************
	5. printInOrderTree() Solution (Java)
	***********************************************
	Prints the node values in the "inorder" order. 
    Uses a recursive helper to do the traversal. 
    About what is inorder/postorder: http://www.geeksforgeeks.org/618/
	***********************************************/ 
    public void printInOrderTree(Node root) { 
	    inOrderTree(root); 
	}

	private void inOrderTree(Node root) {
		if (node == null) return;

		 // left, node itself, right 
		 printTree(node.left); 
		 System.out.print(node.data + "  "); 
		 printTree(node.right); 
	}

	/***********************************************
	6. printPostOrderTree() Solution (Java)
	***********************************************
	Prints the node values in the "postorder" order. 
 	Uses a recursive helper to do the traversal. 
	***********************************************/ 
    public void printPostOrderTree(Node root) { 
	    postOrderTree(root); 
	}

	private void postOrderTree(Node node) {
		if (node == null) return;

		 // left, node itself, right 
		 printTree(node.left); 
		 printTree(node.right); 
		 System.out.print(node.data + "  "); 
		 
	}

	/***********************************************
	7. hasPathSum() Solution (Java)
	***********************************************
	Given a tree and a sum, returns true if there is a path from the root 
    down to a leaf, such that adding up all the values along the path 
    equals the given sum.
    Strategy: subtract the node value from the sum when recurring down, 
    and check to see if the sum is 0 when you run out of tree. 
	***********************************************/ 
	public boolean hasPathSum(Node node, int sum) {
		if (node == null) { 
        	return(sum == 0); 
        } 
        else { 
          // otherwise check both subtrees 
            int subSum = sum - node.data; 
            return(hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum)); 
        } 
		

	}




	/***********************************************
	Main Function
	***********************************************/
	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		BinaryTree i = new BinaryTree();

		/* BFS */
		//System.out.println("Breadth First Search : ");
		//i.BFS(root);

		/* DFS */
		//System.out.println("Depth-First-Search : ");
		//i.DFS(root);

		/* Min Value */
		//System.out.println("Finding maxValue : ");
		//System.out.println(i.findMaxValue(root));

		/* hasPathSum */
		System.out.println("Tree has path of sum is " + i.hasPathSum(root, 55));


	}
}







