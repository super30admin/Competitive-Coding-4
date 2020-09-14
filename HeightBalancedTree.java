/*
* Recursion has two main components:
* 1. Base case -> condition to control/stop recursion
* 2. Recursive case, which again has 2 pieces
*       - Recursive calls
*       - Conditional statements -> to compute something
*/


/*
* In Top-Down recursion, we have
*   - first, conditional checks -> compute something
*   - and then, recursive calls
* 
* In Bottom-Up recursion, we have
*   - first, recursive calls -> go all the way down to the leaf node
*   - and then, conditional checks -> to compute from leaf node and return the answer back to caller(its parent node)
*
*/

// Using Bottom-Up recursion
/*
* For this example, it is advantageous to use Bottom-Up approach 
* because, let's say, in bottom-up approach, we found that leftmost leaf node is not height balanced. We just return the answer to caller(parent node) and stop. We don't traverse the 
* right subtree
*
* But, in top-down approach, we will start computing height from the root node and check for every node if it is height-balanced until we reach the bottom leftmost node that is not height balanced. 
*
* So, in bottom-up approach, we save traversing unnecessary nodes unlike top-down approach.
*/


/*
 * #110. Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
   
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 
Return false.

 */


/*
 * Time Complexity: O (N) -> If the tree is height balanced, then we will have to traverse through all the nodes of a tree
 * 
 * Space Complexity: O (maxDepth) -> Recursive stack will store nodes equal to the current branch depth during recursive calls
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding4;

//Definition for a binary tree node.
class TreeNode3 {
	int val;
	TreeNode3 left;
	TreeNode3 right;
	TreeNode3() {}
	TreeNode3(int val) { this.val = val; }
	TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class HeightBalancedTree {
	// using a global variable to control/stop recursion
	  boolean result = true;
	  public boolean isBalanced(TreeNode3 root) {
	      // start the recursive call to go all the way down to leftmost leaf node
	      height(root);
	      return result; // this function will return final answer -> true or false
	      
	    }
	  
	  /*This function will check if a node is height-balanced and compute height for that node 
	  * and return the answer(height of a node) to the parent node(caller)
	  * Function has base case and recursive case
	  */
	  public int height(TreeNode3 node){
	      // Base case
	      if(node == null || !result){
	          return -1;
	      }
	     
	      // Bottom-Up recursion
	      // Recursive case
	      // 1. Recursive calls
	      
	      // recursive call to compute leftmost node height
	      int left = height(node.left);
	      // recursive call to compute rightmost node height
	      int right = height(node.right);
	      
	      // 2. Conditional checks
	      /* Once done computing height for left and right child of a node(leaf node or middle nodes),
	      *  Check if absolute difference between height of left and right subtree of a node <= 1
	      *  If yes, the node is height balanced. Now, compute the height for a node and return the answer to            caller(its parent)
	      *  If not, change the result value to false, return the answer to caller and stop recursion. No need
	      *  to check other nodes.
	      */
	      if(Math.abs(left - right) > 1){
	          result = false;
	      }
	      return 1 + Math.max(left, right);
	    
	  }

}
