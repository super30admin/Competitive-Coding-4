// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Traverse the linked list and store its values in an ArrayList.
// 2. Use two pointers (start and end) to compare elements from both ends toward the center.
// 3. If all pairs match, it's a palindrome; otherwise, it's not.


import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}


public class PalindromeLinkedList {
    public boolean solve(ListNode head){
        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int l=0;
        int r = arr.size()-1;
        while(l<r && arr.get(l) == arr.get(r)){
            l++;
            r--;
        }
        return l>=r;
    }

    public static void main(String[]args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2,  new ListNode(1))));
        PalindromeLinkedList ob = new PalindromeLinkedList();
        System.out.println(ob.solve(head));
        

    }
    
}
