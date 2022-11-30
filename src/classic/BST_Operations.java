package classic;

/**
 * @author huimin
 * @create 2022-11-26 17:43
 */
public class BST_Operations {

    /**
     * 基本操作之插入(Insert)
     * 思路
     * 根节点为空，则待添加的节点为根节点
     * 如果待添加的节点值小于根节点，则在左子树中添加
     * 如果待添加的节点值大于根节点，则在右子树中添加
     * 我们统一在树的叶子节点(Leaf Node)后添加
     *
     * @param root
     * @param node
     * @return
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

    /**
     * 基本操作之修改(Update)
     * 思路
     * 修改仅仅需要在查找到需要修改的节点之后，更新这个节点的值就可以了，(假如修改过后整棵树还满足BST的性质)
     *
     * @param root
     * @param target
     * @param val
     */
    public void updateBST(TreeNode root, int target, int val) {
        if (root == null) {
            return;
        }// 未找到target节点
        if (target < root.val) {
            updateBST(root.left, target, val);//target小于根节点值，在左子树中查找
        } else if (target > root.val) {
            updateBST(root.right, target, val);//target大于根节点值，在右子树中查找
        } else { //找到了
            root.val = val;
        }
    }

    /**
     * 基本操作之查找(Retrieve)
     * 思路
     * 查找值为val的节点，如果val小于根节点则在左子树中查找，反之在右子树中查找
     *
     * @param parent
     * @param node
     * @param value
     * @return
     */
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }

    /**
     * 基本操作之删除(Delete)
     * 思路(最为复杂)
     * 考虑待删除的节点为叶子节点，可以直接删除并修改父亲节点(Parent Node)的指针，需要区分待删节点是否为根节点
     * 考虑待删除的节点为单支节点(只有一棵子树——左子树 or 右子树)，与删除链表节点操作类似，同样的需要区分待删节点是否为根节点
     * 考虑待删节点有两棵子树，可以将待删节点与左子树中的最大节点进行交换，由于左子树中的最大节点一定为叶子节点，所以这时再删除待删的节点可以参考第一条
     * 详细的解释可以看 http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     *
     * @param root
     * @param value
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        deleteNode(parent, node);
        return dummy.left;
    }

    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            temp.left = node.left;
            temp.right = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);


    }

    /*
    another way to remove node
    One step right and then always left
    */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode removeNode2(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = removeNode2(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = removeNode2(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = removeNode2(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = removeNode2(root.left, root.val);
            }
        }
        return root;
    }
}
