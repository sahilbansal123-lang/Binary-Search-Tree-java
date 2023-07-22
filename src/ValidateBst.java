public class ValidateBst {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean validateBst(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (root != null && root.data <= min.data) {
            return false;
        }
        if (root != null && root.data >= max.data) {
            return false;
        }

        return validateBst(root.left, min, root) && validateBst(root.right, root, max);
    }

    public static void main(String[] args) {

    }
}
