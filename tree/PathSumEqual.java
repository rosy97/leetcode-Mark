package Leetcode.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class PathSumEqual {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        //求所有 和为target的路径 集合
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
    public int[] main(TreeNode root){
        Scanner sc = new Scanner(System.in);
        //第一行tree输入数的节点值?

        int target = sc.nextInt();//第二行输入目标值

        if(findPath(root, target)==null){
            //为空则返回空数组
            return new int[]{};
        }else {
            //非空
            ArrayList<Integer> res = findPath(root, target).get(0);
            int[] solution = new int[res.size()];
            for(int i=0;i<solution.length; i++){
                solution[i] = res.get(i);
            }
            return solution;
        }
    }
}
