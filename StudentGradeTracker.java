import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static class Student {
        String name;
        double[] marks;

        Student(String name, double[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double getAverage() {
            double total = 0;

            for (double mark : marks) {
                total += mark;
            }

            return total / marks.length;
        }

        double getHighest() {
            double highest = marks[0];

            for (double mark : marks) {
                if (mark > highest) {
                    highest = mark;
                }
            }

            return highest;
        }

        double getLowest() {
            double lowest = marks[0];

            for (double mark : marks) {
                if (mark < lowest) {
                    lowest = mark;
                }
            }

            return lowest;
        }

        String getGrade() {
            double average = getAverage();

            if (average >= 90) return "A+";
            else if (average >= 80) return "A";
            else if (average >= 70) return "B";
            else if (average >= 60) return "C";
            else if (average >= 50) return "D";
            else return "F";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== STUDENT GRADE TRACKER =====");

        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine();

        if (count <= 0 || subjects <= 0) {
            System.out.println("Please enter positive numbers.");
            sc.close();
            return;
        }

        for (int i = 0; i < count; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            double[] marks = new double[subjects];

            for (int j = 0; j < subjects; j++) {
                while (true) {
                    System.out.print("Enter marks for subject "
                            + (j + 1) + " (0-100): ");

                    double mark = sc.nextDouble();

                    if (mark >= 0 && mark <= 100) {
                        marks[j] = mark;
                        break;
                    }

                    System.out.println("Invalid marks! Enter 0 to 100.");
                }
            }

            sc.nextLine();
            students.add(new Student(name, marks));
        }

        System.out.println("\n===== STUDENT REPORT =====");

        for (Student student : students) {

            System.out.println("\nStudent Name: " + student.name);
            System.out.printf("Average: %.2f%n", student.getAverage());
            System.out.println("Highest Marks: " + student.getHighest());
            System.out.println("Lowest Marks: " + student.getLowest());
            System.out.println("Grade: " + student.getGrade());
        }

        sc.close();
    }
}
