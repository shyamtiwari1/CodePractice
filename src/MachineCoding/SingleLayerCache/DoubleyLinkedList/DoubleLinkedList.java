package MachineCoding.SingleLayerCache.DoubleyLinkedList;

public class DoubleLinkedList<Key ,Value> {

    ListNode head  ;
    ListNode tail;

    public DoubleLinkedList(){
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);

        head.next = tail;
        tail.prev = head;
    }


    public void insertAfterHead(Key key , Value value){
        ListNode newnode = new ListNode(key , value);
        ListNode temp = head.next;
        head.next = newnode ;
        newnode.prev = head ;
        newnode.next = temp ;
        temp.prev = newnode ;
    }

    public void deleteNode(ListNode node){
        ListNode prevnode = node.prev;
        ListNode nextnode = node.next;

        prevnode.next = nextnode;
        nextnode.prev = prevnode;
    }




}
