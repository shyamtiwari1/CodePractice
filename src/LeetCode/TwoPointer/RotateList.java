package LeetCode.TwoPointer;

public class RotateList {

//    https://leetcode.com/problems/rotate-list/

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;

        ListNode head = buildList(arr);


        ListNode rotated = rotateRight(head, k);

        while(rotated!=null){
            System.out.println(rotated.val);
            rotated = rotated.next;
        }


    }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        public static ListNode rotateRight(ListNode head, int k) {
            int len = getLen(head);

                k= k%len;

            while(k!=0){
                ListNode secondLastNode = getSecondLastNode(head , len);
                ListNode lastNode = secondLastNode.next;
                lastNode.next = head;
                secondLastNode.next = null;
                head = lastNode;
                k--;
            }
            return head;

        }

        public static int getLen(ListNode head){
            if(head ==null){
                return 0;
            }
            int len = 1 ;
            while(head.next!=null){
                len++;
                head = head.next;
            }
            return len;
        }

        public static ListNode getSecondLastNode(ListNode head , int n ){
            int i = 0 ; int j = 0 ;
            while(n-2!=0){
                head= head.next;
                n--;
            }
            return head;

        }
    }

