package Leetcode;


import java.util.*;

//找出数组中三数之和为零的所有组合
//leetcode 15
public class SumOfThree{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int l = nums.length;
        Set setOfFirstNum = new HashSet();
        for (int i = 0; i<l;i++){//固定一个数
            if(!setOfFirstNum.contains(nums[i])){
                Set set = new HashSet();
                int j = i+1;
                while(j<l){
                    if(!set.contains(nums[j]) && !setOfFirstNum.contains(nums[j])){
                        //如果set不包含nums[j]，则开始找第三个数
                        int k = j+1;
                        while (k<l){
                            //遍历k
                            if(nums[i]+nums[j]+nums[k]==0 && !setOfFirstNum.contains(nums[k])){
                                set.add(nums[k]);
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                lists.add(list);
                                break;
                            }
                            k++;
                        }
                        set.add(nums[j]); //遍历完第三个数后（不论是否找到），将j加入set
                    }
                    j++;
                }
            }
            setOfFirstNum.add(nums[i]);
        }
        return lists;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums); //排序
        System.out.println(Arrays.toString(nums));

        int len = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            map.put(nums[i],i); //数值-索引
        }

        for(int i = 0;i<len;){
            Set<Integer> set = new HashSet<>();
            int j = i+1;
            while (j<len){
                if(!set.contains(nums[j])){
                    int com = -nums[i]-nums[j];
                    if(map.containsKey(com) && map.get(com)>j){
                        //如果存在
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(com);
                        lists.add(list);
                        set.add(com);
                        set.add(nums[j]);
                    }
                }
                j++;
            }
            i += (map.get(nums[i])-i+1);
        }
        return lists;
    }
    public static void main(String[] args) {
        SumOfThree sumOfThree = new SumOfThree();
        //System.out.println(sumOfThree.threeSum(new int[]{3,0,-2,-1,1,2})); //[[-2,-1,3],[-2,0,2],[-1,0,1]]
        //System.out.println(sumOfThree.threeSum(new int[]{-1,0,1,2,-1,-4})); //[[-1, 0, 1], [-1, 2, -1]]
        System.out.println(sumOfThree.threeSum1(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6})); //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]

    }
}
