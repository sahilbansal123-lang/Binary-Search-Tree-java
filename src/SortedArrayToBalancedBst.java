public class SortedArrayToBalancedBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node sortedBst(int arr[], int strt, int end) {

        if (strt > end) {
            return null;
        }

        int mid = (strt + end)/2;

        Node root = new Node(arr[mid]);

        root.left = sortedBst(arr, strt, mid-1);
        root.right = sortedBst(arr,mid+1, end);


        return root;
    }

    public static void main(String[] args) {

    }
}
