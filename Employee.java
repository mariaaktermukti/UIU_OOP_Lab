import java.util.Scanner;

public class Employee {
    private int id;
    private int workExperience;
    private double salary;
    private int[] scores;

    // Constructor
    public Employee(int id, int workExperience, double salary, int[] scores) {
        this.id = id;
        this.workExperience = workExperience;
        this.salary = salary;
        this.scores = scores;
    }

    // Method to check bonus eligibility
    public boolean bonusEligibility() {
        return (workExperience > 10 || salary < 10000);
    }

    // Method to increment salary by 20%
    public void increment() {
        salary += salary * 0.2;
    }

    // Method to calculate average score
    public double averageScore() {
        if (scores.length == 0) return 0.0;
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    // Method to display employee details and perform operations
    public void displayDetails() {
        System.out.println("\nEmployee id= " + id);
        System.out.println("workExperience in years= " + workExperience);
        System.out.println("monthly salary= " + salary);

        if (bonusEligibility()) {
            System.out.println("Eligible for bonus");
        }

        increment();
        System.out.println("incremented salary: " + salary);
        System.out.println("average score= " + averageScore());
    }

    // Main method for user input and execution
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee details
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter WorkExperience: ");
        int workExperience = scanner.nextInt();

        System.out.print("Enter Monthly Salary: ");
        double salary = scanner.nextDouble();

        System.out.print("How many months you want to calculate score: ");
        int numMonths = scanner.nextInt();

        int[] scores = new int[numMonths];
        for (int i = 0; i < numMonths; i++) {
            System.out.printf("Enter %d th month score: ", i);
            scores[i] = scanner.nextInt();
        }

        // Create Employee object and execute functions
        Employee employee = new Employee(id, workExperience, salary, scores);
        employee.displayDetails();

        scanner.close();
    }
}
