import java.io.*;

public class MergeFile{
    public static void main(String[] args) {
        String studentFile = "students.txt";
        String marksFile = "marks.txt";
        String mergedFile = "merged.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studentFile))) {
            writer.write("1079 Sharif\n");
            writer.write("1086 Labib\n");
            writer.write("2078 Amir\n");
        } catch (IOException e) {
            System.err.println("Error creating students.txt: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(marksFile))) {
            writer.write("Sharif 97\n");
            writer.write("Labib 67\n");
            writer.write("Amir 85\n");
        } catch (IOException e) {
            System.err.println("Error creating marks.txt: " + e.getMessage());
            return;
        }

        try (
                BufferedReader studentReader = new BufferedReader(new FileReader(studentFile));
                BufferedReader marksReader = new BufferedReader(new FileReader(marksFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))
        ) {
            String studentLine, marksLine;

            while ((studentLine = studentReader.readLine()) != null &&
                    (marksLine = marksReader.readLine()) != null) {

                String[] studentParts = studentLine.trim().split("\\s+");
                String[] marksParts = marksLine.trim().split("\\s+");

                if (studentParts.length >= 2 && marksParts.length >= 2)
                {
                    String id = studentParts[0];
                    String name1 = studentParts[1];
                    String name2 = marksParts[0];
                    String marks = marksParts[1];

                    if (name1.equals(name2))
                    {
                        String mergedLine = id + " " + name1 + " " + marks;
                        writer.write(mergedLine);
                        writer.newLine();
                    }
                    else
                    {
                        System.out.println("Mismatch found: " + name1 + " != " + name2);
                    }
                }
            }

            System.out.println("Merge file has completed. Check 'merged.txt'.");

        } catch (IOException e) {
            System.err.println("An error occurred during merging: " + e.getMessage());
        }
    }
}
