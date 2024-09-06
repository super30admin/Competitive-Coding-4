// Time Complexity : O(n) as we will be traversing through LinkedList twice once to find the middle and reversing the second half and once to comparing two halves.
// Space Complexity : O(1) as we are not using any auxillary data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed code tutorial


// Your code here along with comments explaining your approach
// In this approach we will be using two pointers slow and fast to find the middle of the linked list. As soon as fast pointer reaches end, slow pointer would be 
// at exact middle of the linked list. Then we will reverse the second half of the list and we will then make slow pointer next to null and head2 as second half
// reverese list. Then we will compare one by one elements. If all corresponding nodes match, the list is palindrome otherwise it's not.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverseLinkedList(head2);

        while(head != null && head2 != null) {
            if(head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;

    }

    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null) {
           curr.next = prev;
           prev = curr;
           curr = fast;
           fast = fast.next;
        }

        curr.next = prev;

        return curr;
    }
}



// Time Complexity : O(n^2) as in the worst case the height method could be called for each node and each height call itself traverse the entire subtraa
// Space Complexity : O(n) as in worst case scenario all nodes could be inside the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed Code Tutorial


// Your code here along with comments explaining your approach
// Here in the function we are checking whether a binary tree is balanced by recursively comparing the heights of the left and right subtrees of each node. If the
// height difference between any two corresponding subtrees is greater than 1 then the tree is unbalanced. The isBalanced method is checking this condition for
// each node while in the height function we are simply computing the heights of the trees. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) {
            return true;
        }

        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

        // return height(root) != -1;

    }

    private int height(TreeNode root) {
        // base
        if(root == null) {
            return 0;
        }

        // logic
        return Math.max(height(root.left), height(root.right)) + 1;

        // int left = height(root.left);
        // int right = height(root.right);

        // if(Math.abs(height(root.left) - height(root.right)) > 1) {
        //     return -1;
        // }

        // if(left == -1 || right == -1) {
        //     return -1;
        // }

        // return Math.max(left, right) + 1;
    }
}