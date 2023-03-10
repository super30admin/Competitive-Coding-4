234. Palindrome Linked List

TC O(n)
SC O(1)


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
 /*   
    int length(ListNode* head, ListNode** slow) {
        if (head == NULL)
            return 0;
        int count=0;
        ListNode* slow_prt = head;
        ListNode* temp = head;
        while ((temp->next != NULL) && (temp->next->next != NULL)) {
            slow_prt = slow_prt->next;
            temp = temp->next->next;
            count+=2;
        }
        *slow = slow_prt;
        return count;
    }
    
    ListNode* reverse(ListNode* head) {
        ListNode* prev = NULL;
        ListNode* temp = head;
        ListNode* next;
        while (temp!= NULL) {
            next = temp;
            prev = temp;
            temp->next = prev;
            temp = next;
        }
        return prev;
    }
    
    bool compare(ListNode* l1, ListNode* l2, int count) {
        while ((l1 != NULL) && (l1!= NULL) && (count>0)) {
            if (l1->val != l2->val)
                return false;
            count--;
        }
        return true;
    }
    
    
    
    bool isPalindrome(ListNode* head) {
        ListNode* rh;
        int count = length(head, &rh)/2;
        rh = reverse(rh);
        return (compare(head,rh, count));   
    }
    */
    
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head,*fast=head,*mid=NULL;
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        if(fast!=NULL)
        {
            mid=slow->next;
        }
        else
        {
            mid=slow;
        }
        ListNode* prev=NULL,*next=NULL;
        while(mid!=NULL)
        {
            next=mid->next;
            mid->next=prev;
            prev=mid;
            mid=next;
        }
        while(prev!=NULL)
        {
            if(head->val!=prev->val)
            {
                return false;
            }
            prev=prev->next;
            head=head->next;
        }
        return true;
    }
    
    
};


