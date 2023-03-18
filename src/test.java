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
            System.out.println("6.插入数据");
            System.out.println("7.删除数据");


                num = 0;
                while (true) {
                    try {
                        num = Integer.parseInt(sc.next());
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数字");
                        continue;
                    }
                    if (num >= 1 && num <= 7) {
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
                case 6:
                    System.out.println("请输入您要存入的数据");
                    String data=sc.next();
                    node.headInsert(data);
                    node.display();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("请输入您要删除的数据");
                    String data2=sc.next();
                    node.delete(data2);
                    node.display();
                    System.out.println();
                    break;
                default:
                    System.out.println("请输入正确的数字");
            }
                if(node.getSize()==0){
                    System.out.println("链表清空程序结束");
                    return;
                }
            System.out.println();

        }


    }
}
