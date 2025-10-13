package src;

public class QuickSort {
    static int count = 0;
    // QuickSort-funksjon som kan brukes i andre klasser.
    // Den setter automatisk start- og sluttindeksen for sorteringen.
    public static void quickSort(double[] array, String pivotPosition) {
        quickSort(array, 0, array.length - 1, pivotPosition);
    }

    // Hovedfunksjonen for QuickSort som deler opp arrayet og sorterer delene rekursivt.
    public static void quickSort(double[] array, int startIndex, int endIndex, String pivotPosition) {
        // Stopper rekursjonen hvis det ikke er noe mer å sortere.
        if (startIndex >= endIndex) return;

        int pivotIndex = partition(array, startIndex, endIndex, pivotPosition);
        quickSort(array, startIndex, pivotIndex - 1, pivotPosition);
        quickSort(array, pivotIndex + 1, endIndex, pivotPosition);
    }

    // Funksjon som velger pivot basert på posisjonen og organiserer elementene.
    // Elementer mindre enn pivot plasseres til, venstre, og større elementer til høyre.
    public static int partition(double[] array, int startIndex, int endIndex, String pivotPosition) {
        int pivotIndex;
        switch (pivotPosition) {
            case "first" -> pivotIndex = startIndex;
            case "last" -> pivotIndex = endIndex;
            case "random" -> pivotIndex = (int) (Math.random() * (endIndex - startIndex + 1) + startIndex);
            case null, default ->
                    throw new IllegalArgumentException("Please use valid pivot position(last, first or random).");

        }
        // // Flytter pivot til slutten av området som sorteres for å gjøre sammenligninger enklere.
        if (pivotIndex != endIndex) {
            swap(array, pivotIndex, endIndex); // Flytter pivot til slutten hvis det er nødvendig
        }
        double pivot = array[endIndex];
        int i = startIndex - 1;
        // Går gjennom elementene og flytter de mindre enn pivot til venstre.
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                count++;
            }
        }
        swap(array, i + 1, endIndex); // Plasserer pivot på sin endelige plass i den sorterte delen.

        return i + 1;
    }

    // Funksjon som bytter plass på to elementer i arrayet.
    public static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
