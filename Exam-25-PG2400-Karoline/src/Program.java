package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public void readFile() throws FileNotFoundException {
        File file = new File("Files/worldcities.csv");

        try (Scanner scanner = new Scanner(file)) {
            int lineCounter = 0;
            while (scanner.hasNextLine() && lineCounter < 10) {
                String input = scanner.nextLine();
                System.out.println(input);
                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
            e.printStackTrace();
        }
    }

    public double[] readLatitudeFromFile() throws FileNotFoundException {

        File file = new File("Files/worldcities.csv");
        ArrayList<Double> latitudeList = new ArrayList<>(); // brukere ArrayList først fordi vi vet ikke hvor mye plass vi trenger
        try (Scanner scanner = new Scanner(file)) {

            if (scanner.hasNextLine()) { // skipper første linje
                scanner.nextLine();
            }
            int lineCounter = 0;
            System.out.println("Starting to read file...");
            while (scanner.hasNextLine() && lineCounter < 2500) {
                String line = scanner.nextLine();

                String[] values = line.split(",");
                lineCounter++;
                try {
                    if (values.length > 2) {
                        String latitudeString = values[2].trim().replaceAll("[^\\d.-]", ""); // vi skal ha alt som ikke er tall, '.' eller '-'
                        Double latitude = (Double) Double.parseDouble(latitudeString);
                        latitudeList.add(latitude);
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("NumberFormat Exception: invalid input string");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
            e.printStackTrace();
        }

        // Konverterer arrayList til double[] array basert på den ferdige størrelsen av ArrayList
        double[] latitudeDoubles = new double[latitudeList.size()];
        for(int i = 0; i < latitudeList.size(); i++){
            latitudeDoubles[i] = latitudeList.get(i);
        }
        return latitudeDoubles;
    }
}
