package geeksforgeeks.problems.Tree.Youtube;

import ds.trees.MyBinaryTree;
import ds.Queue.MyQueue;


/**
 *  Leaf nodes are node which has no children.
 *                      2
 *                     / \
 *                    7   5
 *                   \      \
 *                   6       9
 *                  /  \     /
 *                1     11   4
 * Ans: 1 11 9
 * Hence Count is 3
 * */
public class Problem6_Count_leaf_nodes_in_a_Binary_Tree_Iterative_Method {
    public static void count(MyBinaryTree tree) {
        MyQueue<MyBinaryTree.Node> queue = new MyQueue<>(8);
        queue.enQueue(tree.root);
        int count = 0;
        while (!queue.isEmpty()) {
            MyBinaryTree.Node node = queue.deQueue();
            if (node.left == null && node.right == null)
                count++;
            if (node.left != null) queue.enQueue(node.left);
            if (node.right != null) queue.enQueue(node.right);
        }
        System.out.println("Actual Answer : " + count);
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>(2);
        tree.root.left = new MyBinaryTree.Node(7);
        tree.root.right = new MyBinaryTree.Node(5);
        tree.root.left.right = new MyBinaryTree.Node(6);
        tree.root.left.right.left = new MyBinaryTree.Node(1);
        tree.root.left.right.right = new MyBinaryTree.Node(11);
        tree.root.right.right = new MyBinaryTree.Node(9);
        tree.root.right.right.left = new MyBinaryTree.Node(4);
        System.out.println("Expected Ans : " + 3);
        count(tree);
    }
}
