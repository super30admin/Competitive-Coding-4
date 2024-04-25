//https://leetcode.com/problems/palindrome-linked-list/description/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null|| head.next==null)
        {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        if(fast!=null)
        {
            slow=slow.next;
        }
        while(prev!=null && slow!=null)
        {
            if(prev.val!=slow.val)
                return false;
            prev=prev.next;
            slow=slow.next;
        }
        return true;
    }
}

// https://leetcode.com/problems/balanced-binary-tree/description/
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return (Math.abs(h(root.left)-h(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right)); 
  
    }
    public int h(TreeNode node)
    {
        if(node==null)
        {
            return -1;
        }
        return 1+Math.max(h(node.left),h(node.right));
    }
}

