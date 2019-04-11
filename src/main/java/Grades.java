import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Grades {
    private List<Double> grades;

    public Grades() {
        grades = new ArrayList<>();
    }

    public List<Double> getGrades() {
        return grades;
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

    // Collections.sort sorts the input list as a side-effect, which I didn't prefer
    // So I created a copy and sorted that.
    // You could also just sort grades.
    public void printSortedGrades() {
        List<Double> gradesCopy = new ArrayList<>(grades);
        Collections.sort(gradesCopy);

        System.out.println(gradesCopy);
    }

    public void printGradeBreakdown() {
        // TODO print the number of students who got A, B, C, D, and F
        // e.g. A: 7, B: 5, C: 2, D: 1, F: 1
    }

    public String getStudentWithHighestGrade() {
        // TODO return the student who got the highest grade
        return null;
    }

    // Simplest version of toString() for this method
//    public String toString() {
//        return grades.toString();
//    }

    // Using StringBuilder rather than less efficient string concatentation
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < grades.size() - 1; i++) {
            result.append(grades.get(i));
            result.append(", ");
        }
        result.append(grades.get(grades.size() - 1));
        result.append("]");

        return result.toString();
    }

}

