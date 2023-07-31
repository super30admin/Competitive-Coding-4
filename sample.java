//Problem 1: Palindrome LinkedList
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Find middle element-> reverse 2nd half linkedlist -> compare final to first element and go on until last half or first half finishes-> return true if all elements are equal
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        //ArrayList Solution
        // List<Integer> l1=new ArrayList<>();
        // List<Integer> l2=new ArrayList<>();
        // ListNode p1=head;
        // while(p1!=null){
        //     l1.add(p1.val);
        //     p1=p1.next;
        // }
        // for(int i=l1.size()-1;i>=0;i--){
        //     l2.add(l1.get(i));
        // }
        // return l1.equals(l2);

        //space optimized solution
        ListNode slow=head;
        ListNode fast=head;
        //step1: find middle
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //step2: reverse mid to high ll
        fast=slow.next;
        ListNode temp=fast.next;
        ListNode prev=null;
        slow.next=null;
        while(temp!=null){
            fast.next=prev;
            prev=fast;
            fast=temp;
            temp=temp.next;
        }
        fast.next=prev; //link last node
        slow=head; //point slow to head
        while(slow!=null && fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;

        //simpler way
        // ListNode temp = head;
        // int num = 0;
        // int rev = 0;
        // int mul = 1;

        // while(temp != null) {

        //     num = num * 10 + temp.val;
        //     rev = rev + temp.val * mul; 
        //     mul *= 10;

        //     temp = temp.next;
        // return num == rev;
        // }
    }
}

//Problem 2: Balanced Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//1]Check for each node iteratively-> return left height and right height difference +1 for each node -> if difference greater than 1 return -1. 
class Solution {
    //O(nlogn) O(1)
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null) return true;
    //     leftH=helperL(root.left);
    //     rightH=helperL(root.right);
    //     if(Math.abs(leftH-rightH)>1) return false; //if at any given time, height is unequal, return false
    //     return isBalanced(root.left) && isBalanced(root.right); //check for all possible nodes,
    // }
    // private int helperL(TreeNode root){
    //     if(root==null)
    //         return 0;
    //     return (1+Math.max(helperL(root.left), helperL(root.right)));
    // }

    //O(n) O(1)
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return helperL(root)!=-1; // if we get -1 -> some of the node is unbalanced.
    }
    private int helperL(TreeNode root){
        if(root==null) return 0;
        int left=helperL(root.left); //explore left height
        int right=helperL(root.right); //explore right height
        if(left==-1 || right==-1) return -1; // if left - right is more than 1 return -1, check and again return -1
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right) +1; // if diff not more than 1 , return max height between both +1
    }