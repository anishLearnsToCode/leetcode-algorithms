import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
//        ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
//        TreeNode treeNode = c.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
//        TreePrinter.print(treeNode);
//
//        c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
//        treeNode = c.buildTree(new int[] {2, 1}, new int[] {2, 1});
//        TreePrinter.print(treeNode);
//
//        c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
//        treeNode = c.buildTree(new int[] {-1}, new int[] {-1});
//        TreePrinter.print(treeNode);

        ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode treeNode = c.buildTree(new int[] {1, 2, 3, 4}, new int[] {2, 1, 3, 4});
        TreePrinter.print(treeNode);
    }
}
