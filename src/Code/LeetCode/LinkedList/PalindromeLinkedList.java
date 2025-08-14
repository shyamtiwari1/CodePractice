package Code.LeetCode.LinkedList;

public class PalindromeLinkedList {

//    https://leetcode.com/problems/palindrome-linked-list/

    class Solution {
        public boolean isPalindrome(ListNode head) {

            ListNode slow = head;
            ListNode fast = head ;

            while(fast!= null && fast.next != null){
                slow = slow.next ;
                fast = fast.next.next;
            }
            ListNode secondhalfhead = reverseLinkedList(slow);
            ListNode p1 = head;
            ListNode p2 = secondhalfhead;

            while(p2 != null){
                if(p2.val != p1.val){
                    return false;
                }
                p1 = p1.next ;
                p2 = p2.next ;
            }
            return true;
        }

        public ListNode reverseLinkedList(ListNode head){

            ListNode temp = head ;
            ListNode prev = null;

            while(temp != null){
                ListNode nextNode = temp.next ;
                temp.next = prev;
                prev = temp ;
                temp = nextNode;
            }
            return prev;
        }
    }
}
