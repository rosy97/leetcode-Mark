package Leetcode.tree;

import java.util.Stack;

//非递归遍历
public class FeiDigui {
    //中序:左根右
    public static void mid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.add(p);
        while(!stack.isEmpty()){
            //保证p节点不会重复
            if(p!=null && p.left!=null){
                //左子非空
                stack.add(p.left);
                p=p.left;
            }else {
                //左子为空
                p=stack.pop();//弹出
                System.out.print(p.val+"\t");
                if(p.right!=null){
                    stack.add(p.right);
                    p=p.right;
                }else {
                    p=null;
                }
            }
        }
    }

    //先序，根左右
    public static void pre(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.add(p);
        while(!stack.isEmpty()){
            //保证p节点不会重复
            p=stack.pop();
            System.out.print(p.val+"\t");

            if(p.right!=null){
                //左子非空
                stack.add(p.right);
            }
            if(p.left!=null){
                stack.add(p.left);
            }
        }
    }

    //后序，左右根
    public static void last1(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(root != null || !stack1.empty()) {
            while (root != null) {
                stack1.push(root);
                stack2.push(0);
                root = root.left;
            }

            while(!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.print(stack1.pop().val + " ");
            }

            if(!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                root = stack1.peek();
                root = root.right;
            }
        }
    }

    //后序，左右根
    public static void postOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> src = new Stack<>();
        Stack<TreeNode> re = new Stack<>();
        //将节点push进src
        src.push(root);
        while (!src.isEmpty()) {
            TreeNode p = src.pop();
            re.push(p);
            if (p.left != null) {
                src.push(p.left);
            }
            if (p.right!= null) {
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while (!re.isEmpty()) {
            System.out.print(re.pop().val + " ");
        }
    }



    public static void main(String[] args) {
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
        node3.right=node7;
        last1(node1);
        postOrderTraversalWithStack(node1);
    }
}
