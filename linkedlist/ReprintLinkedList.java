package Leetcode.linkedlist;

//空间O(1) 逆序打印链表
public class ReprintLinkedList {
    public static void reprint(ListNode node){
        if(node.next==null){
            System.out.println(node.val);
        }else {
            reprint(node.next);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        reprint(p1);

    }
}
