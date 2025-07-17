# Competitive-Coding-4

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 

//Problem 1 : Balanced Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. we will have a global variable and will set that to true considering that at first the tree is balanced
2. We will call a dfs function and will calculate the height of left subtree and right subtree and the difference between the two
3. If the difference is greater than 1 we will change the isValid to false 
4. We will return the maximum height between the left or right subtree
class Solution {
    boolean isValid;
    public boolean isBalanced(TreeNode root) {

        //if my root is null
        if(root == null){
            return true;
        }

        isValid = true;

        dfs(root);

        return isValid;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //get the height of left subtree
        int l = dfs(root.left);

        //get the height of right subtree
        int r = dfs(root.right);

        if(Math.abs(l - r) > 1){
            isValid = false;
        }

        return Math.max(l, r) + 1;
    }
}

//Problem 2 : Is LinkedList Palindrom
// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. I will use Fast and slow poi nter approach to find the middle node of the LL
2. Then I will reverse the second half of the linked list 
3. Then I will checck if my first half of the linked list's node values are same as the second half LL node values
4. If not I will return false

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        // Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // Compare halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    //reverse the second half of the LL
    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode temp = prev;
            prev = head;
            head = head.next;
            prev.next = temp;
        }
        return prev;
    }
}