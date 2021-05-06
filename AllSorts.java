package Leetcode;

import java.util.*;

public class AllSorts {

    //求全排列，无去重
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();

        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    //回溯操作
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    //求全排列，添加去重
    public List<String> permuteUnique(String nums) {
        if(nums.length()<=1){//终止条件
            List<String> res = new ArrayList<>();
            res.add(nums);
            return res;
        }

        List<String> res = new ArrayList<>();

        for(int i=0;i<nums.length();i++){
            //建立sub子串
            String sub = nums.substring(0, i)+nums.substring(i+1);

            for(String s : permuteUnique(sub)){
                res.add(nums.charAt(i)+s);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AllSorts a = new AllSorts();



        HashMap<Student,Integer> map = new HashMap<>();

        Student s = new Student("lmx");
        map.put(s,1);
        s.setName("yy");
        System.out.println(map.get(s));


    }

}
class Student {
    String name;
     Student (String name){
         this.name=name;
     }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

