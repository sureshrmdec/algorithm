"use strict"
const Stack = require('../Lists/Stack');
const Queue = require('../Lists/Queue');
const BinarySearchTree = require("./BinarySearchTree");

function BinaryTree() {
  /**********************************************************************
  Depth First Binary Tree Traversal   using Stack
  **********************************************************************/
  this.depthFirstTranversal = function(root, matches) {
    const nodeStack = new Stack();
    if (root === null)
      return;
    Push(root);

    while (!nodeStack.isEmpty()) {
      const node = nodeStack.pop();
      matches(node.data);
      //console.log(node.data);

      Push(node.left);
      Push(node.right);
    }

    function Push(node) {
      if (node === null || node === undefined)
        return;

      nodeStack.push(node);

    }

    return;
  }



  /**********************************************************************
  Breadth First Binary Tree Traversal  using Queue
  **********************************************************************/
  this.breadthFirstTranversal = function(root, matches) {
    const nodeQueue = new Queue();
    if (root === null)
      return;
    Push(root);

    while (!nodeQueue.isEmpty()) {
      const node = nodeQueue.pop();
      matches(node.data);
      Push(node.left);
      Push(node.right);
    }

    function Push(node) {
      if (node === null || node === undefined)
        return;

      nodeQueue.push(node);
    }

    return;
  }


  /**********************************************************************
  InOrder Binary Tree Traversal  
  **********************************************************************/
  this.inOrderTranversal = function(root, matches) {
    if (root !== null && root !== undefined) {
      //matches(root.data);  preOrder
      this.inOrderTranversal(root.left, matches);
      matches(root.data);
      this.inOrderTranversal(root.right, matches);
      //matches(root.data);  postOrder
    }
  }
}

module.exports = BinaryTree;



//for testing
/*
let bst = new BinarySearchTree();

bst.push(0);
bst.push(5);
bst.push(3);
bst.push(9);
bst.push(6);
bst.push(2);
bst.push(4);
bst.push(1);
bst.push(7); 

//depthFirstSearch(bst.root, (val)=>console.log(val));
let binaryTree = new BinaryTree();

//for testing
const testArray = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0];
bst.createBST(testArray);
binaryTree.breadthFirstTranversal(bst.root, (val) => console.log(val));
console.log("---------------------------------------------");
binaryTree.depthFirstTranversal(bst.root, (val) => console.log(val));
console.log("---------------------------------------------");
binaryTree.inOrderTranversal(bst.root, (val) => console.log(val));
*/
