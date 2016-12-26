"use strict"
const BinaryTree = require('./BinaryTree');
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
  /**********************************************************************
  Push one number into the Binary Search Tree, but cannot use this function to construct a BST.
  **********************************************************************/

  this.push = function(val) {
    let root = this.root;

    if (!root) {
      root = new Node(val);
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


  /*********************************Recursive Version*************************************/

  this.push_recursive = function(val) {
    append(this.root);

    function append(node) {
      if (node === null) {
        node = new Node(val); //cannot read the value of this.root, can only read the value of direct parent.
      }
      else {
        if (node.data > val)
          append(node.left);
        else
          append(node.right);
      }
    }
  }


  /**********************************************************************
  Create a binary search tree from a sorted array(large to small)
  **********************************************************************/
  this.createBST = function(sourceArray) {

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
  Find out the max value of a Binary Search Tree
  **********************************************************************/
  this.findMaxValue = function() {
    if (!this.isEmpty()) {
      let node = this.root;
      while (node.right) {
        node = node.right;
      }
      return node.data;
    }
  };
  /**********************************************************************
  Find out teh min value of a Binary Search Tree
  **********************************************************************/
  this.findMinValue = function() {
    if (!this.isEmpty()) {
      let node = this.root;
      while (node.left) {
        node = node.left;
      }
      return node.value;
    }
  };
  /**********************************************************************
  Create a binary search tree from a sorted array(large to small)
  **********************************************************************/
  this.isEmpty = function() {
    return this.root === null;
  };


  /**********************************************************************
  Binary Search Tree Tranversal, using recursive way, faster than using 
  DFS/BFS to search the whole tree.
  **********************************************************************/
  this.BinarySearchTreeSearch = function(val) {

    return tranversal(this.root);

    function tranversal(node) {
      if (node === null || node === undefined)
        return null;
      if (node.data === val) {
        console.log("we find the node, node data is: " + node.data);
        return node;
      }

      if (node.left !== null && node.data > val)
        tranversal(node.left);
      else if (node.right !== null && node.data < val)
        tranversal(node.right);
    }
  }

  /**********************************************************************
    Validate a Binary Search Tree. Leetcode No.098
    **********************************************************************/
  this.isValidBST = function(root) {
    if (root === null || root === undefined)
      return true;
    if (root.left === null && root.right === null)
      return true;

    return validBST(root, null, null);

    function validBST(node, min, max) {
      //console.log("test node: " + node.val + " min: " + min + " max:" + max);
      //Base Case
      if (min === null)
        min = Number.MIN_SAFE_INTEGER;
      if (max === null)
        max = Number.MAX_SAFE_INTEGER;
      //both child nodes are null
      if (node.left === null && node.right === null)
        return true;
      //only left node is null
      else if (node.left === null && node.right !== null) {
        if (node.right.val > node.val && node.right.val > min && node.right.val < max)
          return validBST(node.right, node.val, max);
        else
          return false;
      }
      //only right node is null
      else if (node.left !== null && node.right === null) {
        if (node.left.val < node.val && node.left.val > min && node.left.val < max)
          return validBST(node.left, min, node.val);
        else
          return false;
      }
      else {
        if (node.left.val < node.val && node.right.val > node.val &&
          node.left.val > min && node.left.val < max && node.right.val > min && node.right.val < max)
        //left child nodes should be all smaller than node.val, right child nodes should all larger than node.val
          return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
        else
          return false;
      }
    }
  }





  module.exports = BinarySearchTree;



  //for testing
  let bst = new BinarySearchTree();
  /*
  bst.push_recursive(0);
  bst.push_recursive(5);
  bst.push_recursive(3);
  bst.push_recursive(9);
  bst.push_recursive(6);
  bst.push_recursive(2);
  bst.push_recursive(4);
  bst.push_recursive(1);
  bst.push_recursive(7);
  */

  //for testing
  const testArray = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0];
  bst.createBST(testArray);
  console.log("---------------------------------------------");
  //bst.BinarySearchTreeSearch(5);
  //console.log(bst.root);
  let binaryTree = new BinaryTree();
  binaryTree.inOrderTranversal(bst.root, (val) => console.log(val));
