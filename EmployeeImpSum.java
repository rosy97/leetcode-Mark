package Leetcode;

import java.util.*;

public class EmployeeImpSum {
    public static int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> toSum = new LinkedList<>();
        toSum.add(id);
        int res=0;
        for(int i=0;i<employees.size();i++){
            Employee cur = employees.get(i);
            map.put(cur.id,cur);
        }
        while (!toSum.isEmpty()){
            Integer cur = toSum.poll();
            res+=map.get(cur).importance;
            for(int i:map.get(cur).subordinates){
                toSum.offer(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
