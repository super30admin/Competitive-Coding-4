//Solved successfully on leetcode and faced no issues
//for optimised , Time complexity : O(n) Space complexity = O(h)


class Solution {
    //optimised :TC  O(n) 
    public boolean isBalanced(TreeNode root) {
        if(height(root) == -1){
            return false;
            }
        else{
            return true;
            }
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left == -1 || right==-1){
            return -1;
        }
        if(left-right>1 || right-left >1){
            return -1;
        }
        return 1+Math.max(left,right);

    }




    }
//Brute force : O(n2) time
//     public boolean isBalanced(TreeNode root) {
//         if(root == null){
//             return true;
//         }
//         int left = height(root.left);
//         int right = height(root.right);
//         if(left-right>1 || right-left>1){
//             return false;
//         }
//         return isBalanced(root.left) && isBalanced(root.right);
        
//     }
//     private int height(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int left = 1+height(root.left);
//         int right = 1+height(root.right);
//         return Math.max(left,right);
//     }
// }