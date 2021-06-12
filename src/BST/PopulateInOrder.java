package BST;

import java.util.LinkedList;

public class PopulateInOrder {
    static class Node{
        int data;
        Node left,right,next;

        public Node(int data) {
            this.data = data;
            left = right = next = null;
        }
    }
    static Node next = null;
    //recursive approach
    static void populateInorder(Node root){
        if(root == null){
            return;
        }
        else {
            populateInorder(root.right);
            root.next = next;
            next = root;
            populateInorder(root.left);
        }

    }
    //iterative approach
    static LinkedList<Node> list = new LinkedList<>();
    static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    static void populateInorder1(Node root){
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size()-1){
                list.get(i).next = list.get(i+1);
            }
            else {
                list.get(i).next = null;
            }
        }
        Node ptr = root.left.left;
        while (ptr != null){
            int print = (ptr.next != null ? ptr.next.data : -1);
            System.out.print(ptr.data + " -> " + print + " , ");
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        populateInorder(root);
        Node ptr = root.left.left;
        while (ptr != null){
            int print = (ptr.next != null ? ptr.next.data : -1);
            System.out.print(ptr.data + " -> " + print + " , ");
            ptr = ptr.next;
        }
        System.out.println();
        populateInorder1(root);
    }
}
