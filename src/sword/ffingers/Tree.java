package sword.ffingers;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。先序便利确定定点为1->2
 * 中序遍历确定4-7-2-为左子树5,3,8,6
 *                  1
 *            2         3
 *          4        5     6
 *             7        8
 */

public class Tree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre, in));
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0){
            return null;
        }
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if(pre[0] == in[i]){
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),Arrays.copyOfRange(in, 0, i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),Arrays.copyOfRange(in, i+1, in.length ));
                break;
            }
        }
        return treeNode;
    }

    /**
     *                    1
     *              2          3
     *           4         5       6
     *              7          8
     *
     *
     *
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
