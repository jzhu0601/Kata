package DataStructureImplementation.linkedList.singlyLinkedList;

/**
 * Created by Jason on 12/28/15.
 */
public class SingleLinkedList<E> {


    Node<E> head;
    Node<E> tail;

    public void add(E data) {
        Node<E> node = new Node<>(data);
        //Empty List
        if (tail == null) {
            head = node;
            tail = node;
        }
        //Non-empty list
        else {
            tail.nextNode = node;
            tail = node;
        }
    }

    public Node<E> delete(E data) {
        Node<E> node = findNode(data);

        if (node != null) {
            //non-empty list

            //at tail
            if (tail == node) {

            }
        } else {
            //empty list
            return null;
        }
        return null;
    }

    public Node<E> findNode(E data) {
        if (head == null) return null;
        if (head.data == data) return head;

        Node<E> node = head;

        while (head.nextNode != null) {
            node = node.nextNode;
            if (node.data == data) return node;
        }
        return null;
    }

}
