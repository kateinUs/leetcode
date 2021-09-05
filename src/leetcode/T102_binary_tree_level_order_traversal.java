package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 本题重点在于新建一个全局的List<List<Integer>>
 *     并且每次递归都要传入root的level(表示节点深度，root为0，下面++1)
 * @author huimin
 * @create 2021-09-01 5:54
 */
public class T102_binary_tree_level_order_traversal {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return res;
        checkLevel(root, 0);

        return res;
    }
    public void checkLevel(TreeNode root, int level){
        // check the size of result list
        if(res.size() == level)
            res.add(new ArrayList<Integer>());
        // add the root val into the corresponding level list
        res.get(level).add(root.val);
        /* zigzag 判断level是奇数还是偶数，如果是偶数 则FIFO；奇数则FILO
                  体现在ArrayList上就是从最后插入，和从list头部插入
        if (level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);
        */

        // continue the left and right node
        if(root.left != null)
            checkLevel(root.left, level+1);
        if(root.right != null)
            checkLevel(root.right, level+1);
    }

}
