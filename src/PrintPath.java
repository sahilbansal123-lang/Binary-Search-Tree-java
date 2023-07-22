import java.util.ArrayList;

public class PrintPath {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    //  Ques6: Print all paths
    public static void printAllPaths(Node root, ArrayList<Integer> pathNodes) {
        if (root == null){
            return;
        }
        pathNodes.add(root.data);
        if (root.left == null && root.right == null){
            printPath(pathNodes);
        } else {
            printAllPaths(root.left, pathNodes);
            printAllPaths(root.right, pathNodes);
        }
        pathNodes.remove(pathNodes.size()-1);
    }

    private static void printPath(ArrayList<Integer> pathNodes) {
        for (int i = 0; i < pathNodes.size(); i++) {
            System.out.print(pathNodes.get(i) + "->");
        }System.out.println();
    }

    public static void main(String[] args) {

    }

}
