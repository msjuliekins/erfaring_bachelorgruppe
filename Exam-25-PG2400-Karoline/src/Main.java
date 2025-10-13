package src;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        try {
            double[] latitudeData = program.readLatitudeFromFile();
            //BubbleSort.bubbleSortOptimized(latitudeData);
            //BubbleSort.bubbleSortUnoptimized(latitudeData);
            //InsertionSort.insertionSort(latitudeData);
            //MergeSort.mergeSort(latitudeData);
            //QuickSort.quickSort(latitudeData,"random");
            System.out.println("Sorted Latitudes:");
            for (double latitude : latitudeData) {
                System.out.println(latitude);
            }
            System.out.println("Number of comparisons: " + QuickSort.count);

        } catch (FileNotFoundException e) {
            System.out.println("Error when calling method readFile" + e.getMessage());
            e.printStackTrace();
        }
    }
}
