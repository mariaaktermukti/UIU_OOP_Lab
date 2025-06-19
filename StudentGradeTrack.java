import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeTrack {
    private final List<Integer> grades;

    public StudentGradeTrack()
    {
        grades = new ArrayList<>();
    }

    public void addGrade(int grade)
    {
        grades.add(grade);
    }
    public double calculateAverage()
    {
        if (grades.isEmpty())
        {
            return 0.0;
        }

        int sum = 0;
        for (int i = 0; i < grades.size(); i++)
        {
            int currentGrade = grades.get(i);
            sum = sum + currentGrade;
        }
        return (double) sum / grades.size();
    }

    public int highestGrade()
    {
        if (grades.isEmpty())
        {
            return 0;
        }

        int max = grades.get(0);
        for (int i = 1; i < grades.size(); i++)
        {
            int currentGrade = grades.get(i);
            if (currentGrade > max)
            {
                max = currentGrade;
            }
        }
        return max;
    }

    public void listPassingStudents()
    {
        System.out.println("Passing students:");
        for (int i = 0; i < grades.size(); i++)
        {
            int g = grades.get(i);
            if (g >= 50)
            {
                System.out.println(g);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTrack tracker = new StudentGradeTrack();

        System.out.println("Student Grade Tracker");
        while (true)
        {
            System.out.print("Enter a student's grade (or -1 to stop): ");
            int grade = scanner.nextInt();
            if (grade == -1)
            {
                break;
            }
            tracker.addGrade(grade);
        }

        double avg     = tracker.calculateAverage();
        int    highest = tracker.highestGrade();

        System.out.printf("%nAverage grade: %.1f%n", avg);
        System.out.println("Highest grade: " + highest);
        tracker.listPassingStudents();
        scanner.close();
    }
}
