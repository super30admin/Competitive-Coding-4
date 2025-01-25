############# Linked List Palindrome #########


# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# first split the list in the middle then reverse the seond half of the list and then using two pointers check the value and keep advancing

def reverseList(head):
    if not head:
        return head
    prev = None
    curr = head
    fast = head.next

    while fast:
        curr.next = prev
        prev = curr
        curr = fast
        fast = fast.next
    curr.next = prev
    return curr


def check_is_palindrome(head):
        if not head:
            return False

        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        list2 = slow.next
        slow.next = None
        p1 = reverseList(list2)
        p2 = head

        while p1 and p2:
            if p1.val!=p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        
        if (p1 and p1.next) or (p2 and p2.next):
            return False
        return True


        
        
