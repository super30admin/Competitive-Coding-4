package main

import "fmt"

func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}
	var arr []int
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}
	n := len(arr)
	fmt.Println(arr)
	for i := 0; i <= n/2; i++ {
		if arr[i] == arr[n-(i+1)] {
			continue
		}
		if i == n/2 {
			break
		}
		if arr[i] != arr[n-(i+1)] {
			return false
		}
	}
	return true
}
