"use strict"
/**********************************************************************
Name: Javascript Implementation For Binary Search Tree
Info: https://khan4019.github.io/front-end-Interview-Questions/bst.html
Basic Functions
**********************************************************************/
function Node(val) {
  this.left = null;
  this.right = null;
  this.data = val;
}

function BinarySearchTree() {
  this.root = null;
}

BinarySearchTree.prototype.push = function(val) {
  let root = this.root;

  if (!root) {
    this.root = new Node(val);
    return;
  }

  let currentNode = root;
  let newNode = new Node(val);

  while (currentNode) {
    if (val < currentNode.value) {
      if (currentNode.left)
        currentNode = currentNode.left;
      else {
        currentNode.left = newNode;
        break;
      }
    }
    else {
      if (currentNode.right)
        currentNode = currentNode.right;
      else {
        currentNode.right = newNode;
        break;
      }
    }
  }
}


/**********************************************************************
Create a binary tree from a sorted array(large to small)
**********************************************************************/
BinarySearchTree.prototype.createBST = function(sourceArray) {
  if (sourceArray === null) {
    return null;
  }

  const start = 0;
  const end = sourceArray.length - 1;

  function getNode(start, end, array) {
    if (start > end) {
      return undefined;
    }

    const midpoint = Math.floor((end + start) / 2);
    let node = new Node(array[midpoint]);

    if (start !== end) {
      node.left = getNode(midpoint + 1, end, array);
      node.right = getNode(start, midpoint - 1, array);
    }

    return node;
  }

  this.root = getNode(start, end, sourceArray);
}

/**********************************************************************
DepthFirstTraversal   using Stack
**********************************************************************/
const Stack = require('../Lists/Stack');

function depthFirstSearch(root, matches) {
  const nodeStack = new Stack();
  if (root === null)
    return;
  Push(root);

  while (!nodeStack.isEmpty()) {
    const node = nodeStack.pop();
    //console.log(node.data);

    Push(node.left);
    Push(node.right);
  }

  function Push(node) {
    if (node === null || node === undefined)
      return;

    nodeStack.push(node);
    matches(node.data);
  }

  return;
}



/**********************************************************************
BreadthFirstTraversal  using Queue
**********************************************************************/
const Queue = require('../Lists/Queue');

function breadthFirstSearch(root, matches) {
  const nodeQueue = new Queue();
  if (root === null)
    return;
  Push(root);

  while (!nodeQueue.isEmpty()) {
    const node = nodeQueue.pop();
    Push(node.left);
    Push(node.right);
  }

  function Push(node) {
    if (node === null || node === undefined)
      return;

    nodeQueue.push(node);
    matches(node.data);
  }

  return;
}



//for testing
let bst = new BinarySearchTree();
/*
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
breadthFirstSearch(bst.root, (val) => console.log(val));
*/

//for testing
const testArray = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0];
bst.createBST(testArray);
//breadthFirstSearch(bst.root, (val) => console.log(val));
depthFirstSearch(bst.root, (val) => console.log(val));
