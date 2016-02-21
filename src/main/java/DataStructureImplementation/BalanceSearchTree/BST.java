package DataStructureImplementation.BalanceSearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2/19/16.
 */
public class BST {

    Node root;

    public BST() {
        this.root = null;
    }

    public boolean find(int id) {
        Node curr = root;
        while (curr != null) {
            if (curr.data == id)
                return true;
            else if (curr.data < id)
                curr = curr.rightChild;
            else
                curr = curr.leftChild;
        }
        return false;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public void display(Node node) {
        if (node != null) {
            display(node.leftChild);
            System.out.println(node.data);
            display(node.rightChild);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node node1 = new Node(1);
        Node node2 = new Node(-3);
        Node node3 = new Node(3);
        bst.root = node1;
        node1.leftChild = node2;
        node1.rightChild = node3;
        System.out.println(bst.find(14));
        bst.display(node1);
    }
}

class InOrderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(Node root) {
        if (root != null) {
            helper(root);
        }

        return result;
    }

    public void helper(Node p) {
        if (p.leftChild != null)
            helper(p.leftChild);

        result.add(p.data);

        if (p.rightChild != null)
            helper(p.rightChild);
    }
}


class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}