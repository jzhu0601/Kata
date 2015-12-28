package DataStructureImplementation.linkedList.doublyLinkedList;

/**
 * Created by Jason on 12/28/15.
 */
public class ListNode<E> {

    E data;

    //recursive data type!
    ListNode<E> next;
    ListNode<E> prev;

    public ListNode(E data) {
        this.data = data;
    }

}
