package src;
public class InsertionSort {
    public static void insertionSort(double array[]){
        int n = array.length;
        int pass = 0;
        int comparison = 0;
        int swap = 0;
        for(int i = 1; i < n; i++){
            pass++;
            double k = array[i];
            double j = i - 1;
            while(j >= 0 && array[(int) j] > k){
                comparison++;
                array[(int) (j + 1)] = array[(int) j];
                j = j - 1;
                swap++;
            }
            array[(int) (j + 1)] = k;
        }
        System.out.println("Passes: " + pass);
        System.out.println("Comparisons: " + comparison);
        System.out.println("Swaps: " + swap);
    }
}
