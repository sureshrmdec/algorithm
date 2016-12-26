/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
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

};
