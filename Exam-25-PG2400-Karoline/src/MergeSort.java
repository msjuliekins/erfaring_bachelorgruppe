package src;

public class MergeSort {
    public static int count;

    public static void mergeSort(double[] array) {
        // Vi deler opp arrayet i to - venstre og høyre.
        int arrayLength = array.length;

        // Stopper koden når det bare er ett element i arrayet.
        if (arrayLength <= 1) return;
        int midIndex = arrayLength / 2;
        double[] leftArray = new double[midIndex];
        double[] rightArray = new double[arrayLength - midIndex];

        //System.arraycopy(array, 0, leftArray, 0, midIndex);
        //System.arraycopy(array, midIndex, rightArray, 0, arrayLength - midIndex);
        //Vi fyller de to nye arrayene med verdier fra det originale arrayet.
        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = array[i];

        }
        for (int i = midIndex; i < arrayLength; i++) {
            rightArray[i - midIndex] = array[i];

        }

        // Gjentar prosessen rekursivt for de to delene.
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Slår sammen de to sorterte arrayene tilbake til ett.
        merge(array, leftArray, rightArray);
    }

    private static void merge(double[] array, double[] leftArray, double[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        // Indekser for venstre, høyre og hovedarrayet.
        int leftIndex = 0;
        int rightIndex = 0;
        int key = 0;

        // Sammenligner elementer fra begge arrayene og fyller hovedarrayet med de minste verdiene først.
        while (leftIndex < leftSize && rightIndex < rightSize) {
            count++;
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[key] = leftArray[leftIndex];
                leftIndex++;
                key++;
            } else {
                array[key] = rightArray[rightIndex];
                rightIndex++;
                key++;
            }
        }
        // Legger til eventuelle gjenværende elementer fra venstre array.
        while (leftIndex < leftSize) {
            array[key] = leftArray[leftIndex];
            key++;
            leftIndex++;
        }
        // Legger til eventuelle gjenværende elementer fra høyre array.
        while (rightIndex < rightSize) {
            array[key] = rightArray[rightIndex];
            key++;
            rightIndex++;
        }
    }
}
