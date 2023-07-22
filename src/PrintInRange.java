public class PrintInRange {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printInRange(Main.Node root, int r1, int r2) {

        if (root == null){
            return;
        }

        // Case1
        if (root.data >= r1 && root.data <= r2) {
            printInRange(root.left , r1, r2);
            System.out.print(root.data + " ");
            printInRange(root.right, r1, r2);
        }

        // Case2
        else if (root.data >= r2){
            printInRange(root.left, r1, r2);
        }
        // Case3 root.data <= r1
        else {
            printInRange(root.right, r1, r2);
        }
    }


    public static void main(String[] args) {

    }
}
