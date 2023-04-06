
//    Binary Search Tree (BST): is a binary tree data structure where each node has at most two child nodes, left and
//            right, and the left child node has a value less than or equal to its parent node, while the right child
//            node has a value greater than or equal to its parent node. This property ensures that all nodes in the
//            left subtree of a node have smaller values, and all nodes in the right subtree of a node have larger
//            values. The value of the root node is typically used as the key to search for a node in the tree.

//            Binary Search Trees are often used to implement efficient searching and sorting algorithms. Searching
//            for a value in a BST can be done in O(log n) time complexity in the average and best cases, where n is
//            the number of nodes in the tree. This is because each search operation reduces the search space by half,
//            similar to how binary search works on a sorted array.



public class Main {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node right, Node left){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    static class BinarySearchTree {
        public static void buildTree(Node root) {
            if (root == null){
                root = new Node(data);
            }

            Node newNode = new Node();


        }
    }

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}