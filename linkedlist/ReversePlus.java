package Leetcode.linkedlist;

public class ReversePlus {
    public static ListNode solution(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int nxt=0;
        while(l1!=null || l2!=null){
            int v1= 0;
            if(l1!=null){
                v1 = l1.val;
                l1=l1.next;
            }
            int v2 = 0;
            if(l2!=null){
                v2=l2.val;
                l2=l2.next;
            }
            cur.next = new ListNode((v1+v2+nxt)%10);
            cur=cur.next;
            nxt = (v1+v2+nxt)>=10?1:0;
        }
        if(nxt==1){
            cur.next = new ListNode(nxt);
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(2);
        node1.next=node2;
        node3.next=node4;
        ListNode node = solution(node1,node3);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
        System.out.println(29 + 84);
    }
}
