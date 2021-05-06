package Leetcode;

import java.util.HashMap;

public class FirstAppearingOnce {

    StringBuffer str = new StringBuffer();
    HashMap map = new HashMap();
    char fc;
    int placeOfCh=0;
    //Insert one char from stringstream
    public void myInsert(char ch)
    {
        if(map.isEmpty() || map.get(ch)==null){//为存放
            map.put(ch,1);//map保存：字符-出现次数
            str.append(ch);//str中保存不重复字符（仅在保存的时候不重复，后续动态输入字符后可能会重复）
        }else{//已经存放，ch存在次数加1
            map.put(ch,(int)map.get(ch)+1);
        }
    }
    //return the first appearence once char in current stringstream
    public char solution()
    {
        for (int i=0;i<str.length();i++){
            if((int)map.get(str.charAt(i))==1){
                return str.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce firstAppearingOnce = new FirstAppearingOnce();
        String inp="BabyBaby";
        char[] chars = inp.toCharArray();
        for(char ch:chars){
            firstAppearingOnce.myInsert(ch);
            System.out.println(firstAppearingOnce.solution());
        }
    }
}
