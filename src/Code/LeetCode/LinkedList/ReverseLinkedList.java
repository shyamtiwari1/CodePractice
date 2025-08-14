package Code.LeetCode.LinkedList;

public class ReverseLinkedList {

//    https://leetcode.com/problems/reverse-linked-list/description/



    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode temp = head ;
            ListNode prev = null ;
            while(temp !=null){
                ListNode nextNode = temp.next;
                temp.next = prev ;
                prev = temp ;
                temp = nextNode ;
            }
            return prev;

        }
    }
}
