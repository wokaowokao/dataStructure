package sort;

public class BubbleSort {

    static void sort(int[] data){

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] data={3,2,4,5};
        sort(data);
        System.out.println(data.toString());
    }
}
