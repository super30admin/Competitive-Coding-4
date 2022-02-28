/*
Time Complexity: O(N)
Space Complexity: O(1)
Run on leetcode: yes
Approach:

1. Reverse half of the ListNode and compare values
 */
public class PalindromeLinkedList {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!= null && fast.next.next!= null ){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversedNode = reverseList(slow.next);

        while(head!= null && reversedNode!= null){
            if(head.val!= reversedNode.val){
                return false;
            }
            head = head.next;
            reversedNode = reversedNode.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode node){
        ListNode prev = null;

        while(node!= null){
            ListNode curr = node.next;
            node.next = prev;
            prev = node;
            node = curr;
        }
        return prev;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);
        node.next = first;
        first.next = second;
        second.next = third;
        third.next = null;

        System.out.println(isPalindrome(node));
    }
}
