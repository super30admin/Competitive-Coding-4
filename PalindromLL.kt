// In this problem we are given a linked list is palindrome or not. We can solve this problem by using the fast and slow pointer technique. 
// We will use the fast and slow pointer to find the middle of the linked list. Once we find the middle of the linked list, we will reverse the second half of the linked list and then compare both halves of the linked list. If both halves are same then we will return true otherwise we will return false.
// Time complexity: O(n) where n is the number of nodes in the linked list.
// Space complexity: O(1) as we are using constant space to reverse the linked list

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        
        if(head == null || head.next == null) return true 

        var slow : ListNode? = head
        var fast : ListNode? = head

        while(fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        
val reverseHead = reverse(slow)
        var secondPtr = reverseHead
        var firstPtr = head

        // Compare both halves
        while (secondPtr != null) {
            if (firstPtr?.`val` != secondPtr.`val`) return false
            firstPtr = firstPtr?.next
            secondPtr = secondPtr.next
        }

        return true

    }

    private fun reverse(curr: ListNode?) : ListNode? 
    {
        var newCurr = curr
        var prev : ListNode? = null 
        while(newCurr != null) {
            var temp = newCurr.next
            newCurr.next = prev
            prev = newCurr
            newCurr = temp
        }

        return prev
    }
}