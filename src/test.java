public class test {
    public static void main(String[] args) {
        LinkNode node = new LinkNode();
        node.headInsert(445);
        node.headInsert(5465);
        node.headInsert(131);
        node.headInsert(221);
        node.headInsert(541);
        node.headInsert(845);
        node.headInsert(456);
        node.display();
        System.out.println();
        //奇偶对换
        node.change();
        node.display();
        System.out.println();
        //反转链表非递归
        node.reverse1();
        node.display();
        System.out.println();
        //反转链表递归
        LinkUtil.reserve(node.getHeadNode());
        node.turn();
        node.display();
        System.out.println();
        //判断成环
        System.out.println(LinkUtil.isRound(node.getHeadNode()));
        //找中点
        System.out.println(node.findMidPoint().data);


    }
}
