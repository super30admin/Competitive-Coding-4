"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        """
        list node constructor
        """
        self.val = val
        self.next = next


def createLinkedList(array_order):
    """
    Used for creating a linked list.
    """
    if array_order is None:
        return None
    head = ListNode(val=array_order[0])
    curr = head
    for i in range(1, len(array_order)):
        new_node = ListNode(array_order[i])
        curr.next = new_node
        curr = new_node
    return head


def isPalindrome(head) -> bool:
    """
    reversing the second half of the linkedlist in place, and then
    traversing them simultaneously to check that values are equal.
    """
    def reverse(head):
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    if head is None:
        return False

    # find the mid
    slow = head
    fast = head

    while fast != None and fast.next != None:
        slow = slow.next
        fast = fast.next.next

    head2 = reverse(slow)
    # slow.next = None
    curr = head

    while curr != None and head2 != None:
        if curr.val != head2.val:
            return False
        curr = curr.next
        head2 = head2.next

    return True


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    head1 = createLinkedList([1, 2, 2, 1])
    print(isPalindrome(head1))  # returns True
    head2 = createLinkedList([1, 2])
    print(isPalindrome(head2))  # returns False


if __name__ == "__main__":
    main()
