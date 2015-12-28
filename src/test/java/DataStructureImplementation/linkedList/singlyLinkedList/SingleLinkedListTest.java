package DataStructureImplementation.linkedList.singlyLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jason on 12/28/15.
 */
public class SingleLinkedListTest {

    @Test
    public void testAdd() throws Exception {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(15);
        singleLinkedList.add(16);
        singleLinkedList.add(10);
        System.out.println("");
    }
}