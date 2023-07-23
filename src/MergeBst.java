import java.util.ArrayList;

public class MergeBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBst(ArrayList<Integer> list, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBst(list, st, mid-1);
        root.right = createBst(list, mid+1, end);

        return root;
    }

    public static Node mergeBst(Node root1, Node root2) {

        // Step1 --> get inorder for root 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step2 --> get Inorder for root 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 3 --> merge arr1, arr2
        int i = 0, j = 0;
        ArrayList<Integer> finalArray = new ArrayList<>();
        while (i < arr1.size() || j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArray.add(arr1.get(i));
                i++;
            } else {
                finalArray.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalArray.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalArray.add(arr2.get(j));
            j++;
        }

        // Step4 --> Sorted ArrayList to BST
        Node root = createBst(finalArray, 0, finalArray.size()-1);

        return root;
    }

    public static void main(String[] args) {

    }
}
