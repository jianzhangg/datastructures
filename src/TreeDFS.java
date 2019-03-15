import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: 张健
 * @CreateDate: 2019-03-14 10:02
 * @Version: 1.0
 * @Description: 树的深度优先搜索 与图相比 少了个visited数组存放已读取的元素
 */
public class TreeDFS {

    private static void dfsRecursive(List<Integer> visited, TreeNode node) {
        if (visited == null || node == null) return;
        visited.add(node.val);
        if (node.left != null) dfsRecursive(visited, node.left);
        if (node.right != null) dfsRecursive(visited, node.right);
    }

    private static List<Integer> dfs(TreeNode root) {
        ArrayList<Integer> visited = new ArrayList<>();
        if (root == null) return visited;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            visited.add(pop.val);
            if (pop.right!=null) stack.push(pop.right);
            if (pop.left!=null) stack.push(pop.left);
        }
        return visited;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode tn0 = new TreeNode(8);
        TreeNode tn1 = new TreeNode(6);
        TreeNode tn2 = new TreeNode(10);
        TreeNode tn3 = new TreeNode(5);
        TreeNode tn4 = new TreeNode(7);
        TreeNode tn5 = new TreeNode(9);
        TreeNode tn6 = new TreeNode(11);
        tn0.left = tn1;
        tn0.right = tn2;
        tn1.left = tn3;
        tn1.right = tn4;
        tn2.left = tn5;
        tn2.right = tn6;
        List<Integer> list = new ArrayList<>();
//        dfsRecursive(list, tn0);
        list = dfs(tn0);
        System.out.println(list);
    }
}
