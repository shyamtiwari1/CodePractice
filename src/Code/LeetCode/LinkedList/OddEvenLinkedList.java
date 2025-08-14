package Code.LeetCode.LinkedList;

public class OddEvenLinkedList {

//    https://leetcode.com/problems/odd-even-linked-list/description/

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode oddnode = head ;
            ListNode evennode = head.next;
            ListNode evenhead = evennode;

            while( evennode !=null && evennode.next!=null){

                oddnode.next = evennode.next;
                oddnode = oddnode.next ;

                evennode.next = oddnode.next;
                evennode = evennode.next;
            }

            oddnode.next = evenhead;

            return head;
        }
    }
}
