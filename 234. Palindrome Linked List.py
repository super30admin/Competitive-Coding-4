# Time: O(n)
# Space: O(1)

# First calculate the middle of the linked list
# Then reverse the second linked list
# After that loop on both of these lists checking their values are equal or not
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        reversedHead = slow.next
        slow.next = None

        curr = reversedHead
        prev = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr  
            curr = temp

        head1 = head
        head2 = prev
        while head1 and head2:
            if head1.val != head2.val:
                return False
            head1 = head1.next
            head2 = head2.next
        return True