import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GradesClient {
    private static final int READ = 1;
    private static final int ADD = 2;
    private static final int REMOVE = 3;
    private static final int DROP = 4;
    private static final int DISPLAY = 5;
    private static final int SORT = 6;
    private static final int AVERAGE = 7;
    private static final int BREAKDOWN = 8;
    private static final int HIGHEST = 9;
    private static final int EXIT = 10;

    private static Scanner keyboard = new Scanner(System.in);
    private Grades grades = new Grades();

    public static void main(String[] args) throws FileNotFoundException {
        int choice = -1;
        GradesClient client = new GradesClient();

        while (choice != EXIT) {
            displayMenu();

            System.out.print("Enter your numerical choice: ");
            while (!keyboard.hasNextInt()) {
                keyboard.next();
                System.out.println("You did not enter a valid number: try enter again.");
            }
            choice = Integer.parseInt(keyboard.next());

            switch (choice) {
                case READ:
                    client.readGrades();
                    break;
                case ADD:
                    client.addGrade();
                    break;
                case REMOVE:
                    client.removeAll();
                    break;
                case DROP:
                    client.dropLowest();
                    break;
                case DISPLAY:
                    client.displayGrades();
                    break;
                case SORT:
                    client.displaySorted();
                    break;
                case AVERAGE:
                    client.calcAverage();
                    break;
                case BREAKDOWN:
                    client.printGradesBreakDown();
                    break;
                case HIGHEST:
                    client.findStudentHighest();
                    break;
                default:
                    System.out.println("That choice is not valid " + choice);
            }
        }

        keyboard.close();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("1. Read grades from file");
        System.out.println("2. Add grade");
        System.out.println("3. Remove all grades");
        System.out.println("4. Drop lowest grade");
        System.out.println("5. Display grades");
        System.out.println("6. Sort grades");
        System.out.println("7. Calculate average");
        System.out.println("8. Display breakdown of grades");
        System.out.println("9. Get student name with highest grade");
        System.out.println("10. Exit");

        System.out.println("*************************************");
        System.out.println();

    }

    private void readGrades() throws FileNotFoundException {
        System.out.print("Enter a filename to read the grades from:");
        String fileName = keyboard.next();

        System.out.println(" Reading in grades from " + fileName);
        grades.readGrades(fileName);

    }

    private void calcAverage() {
        System.out.printf("Average is %.2f", grades.calcAverage());
    }

    private void addGrade() {
        System.out.print("Enter a student name to add: ");
        String name = keyboard.next();
        System.out.print("Adding a student " + name + "\nEnter a student grade to add: ");
        String number = keyboard.next();
        try {
            double score = Double.parseDouble(number);
            System.out.println("Adding grade " + score);
            Grade newGrade = new Grade(name, score);
            grades.addGrade(newGrade);
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a valid grade: " + e.getMessage());
        }

    }

    private void removeAll() {
        System.out.print("Enter a grade to remove:");
        while (!keyboard.hasNextDouble()) {
            keyboard.next();
            System.out.println("You did not enter a valid grade: try again.");
            System.out.print("Enter a grade to remove:");
        }
        double grade = Double.parseDouble(keyboard.next());

        boolean removed = grades.removeAllGrades(grade);
        if (removed) {
            System.out.println("Removed ALL grades = " + grade);
        } else {
            System.out.println("No grade," + grade + ", found to remove");
        }

    }

    private void dropLowest() {
        System.out.println("Lowest grade dropped: " + grades.dropLowest());
    }

    private void displayGrades() {
        System.out.println(grades);
    }

    private void displaySorted() {
        grades.printSortedGrades();
    }

    private void printGradesBreakDown() {
        System.out.println("Here is a breakdown of grades.");
        grades.printGradeBreakdown();
    }

    private void findStudentHighest() {
        System.out.println(grades.getStudentWithHighestGrade() + " has the highest score.");
    }

}
