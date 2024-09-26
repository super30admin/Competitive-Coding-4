//<---BruteForce--->
//Time Complexity O(n)
//Space Complexity O(n) Stack space

class Node { 
    int data; 
    Node ptr; 
    Node(int d) 
    { 
        ptr = null; 
        data = d; 
    } 
} 

class linkedList {     
    static boolean isPalindrome(Node head) 
    { 
  
        Node slow = head; 
        boolean ispalin = true; 
        Stack<Integer> stack = new Stack<Integer>(); 
  
        while (slow != null) { 
            stack.push(slow.data); 
            slow = slow.ptr; 
        } 
  
        while (head != null) { 
  
            int i = stack.pop(); 
            if (head.data == i) { 
                ispalin = true; 
            } 
            else { 
                ispalin = false; 
                break; 
            } 
            head = head.ptr; 
        } 
        return ispalin; 
    } 
    public static void main(String args[]) 
    { 
        Node one = new Node(1); 
        Node two = new Node(2); 
        Node three = new Node(3); 
        Node four = new Node(4); 
        Node five = new Node(3); 
        Node six = new Node(2); 
        Node seven = new Node(1); 
        one.ptr = two; 
        two.ptr = three; 
        three.ptr = four; 
        four.ptr = five; 
        five.ptr = six; 
        six.ptr = seven; 
        boolean condition = isPalindrome(one); 
        System.out.println("isPalidrome :" + condition); 
    } 
} 

<-----Recursion---->
// Time Complexity : O(N) where N is number of nodes in linkedlist
// Space Complexity : O(1) 

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){ // find the middle point using slow and fast pointers
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow = reverse(slow);       // get the head of the second half of the linkedlist which is now reversed
        fast = head;
        
        while(slow != null){
            if(slow.val != fast.val){       // compare fast and slow values, if not equal then return false
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;  // it's a palindrome
    }
    private ListNode reverse(ListNode head){	// reverse the linkedlist using prev, curr and next point method
        ListNode prev = null;        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }   
        return prev;
    }
}

