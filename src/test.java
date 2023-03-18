import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        LinkNode node = new LinkNode();
        //用于清空缓存区数字
        String Free=null;
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入您要存入的数据的数量");
        int num=0;
        boolean flag=true;
        while(flag) {
            try {
                flag=false;
                num = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("请输入正确的数字");
                flag=true;
            }
        }
        System.out.println("请输入您要存入的数据");

        for(int i=0; i<num; i++) {
           String x=sc.next();
            node.headInsert(x);
        }
        node.display();
        System.out.println();
        flag=true;
        while(flag) {
            System.out.println("请选择操作");
            System.out.println("1.反转链表");
            System.out.println("2.奇偶对调");
            System.out.println("3.找到中点");
            System.out.println("4.判断成环");
            System.out.println("5.结束程序");

                num = 0;
                while (true) {
                    try {
                        num = Integer.parseInt(sc.next());
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数字");
                        continue;
                    }
                    if (num >= 1 && num <= 5) {
                        break;
                    }
                    else {
                        System.out.println("请输入正确的数字");
                    }
                }

            switch (num) {
                case 1:
                    node.reverse1();
                    break;
                case 2:
                    node.change();
                    break;
                case 3:
                    System.out.println(node.findMidPoint().data);
                    break;
                case 4:
                    System.out.println(LinkUtil.isRound(node.getHeadNode()));
                    break;
                case 5:
                        flag=false;
                        break;
                default:
                    System.out.println("请输入正确的数字");
            }
            System.out.println();

        }


//        LinkNode node = new LinkNode();
//        node.headInsert(445);
//        node.headInsert(5465);
//        node.headInsert(131);
//        node.headInsert(221);
//        node.headInsert(541);
//        node.headInsert(845);
//        node.headInsert(456);
//        System.out.println();
//        //奇偶对换
//        node.change();
//        node.display();
//        System.out.println();
//        //反转链表非递归
//        node.reverse1();
//        node.display();
//        System.out.println();
//        //反转链表递归
//        LinkUtil.reserve(node.getHeadNode());
//        node.turn();
//        node.display();
//        System.out.println();
//        //判断成环
//        System.out.println(LinkUtil.isRound(node.getHeadNode()));
//        //找中点
//        System.out.println(node.findMidPoint().data);


    }
}
