import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Stack;

public class sortUtil {
    public static List<Integer>  insertSort(List<Integer> list){
        for(int i = 0; i < list.size()-1; i++){
            int num=i;
            int tem=list.get(num+1);
            while(num>=0){
                if(tem<list.get(num)){
                    list.set(num+1,list.get(num));
                    num--;
                }
                else{
                    break;
                }
            }
            list.set(num+1,tem);
        }
        return list;

    }
    //快排递归
    public static void quickSort(int[] a,int beagin,int end){
        if(beagin>=end){
            return;
        }
        int left=beagin;
        int right=end;
        int key=a[beagin];
        while(beagin<end){
            while (a[end] >= key && beagin < end)
            {
                --end;
            }
            a[beagin] = a[end];
            while (a[beagin] <= key && beagin < end)
            {
                ++beagin;
            }
            a[end] = a[beagin];
        }
        a[beagin] =key;
        int keyi=beagin;
        quickSort(a,left,keyi-1);
        quickSort(a,keyi+1,right);
    }
    //非递归
    public static int onceSort(int []a,int begin,int end){
        int key=a[begin];
        while(begin<end){
            while(key<=a[end]&&begin<end){
                --end;
            }
            a[begin]=a[end];
            while(key>=a[begin]&&begin<end){
                ++begin;
            }
            a[end]=a[begin];
        }
        a[begin]=key;
        return begin;
    }
    public static void quickSortB(int[] a,int beagin,int end){
        Stack<Integer> position=new Stack<Integer>();
        position.push(end);
        position.push(beagin);
        while(!position.empty()){
            int left=position.pop();
            int right=position.pop();
             int mid=onceSort(a,left,right);
            if(left<mid-1){
                position.push(mid-1);
                position.push(left);
            }
            if (right>mid+1){
                position.push(right);
                position.push(mid+1);
            }
        }

    }
    public static void mergeSort(int[] a, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(a, low, mid);

        mergeSort(a, mid+1, high);

        merge(a,low,mid,high);
    }
    private static void merge(int[] a, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid+1;
        int[] temp = new int[high-low+1];
        int i = 0;
        while(s1<=mid && s2<=high) {
            if(a[s1] <= a[s2]) {
                temp[i++] = a[s1++];
            }else {
                temp[i++] = a[s2++];
            }
        }
        while (s1 <= mid) {
            temp[i++] = a[s1++];

        }
        while (s2 <= high) {
            temp[i++] = a[s2++];

        }
        for (int j = 0; j < temp.length; j++) {
            a[j+low] = temp[j];
        }
    }
    public static void  radixSort(int[] arr) {
        int max = arr[0];
        for(int element: arr) {
            if(max < element) {
                max = element;
            }
        }
        int times = (String.valueOf(max)).length();
        int radixArray[][] = new int[10][arr.length];
        int radixTimes[] = new int[10];
        int m = 1;
        //排序times轮
        for(int i = 0; i < times; i++) {
            //并且记录到radixTimes中
            for(int j = 0; j < arr.length; j++) {
                int remainder = (arr[j]/m)%10;
                //得到数组元素的基数值
                //把当前元素放入到基数二维数组中
                radixArray[remainder][radixTimes[remainder]] = arr[j];
                radixTimes[remainder] = radixTimes[remainder] + 1;
            }

            int index = 0;
            //整理所得到的数组 把基数数组的里面的数组 整理取出到原数组中
            for(int n = 0; n < radixTimes.length; n++) {
                if(radixTimes[n] > 0) {
                    for(int k = 0; k < radixTimes[n]; k++) {
                        arr[index] = radixArray[n][k];
                        index = index + 1;
                    }
                    radixTimes[n] = 0;
                }

            }
            //执到下一位 乘以10
            m=m*10;
        }
    }
    public static void bucketSort(int[]a){
        int max=Arrays.stream(a).max().getAsInt();
        int min=Arrays.stream(a).min().getAsInt();
        int []bucket =new int[max+1];
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
        int index = 0;
        for (int i = min; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[index++] = i;
            }
        }

    }


}
