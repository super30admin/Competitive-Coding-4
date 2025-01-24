/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution
{
    public bool IsPalindrome(ListNode head)
    {
        if (head == null)
        {
            return true;
        }

        Stack<int> stack = new Stack<int>();
        int length = 0;
        ListNode current = head;
        while (current != null)
        {
            length++;
            current = current.next;
        }
        Console.WriteLine(length);
        int count = length / 2;
        current = head;
        while (count > 0)
        {
            stack.Push(current.val);
            current = current.next;
            count--;
        }

        if (length % 2 == 1)
        {
            current = current.next;
        }

        while (current != null)
        {
            if (stack.Count == 0)
            {
                return false;
            }
            int number = stack.Pop();
            if (current.val != number)
            {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}