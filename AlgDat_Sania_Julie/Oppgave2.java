import java.util.*;
import java.io.*;

public class Oppgave2 {

    static int numberOfInserts = 0;
    
    public static void main(String[] args) {
        String filePath = "worldcities.csv";
        int latitudeIndex = 2;
        boolean skipHeader = true;

        CSVReader readFile = new CSVReader();
        List<Float> latitudes = readFile.read(filePath, latitudeIndex, skipHeader);
        
        // Perform insertion sort
        List<Float> sortedList = insertionSort(latitudes);

        // Print sorted list
        System.out.println("Insertion Sort Result: ");
        for (float num : sortedList) {
            System.out.print(num + " ");
        }

        // Print number of inserts before shuffling
        System.out.println("Number of inserts without shuffle:" + numberOfInserts);

        // Shuffle list and count inserts again
        List<Float> latitudesShuffled = readFile.read(filePath, latitudeIndex, skipHeader);
        Collections.shuffle(latitudesShuffled);
        numberOfInserts = 0;
        insertionSort(latitudesShuffled);

        // Print number of inserts after shuffling
        System.out.println("Number of inserts with shuffle: " + numberOfInserts);
    }

    public static List<Float> insertionSort(List<Float> unsortedList){
        int n = unsortedList.size();
        // Loops through each elements starting from the second
        for (int i = 1; i < n; i++){
            float key = unsortedList.get(i);
            int j = i-1;

            // Moves elements that are greater than key to one position ahead
            while (j >= 0 && key < unsortedList.get(j)) {
                unsortedList.set(j+1, unsortedList.get(j));
                j--;
                numberOfInserts++; // Counts each insertion
            }
            // Place key in its correct position
            unsortedList.set(j + 1, key);
        }
        
    
        List<Float> sortedList = unsortedList;

        return sortedList;
    }
}

/*
 * 2b: when counting the time complexity for this time of sort it is possible to get very different results
 * when shuffeling as the number of inserts is reliable on how close to being sorted the list is. 
 * 
 * Worst case for this sorting algorithm would be a count of (n-1) for every element where n is the number of elements 
 * in the list, and this results in the time complexity being O(n^2)
 * An average case will also have the same time complexity no matter how it is shuffled as the algorithm will
 * have to compare every element because of the list not being fully sorted.
 * 
 * Best case would be the list already being sorted so the timecolplexity would be O(n) with the algorithm just needing
 * to check the elements without doing anthing to them.
 */
