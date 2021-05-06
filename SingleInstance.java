package Leetcode;

public class SingleInstance {
    private static SingleInstance instance = null;
    private SingleInstance(){}

    public static SingleInstance getInstance(){
        if(instance==null){
            synchronized (SingleInstance.class){
                if(instance==null)
                    instance = new SingleInstance();
            }
        }
        return SingleInstance.instance;

    }

    public static String maxNumber(int[] arr){
        if(arr==null || arr.length==0)
            return "";
//        Arrays.sort(arr,new Comparable<Integer>{
//            @Override
//            int comparable
//        }());
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
//                if(Integer.parseInt(""+arr[i]+arr[j])<Integer.parseInt(""+arr[j]+arr[i])){
                if(new Integer(""+arr[i]+arr[j])<new Integer(""+arr[j]+arr[i])){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String res = "";
        for(int i:arr){
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxNumber(new int[]{1, 2, 3, 14}));
    }

}
