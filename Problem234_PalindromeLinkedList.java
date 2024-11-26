//234. Palindrome Linked List
//Given a singly linked list, determine if it is a palindrome.

/******************* Time complexity: O(n) ********************/
/******************* Space complexity: O(n) ********************/
//1. Brute Force: using ArrayList

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // creating and copying elements of LinkedList to ArrayList
        List<Integer> array = new ArrayList<>();
        ListNode current = head;
        while (current != null) {       // till end of list
            array.add(current.val);     // add to array
            current = current.next;     // keep iterating
        }
        int first = 0;                  // first element of the array
        int last = array.size() - 1;    // last element of array
        while (first < last) {
            //compare first element with last element
            if (!array.get(first).equals (array.get(last)) ){
                return false;
            }
            //iterating first to the next
            first++;
            //iterating last to the prev
            last--;
        }
        return true;
    }
}

/********************************************************************************* */

/************** Time Complexity: O(n) ***************/
/************** Space Complexity: O(1) ***************/
//Optimal: Reversing the LinkedList 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {

        boolean isPalindrome = true;
        //no node or single node
        if (head == null || head.next == null) return isPalindrome;

        // Find the end of first half and reverse second half.
        ListNode slow = head;
        ListNode fast = head;        
        
        while (fast.next!= null && fast.next.next != null) 
        {
            //using 2 pointer to get the middle element 
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //after getting the mid, reverse from mid+1
        fast = reverseList(slow.next);
        slow.next = null;           // to discard the nodes after slow pointer
        slow = head;                // pointing slow back to head
        while(fast != null)
        {
            //comparing the values of fast and slow
            if(slow.val != fast.val) 
            {
                return !isPalindrome; 
            }           
            //if same, increment to next for both slow and fast
            slow = slow.next;
            fast = fast.next;            
        }        
        return isPalindrome;    //true
    }

    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        //till end of current list
        while (curr != null) 
        {
            //store the current node in temp
            ListNode nextTemp = curr.next;         
            curr.next = prev;                       
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
