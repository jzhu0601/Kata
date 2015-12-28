package DataStructureImplementation.linkedList.doublyLinkedList;

/**
 * Created by Jason on 12/28/15.
 */
public class LinkedListImpl<E> {

    private int size;
    private ListNode<E> head;
    private ListNode<E> tail;

    public LinkedListImpl() {
        size = 0;
        head = new ListNode<>(null);
        tail = new ListNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

}
