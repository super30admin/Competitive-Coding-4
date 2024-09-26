//<---Recursion LeetCode----> 
//Time Complexity:O(N) 
//Space Complexity :O(1)

class Solution {
    public boolean isBalanced(TreeNode root) {
       if(root == null)
           return true;
        return height(root)!= -1 ;			
    }
    
    private int height(TreeNode root) {
        if(root == null)
            return 0;						// edge case
        
        int left = height(root.left);		// check if left subtree is height-balanced recursively
        if(left == -1)
            return -1;
        int right = height(root.right);		// check if right subtree is height-balanced recursively
        if(right == -1)
            return -1;
        if(Math.abs(left-right) > 1)		// if difference of heights of both subtrees greater than 1, not height balanced
            return -1;
        return Math.max(left,right)+1;		// Return max height of binary tree if height balanced
    }
}

//<-----BruteForce----->

//Time O(n^2) 
//space complexity O(1)

class Node { 
    int data; 
    Node left, right; 
    Node(int d) 
    { 
        data = d; 
        left = right = null; 
    } 
} 
  
class BinaryTree { 
    Node root;   
    
    boolean isBalanced(Node node) 
    { 
        int lh, rh;
        if (node == null) 
            return true; 

        lh = height(node.left); // Get height of subtrees
        rh = height(node.right); 
  
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left) 
            && isBalanced(node.right)) {
		return true;
	}else{
	return false;  //If reach here then tree is not balanced
	}
    }     
    
    int height(Node node) //function to get height
    { 
        
        if (node == null) //base case, tree is empty
            return 0; 
          
        return 1 + Math.max(height(node.left), height(node.right)); //if tree is not empty then...
    } 
  
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.left.left = new Node(8); 
  
        if (tree.isBalanced(tree.root)) 
            System.out.println("Tree is balanced"); 
        else
            System.out.println("Tree is not balanced"); 
    } 
} 



