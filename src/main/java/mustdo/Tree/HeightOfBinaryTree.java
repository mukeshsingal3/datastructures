package mustdo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree extends TreeUtil {

    public static void main(String[] args) {
        HeightOfBinaryTree tree = new HeightOfBinaryTree();
        System.out.println("Height " + getHeightRec(getBinaryTree2()));
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (true) {
            int nodeCount = queue.size();
            if (nodeCount <= 0)
                return height;
            height++;
            while (nodeCount > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(getHeightRec(node.left), getHeightRec(node.right)) + 1;
    }
}
