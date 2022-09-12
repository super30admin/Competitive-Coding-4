// Time Complexity : O(n) where n is the length of linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

//Method 2 - Optimised Space
public class ReversePalindrome {
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
        public boolean isPalindrome(ListNode head) {

            //null check
            if(head == null)
                return true;

            ListNode left = findingMid(head);
            if(head.next == null)
                return true;
            ListNode right = reverseList(left.next);

            ListNode p1 = head;
            ListNode p2 = right;


            while(p2 != null){
                if(p1.val != p2.val){
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;

        }
        //finding mid element
        private ListNode findingMid(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        //reverse list
        private ListNode reverseList(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            ListNode fast = curr.next;

            while(fast != null  ){
                curr.next = prev;
                prev = curr;
                curr = fast;
                fast = fast.next;
            }

            curr.next = prev;
            return curr;
        }
}

/*
//Method 1 - Copying the contents on LL to an Array and then doing 2 pointers approach to check for palindrome

//TC: O(n) and SC: O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public boolean isPalindrome(ListNode head) {

        List<Integer> li = new ArrayList<>();

        //Convert the LL to arraylist
        ListNode currNode = head;
        while(currNode != null){
            li.add(currNode.val);
            currNode = currNode.next;
        }

        //Use two pointers to check for palindrome
        int start = 0;
        int end = li.size() - 1;

        while(start < end){

            if(!li.get(start).equals(li.get(end))){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
*/