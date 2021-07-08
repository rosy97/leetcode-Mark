package Leetcode.tree;

public class LatterOfBST {
    public boolean latterOfBST(int [] sequence,int start,int rootIndex) {
        //start为数组第一项的索引，rootIndex为数组最后一项的索引
        if(start>=rootIndex)//终止条件！！！
            return true;
        int i;
        int root = sequence[rootIndex];
        for(i=start;i<rootIndex;i++){
            if(sequence[i]>root){//找到左右子树分界点
                break;
            }
        }

        for(int j = i; j<rootIndex; j++){
            if(sequence[j]<root)//判断右子树中是否有小于根的节点
                return false;
        }

        //递归判断左右子树
        return latterOfBST(sequence,start,i-1)&&latterOfBST(sequence,i,rootIndex-1);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        return latterOfBST(sequence,0,sequence.length-1);
    }

    public static void main(String[] args) {
        LatterOfBST bst = new LatterOfBST();
        System.out.println(bst.VerifySquenceOfBST(new int[]{1,3,2}));
    }
}
