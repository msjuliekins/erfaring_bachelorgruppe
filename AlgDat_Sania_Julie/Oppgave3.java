import java.io.*;
import java.util.*;

public class Oppgave3 {

    static int numberOfMerges = 0; // Variable to count the number of merges

    public static void main(String[] args) {
        String filePath = "worldcities.csv";
        int latitudeIndex = 2;
        boolean skipHeader = true;

        CSVReader readFile = new CSVReader();
        List<Float> latitudes = readFile.read(filePath, latitudeIndex, skipHeader);
        
        // Perform merge sort on the latitudes list
        List<Float> sortedList = mergeSort(latitudes);

        // Print the result of the sorting
        System.out.println("Merge Sort Result: ");
        for (Float num : sortedList) {
            System.out.print(num + " ");
        }

        // Print the number of merges before shuffling
        System.out.println("Number of merges without shuffle:" + numberOfMerges);

        // Shuffles the latitudes list and sorts it again
        List<Float> latitudesShuffled = readFile.read(filePath, latitudeIndex, skipHeader);
        Collections.shuffle(latitudesShuffled);
        numberOfMerges = 0;
        mergeSort(latitudesShuffled);

        // Print the number of merges after shuffling
        System.out.println("Number of merges with shuffle: " + numberOfMerges);
    }

    // Merge sort function
    public static List<Float> mergeSort(List<Float> list) {
        if (list.size() <= 1) {
            return list; // Return if the list is empty or has one element
        }

        int mid = list.size() / 2;
        List<Float> left = new ArrayList<>(list.subList(0, mid)); // Split the list into the left half
        List<Float> right = new ArrayList<>(list.subList(mid, list.size())); // Split the list into the right half

        // Recursively sort the left and right halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the two sorted halves
        return merge(left, right);
    }

    // Merge two sorted lists into one sorted list
    public static List<Float> merge(List<Float> left, List<Float> right) {
        List<Float> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        numberOfMerges++; // Increment the number of merges for each merge operation

        // Combine the left and right lists into the mergedList
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                mergedList.add(left.get(i));
                i++;
            } else {
                mergedList.add(right.get(j));
                j++;
            }
        }

        // Add any remaining elements from the left or right list
        while (i < left.size()) {
            mergedList.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            mergedList.add(right.get(j));
            j++;
        }

        return mergedList;
    }
}

/* 
3b: When counting the number of merges before and after shuffeling the list we can see the number changes. This is due to
the risk of making a potentially somewhat sorted list more unsorted which requires more merges. The opposite may also
happen (the list becoming more sorted) which requires less merges. 

Merge Sort has a time complexity of O(n*log n). This is because the algortihm splits the list in half at each
recursion step (O(log n)) and merges the sublists in linear time (o(n)). So the number of merges may change, but the
time the process needs is the same.
*/