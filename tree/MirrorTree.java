package Leetcode.tree;

import java.util.ArrayList;

public class MirrorTree {

    ArrayList<Integer> mid(TreeNode pRoot, int i, ArrayList<Integer> list) {
        if (pRoot != null) {
            list.add(pRoot.val);
            if (i == 1) {//根左右
                mid(pRoot.left, i,list);
                mid(pRoot.right, i,list);
            }
            else{//根右左
                mid(pRoot.right,i,list);
                mid(pRoot.left,i,list);
            }
        }else
            list.add(-5);
        return list;
    }

    boolean isSame(TreeNode root1, TreeNode root2){

        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;

        return (root1.val==root2.val)&&isSame(root1.left,root2.right)&&isSame(root2.left,root1.right);
    }
    boolean isMirror(TreeNode pRoot){
        return isSame(pRoot,pRoot);
    }
    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
//        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//        System.out.println(mirrorTree.mid(node1, 1,new ArrayList<Integer>()));
//        System.out.println(mirrorTree.mid(node1, 2,new ArrayList<Integer>()));
//        System.out.println(mirrorTree.isMirror(node1));


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        result.add(list);
        result.add(new ArrayList<Integer>(list));
        System.out.println(result);
        System.out.println(list);
    }
}
