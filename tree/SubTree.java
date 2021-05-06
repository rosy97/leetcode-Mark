package Leetcode.tree;

public class SubTree {

    public boolean sameRootSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        return root1.val==root2.val &&
                sameRootSubtree(root1.left,root2.left) &&
                sameRootSubtree(root1.right,root2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //遍历root1的每一个节点，调用sameRootSubtree（..., root2）
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        else{
            return sameRootSubtree(root1,root2)||
                    sameRootSubtree(root1.left,root2)||
                    sameRootSubtree(root1.right,root2);
        }


    }
}
