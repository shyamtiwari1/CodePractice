package SingleLayerCache.DoubleyLinkedList;

public class ListNode<Key , Value> {

    Key key;
    Value value;
    ListNode<Key , Value> next;
    ListNode<Key , Value>prev;


    public ListNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
