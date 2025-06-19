import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MaximumAge {
    public static void main(String[] args) {
        String filename = "person.txt";
        ensurePersonFile(filename);

        try {
            String maxId = findMaxAgeId(filename);
            System.out.println("ID of person with maximum age: " + maxId);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static void ensurePersonFile(String filename)
    {
        Path path = Paths.get(filename);
        if (Files.exists(path)) return;

        List<String> lines = Arrays.asList(
                "1/20/Bangladeshi",
                "2/23/Argentinian",
                "3/35/Portuguese"
        );
        try {
            Files.write(path, lines);
            System.out.println(filename + " created with sample data.");
        } catch (IOException e) {
            System.err.println("Failed to create " + filename + ": " + e.getMessage());
        }
    }

    public static String findMaxAgeId(String filename) throws IOException
    {
        String maxId   = null;
        int    maxAge  = Integer.MIN_VALUE;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split("/");
                if (parts.length < 2) continue;

                String id    = parts[0];
                int    age   = Integer.parseInt(parts[1]);

                if (age > maxAge)
                {
                    maxAge = age;
                    maxId  = id;
                }
            }
        }

        return maxId;
    }
}
