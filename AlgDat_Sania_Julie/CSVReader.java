import java.io.*;
import java.util.*;

public class CSVReader
{
    // Method to read data from a CSV file
    public static List<Float> read (String filePath, int columnIndex, boolean skipHeader) {
        List<Float> content = new ArrayList<>(); // List to store the parsed data

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            int lineCounter = 0;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Skip header
                if (skipHeader && lineCounter == 0) {
                    lineCounter++;
                    continue;
                }

                // Split line by comma
                String[] values = line.split(",");
                // Check if the column exists
                if (columnIndex < values.length) {
                    try {
                        // Clean data, remove quotes, trim spaces
                        String cleanedUp = values[columnIndex].replaceAll("\"", "").trim();
                        // Convert string to float and add to the list
                        float latitude = Float.parseFloat(cleanedUp);
                        content.add(latitude);
                    } catch (NumberFormatException e) {
                        // Handle case where conversion to float fails
                        e.printStackTrace();
                    }
                }
                lineCounter++; // Move to the next line
            }
        } catch (IOException e) {
            // Handle IO expections
            e.printStackTrace();
        }

        return content; // Return the list of latitudes
    }
}
