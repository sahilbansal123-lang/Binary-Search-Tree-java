public class MirrorsOfBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    public static Node MirrorImage(Node root) {
        if (root == null) {
            return null;
        }

        Node left = MirrorImage(root.left);
        Node right = MirrorImage(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

    }
}
