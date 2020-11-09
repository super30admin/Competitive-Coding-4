// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if head is nil return true
find mid point by moving slow and fast by 1 and 2 respectively
reverse the second half
check from start and mid point if elements are same if not return false
*/
package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// reversal
	temp := slow
	rev := &ListNode{Val: -1}
	for temp != nil {
		x:= temp
		temp = temp.Next
		x.Next = rev.Next
		rev.Next = x
	}

	// checking if equal
	y := rev.Next
	for head != slow && y != nil {
		if head.Val != y.Val {
			return false
		}
		head = head.Next
		y = y.Next
	}
	return true
}

func MainPalindrome() {
	x := &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 3}}}
	fmt.Println(isPalindrome(x)) //expected true
}
