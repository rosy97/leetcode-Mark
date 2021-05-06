package Leetcode.arr;

import java.util.HashMap;

public class MinValueOfA {
    public static int sum(int[] a, int[] b, HashMap<Integer,Integer> map){
        int res=0;
        for(int i=0;i<a.length;i++){
            if(map.get(a[i])>1){
                map.put(a[i],map.get(a[i])-1);
                int min=Integer.MAX_VALUE;
                int j=i;
                int mii=0;
                for(;j<a.length;j++){
                    if(a[j]==a[i]){
                        if(min>b[j]){
                            min=b[j];
                            mii=j;
                        }
                    }
                }
                a[mii]++;
                if(map.containsKey(a[mii])){
                    map.put(a[mii],map.get(a[mii])+1);
                }else {
                    map.put(a[mii],1);
                }
                return min+sum(a,b,map);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] a =new int[]{1,2,2,2,2};
        int[] b =new int[]{1,2,3,4,5};
        for(int i =0;i<a.length;i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else {
                map.put(a[i],1);
            }
        }
        System.out.println(sum(a, b, map));
    }
}
