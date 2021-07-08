package Leetcode.tree;

import java.util.Arrays;

//根据中序+先序(中序+后序)重构二叉树
public class RebuildTree {

    public static TreeNode rebulidTreeByPre(int[] mid, int[] pre){//mid左根右，pre根左右
        if(pre.length!=0 && mid.length!=0){
            TreeNode root = new TreeNode(pre[0]);
            int rootIdx=0;
            for(int i=0;i<mid.length;i++){
                if(mid[i]==root.val){
                    rootIdx=i;
                    break;
                }
            }
            root.left=rebulidTreeByPre(Arrays.copyOfRange(mid,0,rootIdx),Arrays.copyOfRange(pre,1,rootIdx+1));//copyOfRange左闭右开
            root.right=rebulidTreeByPre(Arrays.copyOfRange(mid,rootIdx+1,mid.length),Arrays.copyOfRange(pre,rootIdx+1,pre.length));
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] mid = new int[]{4, 2, 5, 1, 6, 3, 7};
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};

        TreeNode node = rebulidTreeByPre(mid, pre);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
        System.out.println(node.left.left.val);
        System.out.println(node.left.right.val);
        System.out.println(node.right.left.val);
        System.out.println(node.right.right.val);
    }
}
