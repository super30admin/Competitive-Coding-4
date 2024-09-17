//Time Complexity : O(N)
//Space Complexity : O()
class Solution {
    public boolean isPalindrome(ListNode head) {
       // Find the end of the first half.
       ListNode h1 = findmid(head);
       //Reverse the second half.
       ListNode h2 = reverse(h1.next);
        ListNode p1=head;
        ListNode p2=h2;
        //Determine whether or not there is a palindrome.
        while( p2!=null){
            if(p1.val!=p2.val)
                return false;
            p1=p1.next;
            p2=p2.next;
        }

        h1.next=reverse(h2);
        return true;
    }
    //Reverse method for given list.
    private ListNode reverse(ListNode head){
        ListNode slow=head;
        ListNode prev=null;
         while(slow!=null){
          ListNode temp = slow.next;
          slow.next=prev;
          prev=slow;
          slow=temp;
      }
        return prev;
    }
    //Finding mid of the given list.
    private ListNode findmid(ListNode head){
        ListNode fast = head;
        ListNode mid = head;
         while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
             mid=mid.next;
        }
        return mid;
    }
}class ListNode{
    int val;
         ListNode next;
         ListNode() {}
       ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution2 {
    public boolean isBalanced(TreeNode root) {
      return height(root) != -1;
  }
  private int height(TreeNode root){
      //Height balance at children 
      if(root == null) return 0;
      int left = height(root.left);
      int right = height(root.right);
      //If the height at children is not balanced. We are returning -1 to parent
      if(Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
      return Math.max(left, right) + 1;
  }
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }



