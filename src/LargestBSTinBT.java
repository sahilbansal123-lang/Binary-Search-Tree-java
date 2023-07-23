public class LargestBSTinBT {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;

        Info( boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSize = 0;
    public static Info largestBst(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBst(root.left);
        Info rightInfo = largestBst(root.right);
        // This Info is for the curr root
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // isValid BST condition

        if (root.data <= leftInfo.max && root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBst && rightInfo.isBst) {
            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {

    }

}
