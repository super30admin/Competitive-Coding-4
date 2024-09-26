// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Palindrome of the linkedList
//time o(n) - n is the length
//space o(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head == null)
            return true;
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur=cur.next;
        }
        int ptr1 = 0, ptr2 = list.size()-1;
        
        while(ptr1 < ptr2) {
            int left = list.get(ptr1);
            int right = list.get(ptr2);
            if(left != right)
                return false;
            ptr1++;
            ptr2--;
        }
        return true;
    }
}

//Balanced binary tree
//time o(n) n - no of nodes
//space o(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftheight = helper(root.left);
        int rightheight = helper(root.right);
        return Math.abs(leftheight-rightheight) <= 1 && isBalanced(root.left) && isBalanced(root.right); 
    }
    
    private int helper(TreeNode root) {
        //base case
        if(root == null)
            return -1;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}