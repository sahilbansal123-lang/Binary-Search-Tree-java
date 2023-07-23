import java.util.ArrayList;

public class ConvertBSTtoBalancedBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBst(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBst(inorder, st, mid-1);
        root.right = createBst(inorder,mid+1, end);

        return root;
    }

    public static Node balancedBst(Node root) {
        // Step1 --> Get inorder
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // step2 --> GetInorder --> BalancedBst
        root = createBst(inorder, 0, inorder.size()-1);

        return root;
    }

    public static void main(String[] args) {

    }
}
