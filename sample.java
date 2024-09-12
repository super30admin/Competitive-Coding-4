
// Did this code successfully run on Leetcode : YES


// Your code here along with comments explaining your approach

//Did both ininterview

// TC = O(n)
// SC = O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
        
        
        
    }
    private int height(TreeNode root){
        if(root == null)
            return -1;
        
        int left= height(root.left);
        int right = height(root.right);
        
        return Math.max(left,right) +1;
    }
}

// TC = O(n)
// SC = O(n)

class Solution {

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        ListNode endOfFirst = findMiddle(head);
        ListNode startOfSecond = reverseList(endOfFirst.next);
        
        ListNode p1 = head;
        ListNode p2 = startOfSecond;
        boolean flag = true;
        while(p2!=null){
            if(p1.val!=p2.val)return false;
            p1 = p1.next;
            p2= p2.next;
        }
        return flag;
        
        }

    private ListNode reverseList(ListNode head) {
       if(head == null || head.next==null)
           return head;
        
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return last;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



