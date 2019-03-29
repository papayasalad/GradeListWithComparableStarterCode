import java.util.*;

public class Grades {
    private List<String> grades;

    public Grades() {
        // TODO Default constructor initializes the empty grades ArrayList.
    }

    public void readGrades(String fileName) {
        // TODO uses the parameter filename to open the file and read in the grades from the file
    }

    public double calcAverage() {
        // TODO return average of grades or 0.0 if no grades are in list
        return 0.0;
    }

    public double dropLowest() {
        // TODO finds the lowest grade and removes it from the list, returns Double.MAX_VALUE if no grades are in list
        return Double.MAX_VALUE;
    }

    public void addGrade(double grade) {
        // TODO adds a grade to the grades field
    }

    public boolean removeAllGrades(double grade) {
        // TODO removes all the grades that match the grade passed to the method,
        // returns true if grade is found in the list, false otherwise

        return false;
    }

    public void printSortedGrades() {
        // TODO Use Collections.sort to print the sorted grades to screen
    }

    public void printGradeBreakdown() {
        // TODO print the number of students who got A, B, C, D, and F
        // e.g. A: 7, B: 5, C: 2, D: 1, F: 1
    }

    public String getStudentWithHighestGrade() {
        // TODO return the student who got the highest grade
        return null;
    }

    public String toString() {
        // TODO Return a comma-delimited list of grades surrounded by brackets
        // e.g. [23.0, 68.5, 72.5]
        // e.g. []
        return "";
    }

}

