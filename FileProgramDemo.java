import java.io.*;
import java.util.*;

public class FileProgramDemo
{

    static class Employee
    {
        String name;
        String id;
        double[] scores;

        Employee(String name, String id, double[] scores)
        {
            this.name = name;
            this.id = id;
            this.scores = scores;
        }

        double average()
        {
            double sum = 0;
            for (double s : scores)
            {
                sum = sum + s;
            }
            return sum / scores.length;
        }
    }

    public static void main(String[] args)
    {
        List<Employee> employees = Arrays.asList(
                new Employee("Maria Akter Mukti",   "2331094", new double[]{85, 87, 88, 89, 90, 92}),
                new Employee("Mostafizur Rahman Shifat", "2021004", new double[]{98, 45, 67, 45, 78, 98}),
                new Employee("Virat Kohli","2331095", new double[]{95, 90, 93, 88, 92, 94})
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt"))) {
            for (Employee e : employees) {
                writer.write(e.name);
                writer.newLine();
                writer.write(e.id);
                writer.newLine();
                writer.write(String.valueOf(e.average()));
                writer.newLine();
            }
            System.out.println("employee.txt written successfully.");
        } catch (IOException ex) {
            System.err.println("Error writing employee.txt: " + ex.getMessage());
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
                BufferedWriter incWriter = new BufferedWriter(new FileWriter("increment.txt"))
        ) {
            String nameLine;
            while ((nameLine = reader.readLine()) != null)
            {
                String idLine  = reader.readLine();
                String avgLine = reader.readLine();
                double avg     = Double.parseDouble(avgLine);

                if (avg > 75.0)
                {
                    incWriter.write(nameLine);
                    incWriter.newLine();
                }
            }
            System.out.println("increment.txt written successfully.");
        } catch (IOException ex) {
            System.err.println("Error processing files: " + ex.getMessage());
        }
    }
}
