// Time Complexity : O(N) N is the number of TreeNodes
// Space Complexity : O(h) Recursion stack - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Using DFS (PostOrder traversal) I figured out the height of
// left and  right subtree and if the diff is > 1 returned -1 (indicating tree is not balanced)

class Solution {
    public boolean isBalanced(TreeNode root) {
        //helper - recurse
        return isBalancedBinaryTree(root) != -1;
    }

    private int isBalancedBinaryTree(TreeNode root){
        //base case
        if(root == null) return 0;
        //left recurse - return int
        int leftTree = isBalancedBinaryTree(root.left);
        //right recurse - return int
        int rightTree = isBalancedBinaryTree(root.right);
        // condition check - Math.abs(left - right) > 1

        if(leftTree == -1 || rightTree == -1 ) return -1;
        if(Math.abs(leftTree - rightTree) > 1) return -1;
        // return - 1 + max(letf, right)

        return 1 + Math.max(leftTree,rightTree);

    }
}

// Time Complexity : O(N) - N is the nodes in LinkedList
// Space Complexity : O(1) Recursion stack - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// To solve this in one pass we travel to middle of the list and the from middle node to the last node we reverse the list
// Then start comparing head to the reversed linked list

class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;

        ListNode middleNode = findMiddleOfList(head);
        ListNode reverseNode = reverseList(middleNode);

        return compareLists(reverseNode , head);
    }
    // 1 2 2 1
    private ListNode findMiddleOfList (ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private boolean compareLists(ListNode prev, ListNode head){

        while(prev != null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}