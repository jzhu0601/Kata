package DataStructureImplementation;

import java.util.Stack;

/**
 * Created by Jason on 2/18/16.
 */
public class NodeLink {

    private int value;

    private NodeLink nextNode;

    public NodeLink(int val) {
        value = val;
    }

    void print(NodeLink nl) {
        while (nl != null) {
            System.out.println(nl.value);
            nl = nl.nextNode;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.push(1));
        stack.push(15);
        stack.push(125);stack.push(135);
        stack.push(115);

       // System.out.println(stack.pop());
        System.out.println(stack.search(125));
    }
}
