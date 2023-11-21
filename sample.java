// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Palindrome Linked List
//Time Complexity -> O(n)
//Space Complexity -> O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
          if(head == null || head.next == null) return true; //a list with no or only one element is a palindrome
          ListNode mid = getMid(head);
          ListNode list1 = head;
          ListNode curr = head;
          while(curr.next!=mid){
              curr = curr.next;
          }
          curr.next = null;
          ListNode list2 = mid;
          list2 = reverseList(list2);
          while(list1!=null && list2!=null){
              if(list1.val != list2.val){
                  return false;
              }  
              list1 = list1.next;
              list2 = list2.next;

          }

        return true;
    }

    private ListNode getMid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;
        while(temp!=null){
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;
        return curr;

    }

    
}

//2nd Height Balanced Tree
//Time Complexity -> O(n)
//Space Complexity -> O(h)
class Solution {
    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.right) && isBalanced(root.left)){
            return true;
        }
        else{
            return false;
        }

        
        
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight,rightHeight);
        
    }
}