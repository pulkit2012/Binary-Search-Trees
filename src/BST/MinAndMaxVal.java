package BST;

public class MinAndMaxVal {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node insert(Node root,int data){
        if(root == null){
            return (new Node(data));
        }
        else {
            if(data < root.data){
                root.left = insert(root.left,data);
            }
            else {
                root.right = insert(root.right,data);
            }
        }
        return root;
    }
    static int minValue(Node root){
        Node curr = root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }
    static int maxValue(Node root){
        Node curr = root;
        while (curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        insert(root,2);
        insert(root,3);
        insert(root,4);
        insert(root,5);
        System.out.println(maxValue(root));
        System.out.println(minValue(root));
    }
}
