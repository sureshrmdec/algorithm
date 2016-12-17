/**********************************************************************
Name: Javascript Implementation For Binary Search Tree
Info: https://khan4019.github.io/front-end-Interview-Questions/bst.html
Basic Functions
**********************************************************************/
function NewNode(val) {
	return {
		left: null,
    right: null,
    data: dataToUse
	}
}

function BinarySearchTree(){
  this.root = null;
}

BinarySearchTree.prototype.push = function(val){
  let root = this.root;

  if(!root){
      this.root = NewNode(val);
      return;
   }

  let currentNode = root;
  let newNode = NewNode(val);

  while(currentNode){
  	if(val < currentNode.value){
  		if(currentNode.left)
  			currentNode = currentNode.left;
  		else {
  			currentNode.left = newNode;
  			break;
  		}
    }
    else {
    	if(currentNode.right)
  			currentNode = currentNode.right;
  		else{
  			currentNode.right = newNode;
  			break;
  		}
    }
  }
}

let bst = new BinarySearchTree();
/*
bst.push(3);
bst.push(2);
bst.push(4);
bst.push(1);
bst.push(5);
*/

/**********************************************************************
Name: Javascript Implementation For Binary Search Tree
Info: https://khan4019.github.io/front-end-Interview-Questions/bst.html
Basic Functions
**********************************************************************/

function DepthFirstTraversal(node){
  if(node){
    console.log(node.value);
    dfs(node.left);
    dfs(node.right);
  }
}



