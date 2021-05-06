package Leetcode.tree;

import java.util.ArrayList;

public class ZhiLevelPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null)
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<TreeNode> nodelist = new ArrayList<>();
        nodelist.add(pRoot);
        ArrayList<TreeNode> nnodelist = new ArrayList<>();

        ArrayList<Integer> list = null;
        while ((!nodelist.isEmpty())||(!nnodelist.isEmpty())){
            list = new ArrayList<>();
            while(!nodelist.isEmpty()){
                TreeNode temp = nodelist.remove(0);
                list.add(temp.val);
                if(temp.left!=null)
                    nnodelist.add(0,temp.left);
                if(temp.right!=null)
                    nnodelist.add(0,temp.right);
            }
            if(!list.isEmpty())
                result.add(list);

            list = new ArrayList<>();
            while(!nnodelist.isEmpty()){
                TreeNode temp = nnodelist.remove(0);
                list.add(temp.val);
                if(temp.right!=null)
                    nodelist.add(0,temp.right);
                if(temp.left!=null)
                    nodelist.add(0,temp.left);
            }
            if(!list.isEmpty())
                result.add(list);
        }
        return result;
    }


    public static void main(String[] args) {
        ZhiLevelPrint levelPrint = new ZhiLevelPrint();

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.left= node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node6.right=node7;

        System.out.println(levelPrint.Print(node1));
    }
}
