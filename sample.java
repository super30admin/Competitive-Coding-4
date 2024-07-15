// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    private ListNode reverse(ListNode root){
        if (root== null || root.next == null)
            return root;
        ListNode prev = null, curr = root;
        while(curr !=  null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, temp = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        while(temp!= null && rev!= null){
            if (temp.val == rev.val){
                temp = temp.next;
                rev = rev.next;
            } else {
                return false;
            }
        }
        return true;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public:
         
        int isBal(TreeNode *root) {
             if(root==NULL)
                return 0;
            int lv=isBal(root->left);
            int rv=isBal(root->right);
            if(lv==-1 || rv==-1)
                return -1;
            if(abs(lv-rv)>1)
                return -1;
            return max(rv, lv)+1;
        }
        bool isBalanced(TreeNode* root) {
            int ans=isBal(root);
            if(ans==-1)
                return false;
            return true;
        }
    };