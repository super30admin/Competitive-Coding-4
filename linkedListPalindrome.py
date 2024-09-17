# One of the approach is to use the fast and slow pointer to find the mid of linked list, then cut the list into 2, reverse one list and compare them, if both are same then its a palindrome
# time Complexity: O(n)
# Space complexity: O(1)
class node:
    def __init__(self, val, next):
        self.val = val
        self.next = next
class pal:
    def isPalindrome(self, head):
        if head is None:
            return None
        fast = head.next
        slow = head
        while(fast is not None or fast.next is not None):
            fast = fast.next.next
            slow = slow.next

        anotherHead = slow.next
        slow.next = None
        prev = None
        curr = anotherHead
        next = None
        while(curr is not None):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        anotherHead = prev
        while(head is not None or anotherHead is not None):
            if (head.val != anotherHead.val):
                return False
            else:
                head = head.next
                anotherHead = anotherHead.next
        return True