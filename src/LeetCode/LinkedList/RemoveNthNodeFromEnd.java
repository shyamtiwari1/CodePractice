package LeetCode.LinkedList;

public class RemoveNthNodeFromEnd {

//    https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/




      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            int len = LenghtOfList(head);
            if(len==n){
                return head.next;
            }
            ListNode currNode = head;
            for(int i = 1 ; i<len-n;i++){
                currNode = currNode.next;
            }
            if(currNode.next!=null)
                currNode.next = currNode.next.next;
            return head;


        }



        public int LenghtOfList(ListNode head){
            int len = 0 ;

            while(head!=null){
                head = head.next;
                len++;
            }
            return len;
        }
    }
}
