import java.util.*;

/**
 * @Author: 张健
 * @CreateDate: 2019-03-14 10:02
 * @Version: 1.0
 * @Description: 树的广度优先搜索 与图相比 少了个visited数组存放已读取的元素
 */
public class TreeBFS {

    /**
     * 广度优先排序
     *
     * @param root 根节点
     * @return 广度优先排序后的数组
     */
    private static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
//        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
//                visited.add(node);
                list.add(node.val);
                if (node.left != null /*&& !visited.contains(node.left)*/) q.offer(node.left);
                if (node.right != null /*&& !visited.contains(node.right)*/) q.offer(node.right);
            }
        }
        return list;
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
        tn2.right=tn6;
        System.out.println(bfs(tn0));
    }



}
