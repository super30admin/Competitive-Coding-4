/*
* Time Complexity : O(n)
* Space Complexity : O(1)
* Did it run on LeetCode : Yes.
* Any difficulty faced? : No. Understood the algorithm, took time  to code.
*/ 
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(head==NULL || head->next== NULL) return true;  
        ListNode * slow = head;
        ListNode * fast = head->next; // Starting of fast is one next to slow to accomodate odd and even linked lists.
            
            while(fast!=NULL && fast->next!=NULL)
            {
                slow=slow->next; // Slow pointer will reach the middle point of list.
                fast=fast->next->next; // Fast reaches the end of list.
            }
        
        
        
        ListNode* current = slow;
        ListNode* next1 = slow->next;
        slow->next=NULL;
        while(next1)      // Reversing the linked list to compare first and second half.
        {
            ListNode* temp = next1->next;
            next1->next=current;
            current=next1;
            next1=temp;
         }
        
        ListNode* startLeft=head; // Set the Start from Left side from head.
        ListNode* startRight= current;	// Right side from Current.
        
        while(startLeft && startRight)	// Until one of them reaches NULL, the loop will run.
        {
             if (startLeft->val != startRight->val)	// If at any point, a node is not equal to other, returns false.
            return false;
        startLeft = startLeft->next;
        startRight = startRight->next;
        }
        return true; // Else return true.
    } 
};