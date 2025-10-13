package src;
public class BubbleSort {
    public static void bubbleSortOptimized(double array[]){
        int n = array.length;
        // Counts to keep track of number of passes, comparisons and swaps
        int pass = 0;
        int comparison = 0;
        int swap = 0;
        // Optimizing: check if there is need to sort more
        boolean swapped;
        for(int i = 0; i < n - 1; i++){
            pass++;
            swapped = false;
            for(int j = 0; j < n - 1 -i; j++){
                comparison++;
                if(array[j] > array[j + 1]){
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap++;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        System.out.println("Number of passes: " + pass);
        System.out.println("Number of comparisons: " + comparison);
        System.out.println("Number of swaps: " + swap);
    }

    // Geeksforgeeks. (2024, October 22). Java Program for Bubble Sort. Retrieved March 28. 2025, from https://www.geeksforgeeks.org/java-program-for-bubble-sort/

    public static void bubbleSortUnoptimized(double array[]){
        int n = array.length;
        int pass = 0;
        int comparison = 0;
        int swap = 0;
        for(int i = 0; i < n - 1; i++){
            pass++;
            for(int j = 0; j < n - 1 - i; j++){
                comparison++;
                if(array[j] > array[j+1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap++;
                }
            }
        }
        System.out.println("Number of passes: " + pass);
        System.out.println("Number of comparisons: " + comparison);
        System.out.println("Number of swaps: " + swap);
    }
}

