package Leetcode.wangyi;

public class MiGong {
    public static int steps(char[][] mig){
        int step=1;
        int w=mig[0].length,h=mig.length;
        int si=0,sj=0;
        int ei=0,ej=0;
        for(int k=0;k<h;k++){
            for(int j=0;j<w;j++){
                if(mig[j][k]=='S'){
                    si=j;
                    sj=k;
                }
                if(mig[j][k]=='E'){
                    ei=j;
                    ej=k;
                }
            }
        }
//        System.out.println(si + " " + sj);
        int curi=si,curj=sj;
        int di=-1;
        System.out.println(mig[curi][curj]);
        while (mig[curi][curj]!='E'){
            if(di==-1){//刚进去
                if(curi>=0&&curi+1<w&&(mig[curi+1][curj]=='.'||mig[curi+1][curj]=='E')){//右手边
                    step++;
                    curi++;
                    di=1;//向下
                }else if(curi>0&&curi<w&&(mig[curi-1][curj]=='.'||mig[curi-1][curj]=='E')){
                    step++;
                    curi--;
                    di=2;//向上
                }else if(curj>=0&&curj+1<h&&(mig[curi][curj+1]=='.'||mig[curi][curj+1]=='E')){
                    step++;
                    curj++;
                    di=3;//向右
                }else if(curj>0&&curj<h&&(mig[curi][curj-1]=='.'||mig[curi][curj-1]=='E')){
                    step++;
                    curj--;
                    di=4;//向左
                }
                System.out.println(mig[curi][curj]);
            }else {
                if(di==1){//向下
                    if(curj>=0&&curj+1<h&&(mig[curi][curj+1]=='.'||mig[curi][curj+1]=='E')){
                        step++;
                        curj++;
                        di=3;//向右
                    } else if(curi>=0&&curi+1<w&&(mig[curi+1][curj]=='.'||mig[curi+1][curj]=='E')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }else if(curj>0&&curj<h&&(mig[curi][curj-1]=='.'||mig[curi][curj-1]=='E')){
                        step++;
                        curj--;
                        di=4;//向左
                    }
                }else if(di==2){//向上
                    if(curj>0&&curj<h&&(mig[curi][curj-1]=='.'||mig[curi][curj-1]=='E')){
                        step++;
                        curj--;
                        di=4;//向左
                    }else if(curi>0&&curi<w&&(mig[curi-1][curj]=='.'||mig[curi-1][curj]=='E')){
                        step++;
                        curi--;
                        di=2;//向上
                    }else if(curj>=0&&curj+1<h&&(mig[curi][curj+1]=='.'||mig[curi][curj+1]=='E')){
                        step++;
                        curj++;
                        di=3;//向右
                    }
                }else if(di==3){
                    if(curi>0&&curi<w&&(mig[curi-1][curj]=='.'||mig[curi-1][curj]=='E')){
                        step++;
                        curi--;
                        di=2;//向上
                    }else if(curj>=0&&curj+1<h&&(mig[curi][curj+1]=='.'||mig[curi][curj+1]=='E')){
                        step++;
                        curj++;
                        di=3;//向右
                    }else if(curi>=0&&curi+1<w&&(mig[curi+1][curj]=='.'||mig[curi+1][curj]=='E')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }
                }else if(di==4){
                    if(curi>=0&&curi+1<w&&(mig[curi+1][curj]=='.'||mig[curi+1][curj]=='E')){//右手边
                        step++;
                        curi++;
                        di=1;//向下
                    }else if(curj>0&&curj<h&&(mig[curi][curj-1]=='.'||mig[curi][curj-1]=='E')){
                        step++;
                        curj--;
                        di=4;//向左
                    }else if(curi>0&&curi<w&&(mig[curi-1][curj]=='.'||mig[curi-1][curj]=='E')){
                        step++;
                        curi--;
                        di=2;//向上
                    }
                }
                System.out.println(mig[curi][curj]);

            }

        }
        return step;
    }


    public static void main(String[] args) {
        char[][] mig = new char[][]{
                {'#', '#', '#', '#', '#'},
                {'#', '.', '.', '.', '#'},
                {'#', '.', '.', '.', '#'},
                {'#', '.', '#', '.', '#'},
                {'#', 'E', '#', 'S', '#'}};

        System.out.println(steps(mig));
    }
}
