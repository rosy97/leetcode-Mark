package Leetcode;

public class LinklistDeleteSame {
    public ListNode deleteSame(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while(next!=null){
            if(cur.val!=next.val){
                pre = cur;
                cur = next;
                next = next.next;
            }else {//删除操作
                if(cur==head){
                    while (next!=null && head.val == next.val){
                        cur =next;
                        next =next.next;
                    }
                    head = next;
                    cur = next;
                    if(next==null)
                        return null;
                    next = next.next;
                }else {
                    cur = pre;
                    cur.next = next.next;
                    next =cur.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinklistDeleteSame same = new LinklistDeleteSame();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(2);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        ListNode head = same.deleteSame(p1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int x){
        val = x;
    }
}