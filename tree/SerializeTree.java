package Leetcode.tree;

import java.util.ArrayList;

//树的序列化：以一个字符串，基于先序、中序、后序、层序的二叉树遍历方式保存树的节点
//反序列化：字符串-->treenode
public class SerializeTree {

    StringBuffer buffer = new StringBuffer();
    //层序
    String levelSerialize(TreeNode root) {
        buffer.append(root.val);//加入根
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){//遍历删除当前层，并添加当前层的下一代
            TreeNode temp = queue.remove(0);
            //左子
            if(temp.left==null){
                buffer.append('#');
            }else {
                buffer.append(temp.left.val);
                queue.add(temp.left);
            }
            //右子
            if(temp.right==null){
                buffer.append('#');
            }else {
                buffer.append(temp.right.val);
                queue.add(temp.right);
            }
        }

        return buffer.toString();
    }
    TreeNode levelDeserialize(String str) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        String[] split = str.split("");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            TreeNode head = queue.remove(0);
            if(!split[index++].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(split[index]));
                head.left = left;
                queue.add(left);
            }else
                head.left=null;

            if(!split[index++].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(split[index]));
                head.right = right;
                queue.add(right);
            }else
                head.right=null;
        }
        return root;
    }


    //先序
    // #表示空节点
    String preSerialize(TreeNode root) {// 1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,
        String res = "";
        if(root==null)
            return "#,";
//
//        if(root.left==null&&root.right==null){
//            res = String.valueOf(root.val)+",";
//        }else
        res = String.valueOf(root.val)+",";

        String left = preSerialize(root.left);
        String right = preSerialize(root.right);
        res = res+left+right;

        return res;
    }
    public String Serialize(TreeNode root) {//1,2,4,#,#,5,#,#,3,6,#,#,7,#,#
        if (root == null) {
            return "#";
        } else {
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }

    int index = -1;
    //按照先序遍历的顺序，构造节点，并返回即可
    TreeNode preDeserialize(String str) {// 1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,
        String[] s = str.split(",");//将序列化之后的序列用，分隔符转化为数组
        index++;//索引每次加一
        int len = s.length-1;
        if (index > len) {
            return null;
        }
        TreeNode treeNode = null;
        if (!s[index].equals("#")) {//非# 不为空，构造节点
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = preDeserialize(str);
            treeNode.right = preDeserialize(str);
        }
        return treeNode;
    }


    public static void main(String[] args) {
        SerializeTree tree = new SerializeTree();

        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=null;
        node1.left= node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;

//        String s = tree.preSerialize(node1);
//        System.out.println(s);
//        System.out.println(tree.preDeserialize(s));
//        System.out.println(tree.Serialize(node1));
        System.out.println(tree.levelSerialize(node1));
        System.out.println(tree.levelDeserialize(tree.levelSerialize(node1)).val);

    }
}
