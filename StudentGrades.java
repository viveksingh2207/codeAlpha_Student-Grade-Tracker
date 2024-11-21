import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        String input;

        System.out.println("Enter student grades (or type 'done' to finish):");

        // Collect grades
        while (true) {
            System.out.print("Enter grade: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade or 'done' to finish.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered. Exiting program.");
        } else {
            // Calculate statistics
            int total = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                total += grade;
                if (grade > highest) highest = grade;
                if (grade < lowest) lowest = grade;
            }

            double average = (double) total / grades.size();

            // Display results
            System.out.println("\nGrades Summary:");
            System.out.println("Average: " + average);
            System.out.println("Highest: " + highest);
            System.out.println("Lowest: " + lowest);
        }

        scanner.close();
    }
}
