package sort;

public class InsertSort {
    static void sort(int[] data){
        for (int i = 1; i < data.length; i++) {
            int v = data[i];
            int j = i -1;
            for (; j>=0 ; j--) {
                if (v < data[j]){
                        data[j+1] = data[j];
                }else{
                    break;
                }
            }
            data[j+1] = v;
        }

    }
    public static void main(String[] args) {
        int[] data = {2,3,5,1,6};
        sort(data);

    }
}
