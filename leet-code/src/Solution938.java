/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2019/7/5 16:25
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 */
public class Solution938 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int s = 0;

        s = sumBST(root, L, R, s);

        return s;
    }

    private int sumBST(TreeNode root, int L, int R, int s) {
        if(root == null){
            return s;
        }
        int v = root.val;

        if(v < L){
            s = sumBST(root.right, L, R, s);
        } else if(v > R){
            s = sumBST(root.left, L, R, s);
        } else {
            s += v;
            s = sumBST(root.left, L, R, s);
            s = sumBST(root.right, L, R, s);

        }

        return s;
    }
}
