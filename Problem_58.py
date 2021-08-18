class Solution:

    def isPalindrome(self, head: ListNode) -> bool:

        if head == None:

            return True

        fast = head.next

        slow = head

        while fast != None and fast.next != None:

            fast = fast.next.next
            slow = slow.next
        head2 = slow.next 

        slow.next = None

        old = new = None
        cur = head2

        while cur != None:

            new = cur.next

            cur.next = old

            old = cur

            cur = new

        head2 = old

        temp1 = head

        temp2 = head2

        while temp1 != None and temp2 != None:

            if temp1.val != temp2.val:

                return False

            temp1 = temp1.next

            temp2 = temp2.next

        return True


# TC : O(n) 
# SC:O(1)