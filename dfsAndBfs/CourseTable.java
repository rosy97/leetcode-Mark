package Leetcode.dfsAndBfs;

import java.util.ArrayList;
import java.util.List;

//leetcode 207
//深度优先搜索:图的拓扑结构
public class CourseTable {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean res = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {//numCourses表示课程数，prerequisites表示连接关系，其中连接关系可为空
        if(prerequisites.length==0){
            return true;
        }
        for(int i=0;i<numCourses;i++){//为每个点生成后继课程队列
            List<Integer> line = new ArrayList<>();
            graph.add(line);
        }
        for(int i=0;i<prerequisites.length;i++){//遍历每条有向边，转成每个点后继课程的集合
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){//如果点的状态是未遍历
                dfs(visited,i);
            }
        }
        return res;
    }

    public static void dfs(int[] visited, int u){
        visited[u]=1;//修改状态为遍历中
        List<Integer> cours = graph.get(u);
        for(int i:cours){//深度优先遍历u的每个后继结点
            if(visited[i]==0){
                //visited==0 则遍历
                dfs(visited,i);
            }else if(visited[i]==1){
                //visited==1 说明存在闭环关系，不存在拓扑结构
                res=false;
                continue;
            }else {
                //visited==2
            }
        }
        visited[u]=2;
    }



    //leetcode answer1
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for(int i = 0; i < numCourses; i++)
            if(!dfs1(adjacency, flags, i)) return false;
        return true;
    }
    private boolean dfs1(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;//遍历中
        if(flags[i] == -1) return true;//已遍历
        flags[i] = 1;
        for(Integer j : adjacency.get(i))
            if(!dfs1(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(canFinish(5, new int[][]{
//                {1, 4}, {2,4},{3,1},{3,2}
//        }));
        System.out.println(canFinish(2, new int[][]{
                {0, 1}
        }));
    }
}
