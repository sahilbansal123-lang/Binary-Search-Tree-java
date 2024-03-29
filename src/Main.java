
//    Binary Search Tree (BST): is a binary tree data structure where each node has at most two child nodes, left and
//            right, and the left child node has a value less than or equal to its parent node, while the right child
//            node has a value greater than or equal to its parent node. This property ensures that all nodes in the
//            left subtree of a node have smaller values, and all nodes in the right subtree of a node have larger
//            values. The value of the root node is typically used as the key to search for a node in the tree.

//            Binary Search Trees are often used to implement efficient searching and sorting algorithms. Searching
//            for a value in a BST can be done in O(log n) time complexity in the average and best cases, where n is
//            the number of nodes in the tree. This is because each search operation reduces the search space by half,
//            similar to how binary search works on a sorted array.

//----------------------------------------------------------------------------------------------------------------------

import java.util.*;
public class Main {

        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
            }
        }

        public static Node insert(Node root, int val) {
            if (root == null){
                root = new Node(val);
                return root;
            }
            if (root.data > val){
                // Root ke left mein insertion
                root.left = insert(root.left, val);
            } else {
                // Root ke right mein insertion
                root.right = insert(root.right, val);
            }
            return root;
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

//    Ques2: Search for key in bst

    public static boolean search(Node root, int key) {

        if (root == null){
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);
        }
        else if (root.data == key){
            return true;
        }
        else{
            return search(root.right, key);
        }
    }

//    Ques3: delete node from the BST
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else if (root.data < val){
            root.right = delete(root.right, val);
        } else { // root.data == val
            // Case1
            if (root.left == null && root.right == null){
                return null;
            }
            // Case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            Node IS = inOrderSucessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSucessor(Node root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
//        System.out.println();
//
//       delete(root, 2);
//       inOrder(root);
        System.out.println();
        System.out.println();
    }
}