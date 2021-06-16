package Leetcode.huawei;

import java.util.Scanner;

public class CrossCave {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        int x = in.nextInt();
        char[][] m = new char[y][x];
        int si=0,sj=0;//S的坐标
        int ti=0,tj=0;//T的坐标
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                m[i][j] = in.next().charAt(0);//读入一个字符char '0' / '1' / 'S' / 'T'
                if(m[i][j]=='S'){
                    si=i;
                    sj=j;
                }
                if(m[i][j]=='T'){
                    ti=i;
                    tj=j;
                }
            }
        }

        int curi=si,curj=sj;//当前位置
        int step = 0;
//        int lasti=0,lastj=0;//上次分叉的地方
//        int[] dx = new int[] {-1, 1, 0, 0};
//        int[] dy = new int[] {0, 0, -1, 1};

        int di=-1;//表示方向
        while (m[curi][curj]!='T'){
            if(di==-1){//刚进去
                if(curi>=0 && curi+1<y && (m[curi+1][curj]=='1'||m[curi+1][curj]=='T')){//右手边
                    step++;
                    curi++;
                    di=1;//向下
                }else if(curi>0 && curi<y && (m[curi-1][curj]=='1'||m[curi-1][curj]=='T')){
                    step++;
                    curi--;
                    di=2;//向上
                }else if(curj>=0 && curj+1<x && (m[curi][curj+1]=='1'||m[curi][curj+1]=='T')){
                    step++;
                    curj++;
                    di=3;//向右
                }else if(curj>0 && curj<x &&(m[curi][curj-1]=='1'||m[curi][curj-1]=='T')){
                    step++;
                    curj--;
                    di=4;//向左
                }
            }else {
                if(di==1){//向下
                    if(curj>=0 && curj+1<x &&(m[curi][curj+1]=='1'||m[curi][curj+1]=='T')){
                        step++;
                        curj++;
                        di=3;//向右
                    } else if(curi>=0 && curi+1<y && (m[curi+1][curj]=='1'||m[curi+1][curj]=='T')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }else if(curj>0 && curj<x && (m[curi][curj-1]=='1'||m[curi][curj-1]=='T')){
                        step++;
                        curj--;
                        di=4;//向左
                    }
                }else if(di==2){//向上
                    if(curj>0 && curj<x &&(m[curi][curj-1]=='1'||m[curi][curj-1]=='T')){
                        step++;
                        curj--;
                        di=4;//向左
                    }else if(curi>0 && curi<y && (m[curi-1][curj]=='1'||m[curi-1][curj]=='T')){
                        step++;
                        curi--;
                        di=2;//向上
                    }else if(curj>=0 && curj+1<x && (m[curi][curj+1]=='1'||m[curi][curj+1]=='T')){
                        step++;
                        curj++;
                        di=3;//向右
                    }
                }else if(di==3){
                    if(curi>0 && curi<y && (m[curi-1][curj]=='1'||m[curi-1][curj]=='T')){
                        step++;
                        curi--;
                        di=2;//向上
                    }else if(curj>=0 && curj+1<x && (m[curi][curj+1]=='1'||m[curi][curj+1]=='T')){
                        step++;
                        curj++;
                        di=3;//向右
                    }else if(curi>=0 && curi+1<y && (m[curi+1][curj]=='1'||m[curi+1][curj]=='T')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }
                }else if(di==4){
                    if(curi>=0 && curi+1<y && (m[curi+1][curj]=='1'||m[curi+1][curj]=='T')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }else if(curj>0 && curj<x && (m[curi][curj-1]=='1'||m[curi][curj-1]=='T')){
                        step++;
                        curj--;
                        di=4;//向左
                    }else if(curi>0 && curi<y && (m[curi-1][curj]=='1'||m[curi-1][curj]=='T')){
                        step++;
                        curi--;
                        di=2;//向上
                    }
                }

            }

        }
    }
}
