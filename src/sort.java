import java.util.*;

public class sort {
    public static void main(String[] args) {
        while(true) {
            List<String> rightnumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
            Random rand = new Random();
            List<Integer> list = new ArrayList<Integer>();

            int b[] = new int[200000];
            for (int i = 0; i < b.length; i++) {
                b[i] = rand.nextInt(2000000);
            }
            int c[] = new int[50000];
            for (int i = 0; i < c.length; i++) {
                c[i] = rand.nextInt(2000000);
            }
            int d[] = new int[10000];
            for (int i = 0; i < d.length; i++) {
                d[i] = rand.nextInt(2000000);
            }
            System.out.println("选择算法");
            System.out.println("1.归并排序");
            System.out.println("2.快速排序(递归)");
            System.out.println("3.桶排序");
            System.out.println("4.基数排序");
            System.out.println("5.插入排序");
            System.out.println("6.快速排序(非递归)");
            System.out.println("7.退出程序");
            String n1 = new Scanner(System.in).next();
            if ("7".equals(n1)) {
                return;
            }
            if (!rightnumbers.contains(n1)) {
                System.out.println("输入错误字符程序自行销毁，请输入正确的数字");
                return;
            }

            System.out.println("选择册测试数据:");
            System.out.println("1.大数据量");
            System.out.println("2.大量小数据量");
            String n2 = new Scanner(System.in).next();
            if ("1".equals(n2)) {
                long startTime = System.currentTimeMillis();
                sort(b, n1);
                long endTime = System.currentTimeMillis();
                double time1 = (double) (endTime - startTime) / 1000;
                startTime = System.currentTimeMillis();
                sort(c, n1);
                endTime = System.currentTimeMillis();
                double time2 = (double) (endTime - startTime) / 1000;
                startTime = System.currentTimeMillis();
                sort(d, n1);
                endTime = System.currentTimeMillis();
                double time3 = (double) (endTime - startTime);
                System.out.println("1e4量级的运算时间：" + time3 + "ms");
                System.out.println("5e4量级的运算时间：" + time2 + "s");
                System.out.println("1e6量级的运算时间：" + time1 + "s");

            } else if ("2".equals(n2)) {
                int a[] = new int[100];
                long startTime = System.currentTimeMillis();
                int roud = 100000;
                while (roud > 0) {
                    for (int i = 0; i < a.length; i++) {
                        a[i] = rand.nextInt(2000000);
                    }
                    sort(a, n1);
                    roud--;
                }
                long endTime = System.currentTimeMillis();
                System.out.println("100量级的数据排序10k次所用的时间为: " + (double) (endTime - startTime) / 1000 + "s");

            } else {
                System.out.println("输入错误字符程序自行销毁，请输入正确的数字");
                return;
            }
            System.out.println("-----------------");
            System.out.println("程序继续");
        }
    }

    private static void sort(int[] arr, String n) {
        switch(n){
            case "1":
                sortUtil.mergeSort(arr,0,arr.length-1);
                break;
            case "2":
                sortUtil.quickSort(arr,0,arr.length-1);
                break;
            case "3":
                sortUtil.bucketSort(arr);
                break;
            case "4":
                    sortUtil.radixSort(arr);
                break;
            case"5":
                //sortUtil.insertSort(arr);
            case "6":
                sortUtil.quickSortB(arr,0,arr.length-1);
                break;
            default:
                System.out.println("请入正确的排序方法");
                 return;
        }
    }

}
