package sort;

public class MergeSort {

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        ///merge(a, p, q, r);
        System.out.println(p + "---"+ r);

    }



    static void sort(int[] data, int s, int e){
        System.out.println(s + "---"+ e);

        if(s>=e) return;

        //p  s    r e
        int mid = s+(e-s)/2;
         //int mid = (s+e)/2;
         sort(data, s, mid);
         sort(data, mid+1, e);
         merge(data, s, mid, e);
    }
    static void merge(int[] data, int s, int mid, int e){

        int[] temp = new int[e-s+1];
        int i = 0;
        int ss =s;
        int mids = mid;
        int ee= mids+1;
        while (ss<=mids && ee<=e){
            if(data[ss] < data[ee]){
                temp[i++] = data[ss++];
            }else{
                temp[i++] = data[ee++];
            }

        }
        if(ss> mids){
            for (int j =ee; j <= e; j++) {
                temp[i++] = data[j];
            }
        }else{
            for (int j =ss; j <= s; j++) {
                temp[i++] = data[j];
            }
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= e-s; ++i) {
            data[s+i] = temp[i];
        }

    }
    public static void main(String[] args) {
        int[] data = {2,3,5,1,6,4,8,9};
        sort(data, 0, data.length-1);

    }
}
