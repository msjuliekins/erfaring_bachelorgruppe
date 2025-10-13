import java.util.*;
import java.io.*;

public class Oppgave4 {

    static int numberOfSwaps = 0; // Variable to count the number of swaps
    public static void main(String[] args) {
        String filePath = "worldcities.csv";
        int latitudeIndex = 2;
        boolean skipHeader = true;

        CSVReader readFile = new CSVReader();
        List<Float> originalLatitudes = readFile.read(filePath, latitudeIndex, skipHeader);

        // a) First element as pivot
        List<Float> latitudesFirst = new ArrayList<>(originalLatitudes);
        quickSort(latitudesFirst, 0, latitudesFirst.size() - 1, "first"); // QuickSort with first element as pivot
        System.out.println("Sorted with first element as pivot: ");
        System.out.println(latitudesFirst);
        int numberOfSwapsFirst = numberOfSwaps; // Store swaps count for first pivot strategy

        numberOfSwaps = 0; // Reset swap counter

        // b) Last element as pivot
        List<Float> latitudesLast = new ArrayList<>(originalLatitudes);
        quickSort(latitudesLast, 0, latitudesLast.size() - 1, "last"); // QuickSort with last element as pivot
        System.out.println("Sorted with last element as pivot: ");
        System.out.println(latitudesLast);
        int numberOfSwapsLast = numberOfSwaps; // Store swap count for last pivot strategy

        numberOfSwaps = 0; // Reset swap counter

        // c) Random element as pivot
        List<Float> latitudesRandom = new ArrayList<>(originalLatitudes);
        quickSort(latitudesRandom, 0, latitudesRandom.size() - 1, "random"); // QuickSort with random element as pivot
        System.out.println("Sorted with random element as pivot: ");
        System.out.println(latitudesRandom);
        int numberOfSwapsRandom = numberOfSwaps; // Store swap count for random pivot strategy
        
        // Print the number of swaps for each pivot strategy
        System.out.println("Number of swaps using first: " + numberOfSwapsFirst);
        System.out.println("Number of swaps using last: " + numberOfSwapsLast);
        System.out.println("Number of swaps using random: " + numberOfSwapsRandom);
    }

    // QuickSort function
    public static void quickSort(List<Float> list, int low, int high, String pivotStrategy) {
        if (low < high) {
            int pi = partition(list, low, high, pivotStrategy); // Find partition index
            quickSort(list, low, pi - 1, pivotStrategy); // Sort left part
            quickSort(list, pi + 1, high, pivotStrategy); // Sort right part
        }
    }

    // Partition function to reorder the list around the pivot
    public static int partition(List<Float> list, int low, int high, String pivotStrategy) {
        if (pivotStrategy.equals("first")) {
            swap(list, low, high); // Move first element to end
        } else if (pivotStrategy.equals("random")) {
            int randomIndex = new Random().nextInt(high - low + 1) + low;
            swap(list, randomIndex, high); // Move random element to end
        }

        Float pivot = list.get(high); // Pivot element
        int i = low - 1;

        // Compare elements and move them around the pivot
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j); // Swap elements
            }
            numberOfSwaps++; // Increment swap count
        }

        swap(list, i + 1, high); // Places pivot in its correct position
        return i + 1; // Return pivot index
    }

    // Swap function to exhange elements in the list
    public static void swap(List<Float> list, int i, int j) {
        Float key = list.get(i);
        list.set(i, list.get(j));
        list.set(j, key);
    }
}

/* 4b: Number counted of comparisons for each pivot strategy while sorting the dataset:
    - FIRST element: 868 362 comparisons
    - LAST element: 906 669 comparisons
    - RANDOM element: 914 215 comparisons, will vary every time it is run

The number of comparisons does change depending on the pivot selection strategy.
The random pivot strategy resulted in the most comparisons overall, altough it sometimes
produced fewer comparisons than the first element pivot when run multiple times.

Based on the number of comparisons for each pivot strategy, the first pivot selection performed the best,
it resulted in fewer comparisons.
 */