"""
// Time Complexity :O(n) for traversing till the end of the list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
Calculate the mid.
Reverse the LL from mid.
Compare reversed LL and LL from head till mid.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # edge case
        if head is None:
            return True

        # calculate the mid
        slow, fast = head, head
        while fast and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        # slow is mid value

        current = slow
        pointer1 = None
        while current:
            pointer3 = current.next
            # reverse operation
            current.next = pointer1
            pointer1 = current
            current = pointer3

        # pointer1 head of rll

        # compare
        slow = head
        fast = pointer1
        print(slow.val,fast.val)
        while fast and slow != fast:
            if slow.val != fast.val:
                return False
            else:
                slow = slow.next
                fast = fast.next
        return True


if __name__ == "__main__":
  ll = LinkedList()
  ll.insert(1)
  ll.insert(2)
  ll.insert(3)
  ll.insert(1)
  print(ll.stack)
  print(ll.checkPalindrome())
"""

# brute force
class Node:
  # constructor
  def __init__(self, data = None, next=None):
    self.data = data
    self.next = next

class LinkedList:
  def __init__(self):
    self.head = None
    self.length=0
    self.stack = []

  # Insert at the beggining of  LL
  def insert(self,data):
    current = self.head
    newNode = Node(data)
    if self.head is None:
      self.head = newNode
      self.stack.append(self.head.data)
    else:
      while current.next is not None:
        current = current.next
      current.next = newNode
      self.stack.append(current.next.data)

  def getTop(self):
    return self.stack[-1]

  def checkPalindrome(self):
    current = self.head

    while current.next is not None:
      if current.data == self.getTop():
        self.stack.pop(-1)
        current = current.next
      else:
        return False
    return True
"""



  """
  single linked list is used.
  so traversing reverse from the end of the linkedlist is not possible.

  Above step is not possible even if we use additional
  space(create a new sll that contains ll reverse)

  copy ll in stack. Check if ll value == stack top.
  if equal, pop. else return false.
  T = O(n) for traversing through LL. pop() is deleting value
  from the end of stack. So no value shifting required.
  S = O(n)


  """
