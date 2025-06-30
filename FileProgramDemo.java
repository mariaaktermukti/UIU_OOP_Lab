import java.io.*;
import java.util.*;

public class FileProgramDemo {

    static class Employee {
        String name;
        String id;
        double[] scores;

        Employee(String name, String id, double[] scores) {
            this.name = name;
            this.id = id;
            this.scores = scores;
        }

        double average() {
            double sum = 0;
            for (double s : scores) {
                sum += s;
            }
            return sum / scores.length;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for Employee " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("ID: ");
            String id = sc.nextLine();

            double[] scores = new double[6];
            System.out.println("Enter 6 performance scores (space separated): ");
            for (int j = 0; j < 6; j++) {
                scores[j] = sc.nextDouble();
            }
            sc.nextLine();

            employees.add(new Employee(name, id, scores));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt"))) {
            for (Employee e : employees)
            {
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
                String idLine = reader.readLine();
                String avgLine = reader.readLine();
                double avg = Double.parseDouble(avgLine);

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
