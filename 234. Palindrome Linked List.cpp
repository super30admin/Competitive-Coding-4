class Solution {
public:
//Checking palindrome by inserting in an array
    //Time complexity : O(n)
    //Space complexity : O(n)
    bool isPalindrome(ListNode* head) {
        vector <int> h;
        ListNode *p;
        p=head;
        while(p!=NULL){
            h.push_back(p->val);
            p=p->next;
        }
        int j=h.size()-1;
        for(int i=0;i<j;i++,j--){
            if(h[i]!=h[j]){
                return false;
            }
        }
        return true;
    }
};
//REVERSE 2ND PART OF LINKED LIST
//TC-O(N)
//SC-O(1)
class Solution {
public:
    ListNode* Reverse(ListNode* slow){
        if(!slow||!slow->next)return slow;
        ListNode* prev=NULL;
        ListNode* curr=slow;
        ListNode* fast=slow;
        while(curr){
            fast=fast->next;
            curr->next=prev;
            prev=curr;
            curr=fast;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        if(!head||!head->next)return true;
        ListNode* slow=head;
        ListNode* faster=head;
        while(faster->next&&faster->next->next){
            slow=slow->next;
            faster=faster->next->next;
            
        }
        slow->next=Reverse(slow->next);
        slow=slow->next;
      
        while(slow){
            if(slow->val!=head->val)return false;
            slow=slow->next;
            head=head->next;
        }
        return true;
    }
};