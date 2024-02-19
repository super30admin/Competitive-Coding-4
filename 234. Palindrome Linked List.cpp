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
    Time: O(N)
    Space: O(1)
    
    Split the list into two equal halves and reverse the 2nd half
    The first half goes from left to right
    The second half goes from right to left
    Checking palindrome becomes trivial now
    */

    //Reverse the list and return the head of the reversed list
    ListNode* reverse(ListNode* node){
      if(node==nullptr || node->next == nullptr)  return node;
      ListNode *curr = node, *nxt = node->next;

      while(nxt!=nullptr) {
        ListNode* tmp = nxt->next;
        
        nxt->next = curr;
        if(curr->next == nxt)  curr->next = nullptr;

        curr = nxt;
        nxt = tmp;
      }
      
      return curr;
    }

    bool isPalindrome(ListNode* head) {
      //edge case: one node
      if(head->next == nullptr)  return true;

      ListNode* slow = head;            
      ListNode* fast = head->next;

      //get middle node
      while(fast!=nullptr && fast->next!=nullptr){
        slow = slow->next; //slow moves by one step
        fast = fast->next->next; //fast moves by two steps
      }

      ListNode* tail = reverse(slow->next);
      slow->next = nullptr;

      //now we have have split the list into two equal halves
      //the first half goes from left to right
      //the second half goes from right to left
      //checking palindrome becomes trivial now
      while(head!=nullptr && tail!=nullptr){
        if(head->val != tail->val)  return false;
        head = head->next;
        tail = tail->next;  
      }

      return true;

    }
};
