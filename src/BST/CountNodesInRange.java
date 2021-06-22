package BST;

public class CountNodesInRange {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static int counter = 0;
    //first approach
    static void nodeCounter(Node root, int low, int high){
        if(root == null){
            return;
        }
        nodeCounter(root.left,low,high);
        if(root.data >= low && root.data <= high){
            counter++;
        }
        nodeCounter(root.right,low,high);
    }
    //another approach
    static int nodeCounter2(Node root, int low, int high){
        if(root == null){
            return 0;
        }
        if(root.data >= low && root.data <= high){
            return 1 + nodeCounter2(root.left,low,high) + nodeCounter2(root.right,low,high);
        }
        else if(root.data < low){
            return nodeCounter2(root.right,low,high);
        }
        else {
            return nodeCounter2(root.left,low,high);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.right = new Node(100);
        root.right.left = new Node(40);
        nodeCounter(root,5,45);
        System.out.println(counter);
        System.out.println(nodeCounter2(root,5,45));
    }
}
