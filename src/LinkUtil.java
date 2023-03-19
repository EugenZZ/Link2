public class LinkUtil {
   public static boolean isRound(Node head) {
       if (head == null || head.next == null) {
           return false;
       }
       Node slow=head;
       Node fast=head.next;
       while (fast!=slow) {
           //当走到null代表为非循环链表结束
           if (fast.next == null || fast.next.next == null) {
               return false;
           }
           slow = slow.next;
           fast = fast.next.next;
       }
       //两个节点相同时跳出
       return true;
   }
   public static Node reserve(Node node){
       if(node==null||node.next==null){
           return node;
       }
       Node temp=node.next;
       //递归从尾走到头
       Node Nnode=reserve(node.next);
       temp.next = node;
       node.next=null;
       return Nnode;
   }


}
