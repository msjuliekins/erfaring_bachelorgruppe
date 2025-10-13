import java.io.*;
import java.util.*;

public class Oppgave1 {
    // Non-optimized Bubble Sort
    public static List<Float> nonOptimizedBubbleSort(List<Float> unsortedList) {
        int n = unsortedList.size();
        // Compare and swap adjacent elements
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    float temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                }
            }
        }
        List<Float> NOSorted = unsortedList;
        return NOSorted;
    }

    // Optimized Bubble Sort
    public static List<Float> optimizedBubbleSort(List<Float> unsortedList) {
        int n = unsortedList.size();
        boolean swapped;
        // Compare and swap with early exit if no swaps
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    float temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break; // Exit if sorted
        }
        List<Float> OSorted = unsortedList;

        return OSorted;
    }

    public static void main(String[] args) {
        String filePath = "worldcities.csv";
        int latitudeIndex = 2;
        boolean skipHeader = true;

        CSVReader readFile = new CSVReader();
        List<Float> latitudesOptimized = readFile.read(filePath, latitudeIndex, skipHeader);
        List<Float> latitudesOptimizedShuffled = readFile.read(filePath, latitudeIndex, skipHeader);
        Collections.shuffle(latitudesOptimizedShuffled);
        List<Float> latitudesNonOptimized = readFile.read(filePath, latitudeIndex, skipHeader);

        // Perform sorting
        List<Float> NOSorted = nonOptimizedBubbleSort(latitudesNonOptimized);

        // Measure time for optimized sort
        long startO = System.currentTimeMillis();
        List<Float> OSorted = optimizedBubbleSort(latitudesOptimized);
        long endO = System.currentTimeMillis();

        // Measure time after shuffling
        long startShuffled = System.currentTimeMillis();
        List<Float> shuffledSorted = optimizedBubbleSort(latitudesOptimizedShuffled);
        long endShuffled = System.currentTimeMillis();

        // Output results
        System.out.println("Non-optimized Bubble Sort Result: ");
        for (Float num : NOSorted) {
            System.out.print(num + " ");
        }

        System.out.println("Optimized Bubble Sort Result: ");
        for (Float num : OSorted) {
            System.out.print(num + " ");
        }

        // Output time comparisons
        System.out.println("Time before shuffling in milliseconds: " + (endO-startO));
        System.out.println("Time after shuffling in milliseconds: " + (endShuffled-startShuffled));
    }
}

/*
  1b: Time complexity: 
    Best case = O(n)
    Average = O(n^2)
    Worst = O(1)

    Number of comparisons with worst case 
    = (N-1)+(N+2)+(N+3)+...2+1
    = (N-1)*(N-1+1)/2
    = (N* (N-1))/2

    Worst case -> number of comparisons = number of swaps
    happens if the list is in the opposite order

    Based on the time we get when running the sorting function before and after shuffling, the time does change 
    when shuffling the list in this case. Doing this does not guarantee a better or worse result timewise,
    but could potentially make the optimized bubble sort quicker if the new order is closer to
    or completely ordered as it doesn´t parse through the whole list unless needed.
 */
