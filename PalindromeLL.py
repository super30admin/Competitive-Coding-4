class Solution:
    def isPalindrome(self, head):

        if not head or not head.next:
            return True

        # 1. Find middle
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # 2. Reverse second half
        prev = None

        while slow:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node

        # prev is the head of reversed second half
        second = prev
        first = head

        # 3. Compare halves
        while second:
            if first.val != second.val:
                return False

            first = first.next
            second = second.next

        return True

    # values = []
    # 
    # while head:
    #     values.append(head.val)
    #     head = head.next
    #
    # return values == values[::-1]

   # TC - O(n)
   # SC - O(1)