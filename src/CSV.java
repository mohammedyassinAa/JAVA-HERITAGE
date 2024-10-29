import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CSV {

    public static void main(String[] args) {
        Map<String, Integer> genreCounts = genreCalc("C:\\Users\\hp\\Desktop\\actors.csv");
        writeResultsToJson(genreCounts, "C:\\Users\\hp\\Desktop\\genreCounts.json");
    }

    public static Map<String, Integer> genreCalc(String filePath) {
        Map<String, Integer> genreCountMap = new HashMap<>();
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] actorData = line.split(splitBy);
                
                // Assuming that genre is at index 1. Adjust based on actual CSV structure.
                String genre = actorData[1];

                // Update count in the map
                genreCountMap.put(genre, genreCountMap.getOrDefault(genre, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return genreCountMap;
    }

    public static void writeResultsToJson(Map<String, Integer> genreCounts, String outputFilePath) {
        // Create a Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the genreCounts map to JSON and write to a file
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            gson.toJson(genreCounts, fileWriter);
            System.out.println("Genre counts successfully written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
