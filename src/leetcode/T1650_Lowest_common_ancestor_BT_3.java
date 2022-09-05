package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huimin
 * @create 2022-07-14 11:14
 */
class Node_LCA {
    public int val;
    public Node_LCA left;
    public Node_LCA right;
    public Node_LCA parent;
}
public class T1650_Lowest_common_ancestor_BT_3 {
    // Method1: Use set
    // 目标： 找p和q的共同祖先
    // 用set，把所有p的祖先存下来，然后q网上找，看是否与p的祖先set重合，返回重合的node
    public Node_LCA lowestCommonAncestor(Node_LCA p, Node_LCA q) {

        Set<Node_LCA> parent = new HashSet<>();
        while(p!= null){
            parent.add(p);
            p = p.parent;
        }

        while(!parent.contains(q) && q.parent != null){
            q = q.parent;
        }

        return q;

    }
}
