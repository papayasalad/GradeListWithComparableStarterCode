import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grades {
    private List<Double> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public void readGrades(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        while (scan.hasNextLine()) {
            grades.add(Double.parseDouble(scan.nextLine()));
        }
    }

    public double calcAverage() {
        double total = 0.0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    public double dropLowest() {
        double minGrade = Double.MAX_VALUE;
        for (double grade : grades) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        grades.remove(minGrade);
        return minGrade;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public boolean removeAllGrades(double grade) {
        return grades.removeAll(Collections.singleton(grade));
    }

    public void printSortedGrades() {
        List<Double> gradesCopy = new ArrayList<>(grades);
        Collections.sort(gradesCopy);

        for (double grade : gradesCopy) {
            System.out.print(grade + " ");
        }
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
        return Arrays.toString(grades.toArray());
    }

}

